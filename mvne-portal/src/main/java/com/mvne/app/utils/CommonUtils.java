package com.mvne.app.utils;


import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import com.mvne.app.exception.SystemException;


public final class CommonUtils {
	
	/**
	 * 字符串转换为数字
	 * @param str
	 * @return
	 */
	public static int parseInt(Object str){
		try{
			if(CommonUtils.checkNull(str)){
				str="0";
			}
			return Integer.parseInt(str+"");
		}catch (Exception e){
			throw new SystemException("数字转换出错,原始转换值为:"+str);
		}
	}
	
	/**
	 * 字符串转换为Long类型的
	 * @param str
	 * @return
	 */
	public static long parseLong(Object str){
		try{
			if(CommonUtils.checkNull(str))
				str = "0";
			return Long.parseLong(str+"");
		}catch(Exception e){
			throw new SystemException("数字转换出错,原始转换值为:"+str);
		}
	}

	/**
	 * 检查是否为空
	 * @param o
	 * @return true-空,false
	 */
	public static boolean checkNull(Object o){
		if(o==null || "".equals(o.toString())){
			return true;
		}
		return false;
	}
	
	/**
	 * 检查对象是否为空,如果为NULL返回""
	 * @param str
	 * @return
	 */
	public static String setNull(String str){
		return str==null?"":str;
	}
	
	public static void clealLtoMap(Object o){
		if(o instanceof Collection){
			Collection lt=(Collection) o;
			lt.clear();lt=null;
		}else if(o instanceof Map){
			Map map=(Map)o;
			map.clear();map=null;
		}else{
			o=null;
		}
	}
	
	/**
	 * 检查对象是否为空,list or map size<1
	 * @param obj
	 * @return true-yes ,false-no
	 */
	public static boolean checkObjEmpty(Object obj){
		if(obj==null){
			return true;
		}
		if(obj instanceof Collection){
			Collection lt=(Collection)obj;
			if(lt.size()<1){
				return true;
			}
		}else if(obj instanceof Map){
			Map map=(Map)obj;
			if(map.size()<1){
				return true;
			}
		}
		return false;
	}

	public static int getIndex(long[] ths,long fee){
		Arrays.sort(ths);
		for(int i=ths.length-1;i>=0;i--){
			if(fee>=ths[i]){
				return i+1;
			}
		}
		return 1;
	}
	
	
	public static void addAllToLt(List targetLt,List toAddLt){
	    if(toAddLt!=null&&toAddLt.size()>0){
	        targetLt.addAll(toAddLt);
	    }
	}
	
	public static void addAllToMap(Map<String,List> targetMap,Map<String,List> toAddMap){
	    Iterator it = toAddMap.keySet().iterator();
	    while(it.hasNext()){
	        String key = (String)it.next();
	        List toAddLt = toAddMap.get(key);
	        if(targetMap.get(key)==null){
	            targetMap.put(key, toAddLt);
	        }else{
	            addAllToLt(targetMap.get(key),toAddLt);
	        }
	    }
    }
	
	
	public static void main(String[] args) {
	}
}
