package com.mvne.app.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;

public class FTPUtil
{

	FTPClient ftpClient = new FTPClient();

	private void connect()
	{
		try
		{
			if (ftpClient == null || ftpClient.isConnected() == false)
			{
				// 1、加载资源文件
				Properties properties = getProperties("src/main/resources/ftp.properties");
				String ServerIP = properties.getProperty("FTP.ServerIP");
				int Port = Integer.parseInt(properties.getProperty("FTP.ServerPort"));
				String UserName = properties.getProperty("FTP.UserName");
				String Password = properties.getProperty("FTP.Password");

				// 2.连接服务器
				ftpClient.connect(ServerIP, Port);

				// 3.登录服务器 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
				ftpClient.login(UserName, Password);

				// 4.判断登陆是否成功
				boolean LoginState = FTPReply.isPositiveCompletion(ftpClient.getReplyCode());
				if (LoginState == false)
				{
					if (ftpClient != null && ftpClient.isConnected() == true)
					{
						ftpClient.logout();
						ftpClient.disconnect();
						// 释放空间
						ftpClient = null;
					}

					// 返回FTP登录状态信息
					throw new Exception(ftpClient.getReplyString());
				}

				FTPClientConfig ClientConfig = null;
				// ClientConfig = new FTPClientConfig(FTPClientConfig.SYST_NT);
				ClientConfig = new FTPClientConfig("org.apache.commons.net.ftp.parser.UnixFTPEntryParser");
				ClientConfig.setServerLanguageCode("zh");
				ClientConfig.setDefaultDateFormatStr("yyyy-MM-dd");

				// 1.初始化属性设置
				// 设置连接超时为60秒
				ftpClient.setConnectTimeout(60 * 1000);
				// 设置传输超时时间为60秒
				ftpClient.setDataTimeout(60 * 1000);
				// 设置文件缓冲区
				ftpClient.setBufferSize(1024 * 1024 * 10);
				// 设置编码格式为UTF-8
				ftpClient.setControlEncoding("UTF-8");
				// 设置主动模式
				// ftpClient.enterLocalActiveMode();
				// 设置被动模式
				ftpClient.enterLocalPassiveMode();
				// 设置文件类型[以二进制格式上传]
				ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
				ftpClient.configure(ClientConfig);
				// 设置上传的目录
				// ftpClient.changeWorkingDirectory("");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean uploadFile(InputStream localInputStream, String remoteFilePath, String remoteFileName)
	{
		boolean Result = true;

		try
		{
			// 连接FTP服务器
			connect();
			// 设置上传的目录
			if (remoteFilePath != null)
			{
				// 设置上传的目录
				ftpClient.changeWorkingDirectory(remoteFilePath);
			}

			Result = ftpClient.storeFile(remoteFileName, localInputStream);
		} catch (Exception e)
		{
			Result = false;
			e.printStackTrace();
		} finally
		{
			if (localInputStream != null)
			{
				try
				{
					localInputStream.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return Result;
	}

	public boolean downloadFile(String pathname, String downloadpath)
	{
		boolean Result = true;

		OutputStream outputStream = null;
		try
		{
			// 连接FTP服务器
			connect();
			File file = new File(pathname);
			File localFile = new File(downloadpath + "\\" + file.getName());
			outputStream = new FileOutputStream(localFile);
			ftpClient.retrieveFile(pathname, outputStream);
			outputStream.close();
		} catch (Exception e)
		{
			Result = false;
			e.printStackTrace();
		}
		return Result;
	}

	public Properties getProperties(String path)
	{
		Properties properties = new Properties();
		try
		{
			File file = new File(path);
			InputStream inputStream = new FileInputStream(file);
			properties.load(inputStream);

			// 释放资源
			inputStream.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return properties;
	}
}
