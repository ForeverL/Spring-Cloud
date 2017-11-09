package com.mvne.app.utils;

import java.util.Collection;
import java.util.Map;


/***********************************************************  
* @ClassName : ArrayUtil  
* @Description : TODO(这里用一句话描述这个类的作用)  
* @author :Hanson
* @date :2017年10月29日 下午4:33:18  
***********************************************************/ 
public abstract class ArrayUtil
{
	public static boolean isEmpty(Map<? extends Object, ? extends Object> m)
	{
		return m == null || m.size() == 0;
	}

	public static boolean isNotEmpty(Map<? extends Object, ? extends Object> m)
	{
		return !isEmpty(m);
	}

	public static boolean isEmpty(Collection<? extends Object> c)
	{
		return c == null || c.size() == 0;
	}

	public static boolean isNotEmpty(Collection<? extends Object> c)
	{
		return !isEmpty(c);
	}

	/**
	 * Peek the first item of given collection, return default value instead if given collection is null or empty.
	 * 
	 * @param c source collection.
	 * @param defaultValue the default value if expect value is null.
	 * @return first item of given collection or default value if given collection is null or empty.
	 */
//	public static Object peek(Collection<? extends Object> c, Object defaultValue)
//	{
//		if (isNotEmpty(c))
//		{
//			return c.iterator().next();
//		}
//		else
//		{
//			return defaultValue;
//		}
//	}
}
