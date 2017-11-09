package com.mvne.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.filechooser.FileSystemView;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mvne.app.domain.ReturnData;
import com.mvne.app.utils.FTPUtil;
import com.mvne.app.utils.PropertiesUtil;


@RestController
@RequestMapping("/portal")
public class FileController {
	private Logger logger = Logger.getLogger(getClass());
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		logger.info("here!");
		return "SUCCESS";
	}

	
	@RequestMapping(value = "/uploadPic", method = RequestMethod.POST)
	public ReturnData uploadPic(@RequestParam("imageFile") MultipartFile file) {
		
		logger.info("客户中心上传图片接口 ， 输入为： " + file);
		
		ReturnData returnData = new ReturnData();

		String ImageServerURL = null;
		try {
			if (ImageServerURL == null || ImageServerURL.length() <= 0) {
				PropertiesUtil propertiesUtil = new PropertiesUtil();
				Properties properties = propertiesUtil
						.load("src/main/resources/ftp.properties");
				ImageServerURL = properties.getProperty("Image.ServerIP");
			}

			// 获取文件名
			String fileName = file.getOriginalFilename();

			// 将本地图片名称转为日期格式上传
			SimpleDateFormat formatter = new SimpleDateFormat(
					"YYYYMMddHHmmssSSS");
			String filesuffix = fileName.substring(fileName.lastIndexOf("."),
					fileName.length());
			String remoteImageName = formatter.format(new Date()) + filesuffix;

			FTPUtil ftpUtil = new FTPUtil();
			boolean Result = ftpUtil.uploadFile(file.getInputStream(), null,
					remoteImageName);
			if (Result == true) {
				returnData.setReturnObject(ImageServerURL + "/"
						+ remoteImageName);
				returnData.setCode("0000");
				returnData.setMessage("图片上传完成!");
			} else {
				returnData.setCode("3000");
				returnData.setMessage("图片上传失败,请联系管理员!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnData;
	}

	@RequestMapping(value = "/downloadPic/{picId}", method = RequestMethod.GET)
	public ReturnData downloadPic(@PathVariable("picId") String id) {
		ReturnData returnData = new ReturnData();

		FTPUtil ftpUtil = new FTPUtil();

		String desktopPath = FileSystemView.getFileSystemView()
				.getHomeDirectory().getPath();
		boolean Result = ftpUtil.downloadFile("/" + id + ".jpg", desktopPath);
		if (Result == true) {
			returnData.setCode("0000");
			returnData.setMessage("图片下载完成!");
		} else {
			returnData.setCode("3000");
			returnData.setMessage("图片下载失败,请联系管理员!");
		}
		return returnData;
	}
	
	
}