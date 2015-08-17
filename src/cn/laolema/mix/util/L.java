/*
 * CopyRright (c) laolema.cn: 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.laolema.mix.util;

import android.content.Context;
import android.util.Log;

/** 
* FileName: L.java 
* description：LogUtil
* @version v1.0
* @author WangZhanghuan
* @date：2015-08-15 22:22:22
*/ 
public class L {
	
    /** debug FLAG */
	public static boolean D ;
	
	/** info FLAG */
	public static boolean I ;
	
	/** error FLAG */
	public static boolean E ;
	
	/** VERBOSE FLAG */
	public static boolean V ;
	
	/** WARN FLAG */
	public static boolean W ;
	
	/**
	 * @param d
	 */
	public static void debug(boolean d) {
		D  = d;
	}
	
	/**
	 * @param i
	 */
	public static void info(boolean i) {
		I  = i;
	}
	
	/**
	 * @param e
	 */
	public static void error(boolean e) {
		E  = e;
	}
	
	/**
	 * @param w
	 */
	public static void warn(boolean w) {
		W  = w;
	}
	
	/**
	 * @param d
	 * @param i
	 * @param e
	 * @param w
	 */
	public static void setLog(boolean d, boolean i, boolean e, boolean w) {
		D  = d;
		I  = i;
		E  = e;
		W  = w;
	}
	
	/**
	 * open all log flag
	 */
	public static void openAll() {
		D  = true;
		I  = true;
		E  = true;
		W  = true;
	}
	
	/**
	 * close all log flag
	 */
	public static void closeAll() {
		D  = false;
		I  = false;
		E  = false;
		W  = false;
	}
		

	/**
     * Send {@link #Log} 
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
	public static void d(String tag, String msg) {
		if(D) Log.d(tag, msg);
		
	} 
	
	/**
	 * Send {@link #Log} 
	 * @param context Used to identify the source of a log message. 
	 * @param msg The message you would like logged.
	 */
	public static void d(Context context, String msg) {
		if(D) {
			String tag = context.getClass().getSimpleName();
			Log.d(tag, msg);
		}
		
	} 
	
	/**
	 * Send {@link #Log} 
	 * @param context Used to identify the source of a log message. 
	 * @param msg The message you would like logged.
	 */
	public static void d(Class<?> clazz, String msg) {
		if(D) {
			String tag = clazz.getSimpleName();
			Log.d(tag, msg);
		}
		
	} 
	
	/**
     * Send {@link #Log} 
     * @param tag Used to identify the source of a log message.  It usually identifies
     *        the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
	public static void d(String tag, String msg, Throwable tr) {
		if(D) Log.d(tag, msg, tr);
	}
	
	/**
	 * Send {@link #Log} 
	 * @param tag Used to identify the source of a log message.  
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	public static void d(Context context, String msg, Throwable tr) {
		if(D) {
			String tag = context.getClass().getSimpleName();
			Log.d(tag, msg, tr);
		}
	}
	
	/**
	 * Send {@link #Log} 
	 * @param tag Used to identify the source of a log message. 
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	public static void d(Class<?> clazz, String msg, Throwable tr) {
		if(D) {
			String tag = clazz.getSimpleName();
			Log.d(tag, msg, tr);
		}
	}
	
	/**
	 * Send {@link #Log} 
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	public static void i(String tag, String msg) {
		if(I) Log.i(tag, msg);
		
	} 
	
	/**
	 * Send {@link #Log} 
	 * @param context Used to identify the source of a log message. 
	 * @param msg The message you would like logged.
	 */
	public static void i(Context context, String msg) {
		if(I) {
			String tag = context.getClass().getSimpleName();
			Log.i(tag, msg);
		}
		
	} 
	
	/**
	 * Send {@link #Log} 
	 * @param context Used to identify the source of a log message. 
	 * @param msg The message you would like logged.
	 */
	public static void i(Class<?> clazz, String msg) {
		if(I) {
			String tag = clazz.getSimpleName();
			Log.i(tag, msg);
		}
		
	} 
	
	/**
	 * Send {@link #Log} 
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	public static void i(String tag, String msg, Throwable tr) {
		if(I) Log.i(tag, msg, tr);
	}
	
	/**
	 * Send {@link #Log} 
	 * @param tag Used to identify the source of a log message.  
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	public static void i(Context context, String msg, Throwable tr) {
		if(I) {
			String tag = context.getClass().getSimpleName();
			Log.i(tag, msg, tr);
		}
	}
	
	/**
	 * Send {@link #Log} 
	 * @param tag Used to identify the source of a log message. 
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	public static void i(Class<?> clazz, String msg, Throwable tr) {
		if(I) {
			String tag = clazz.getSimpleName();
			Log.d(tag, msg, tr);
		}
	}
	
	/**
	 * Send {@link #Log} 
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	public static void v(String tag, String msg) {
		if(V) Log.v(tag, msg);
		
	} 
	
	/**
	 * Send {@link #Log} 
	 * @param context Used to identify the source of a log message. 
	 * @param msg The message you would like logged.
	 */
	public static void v(Context context, String msg) {
		if(V) {
			String tag = context.getClass().getSimpleName();
			Log.v(tag, msg);
		}
		
	} 
	
	/**
	 * Send {@link #Log} 
	 * @param context Used to identify the source of a log message. 
	 * @param msg The message you would like logged.
	 */
	public static void v(Class<?> clazz, String msg) {
		if(V) {
			String tag = clazz.getSimpleName();
			Log.v(tag, msg);
		}
		
	} 
	
	/**
	 * Send {@link #Log} 
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	public static void v(String tag, String msg, Throwable tr) {
		if(V) Log.v(tag, msg, tr);
	}
	
	/**
	 * Send {@link #Log} 
	 * @param tag Used to identify the source of a log message.  
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	public static void v(Context context, String msg, Throwable tr) {
		if(V) {
			String tag = context.getClass().getSimpleName();
			Log.i(tag, msg, tr);
		}
	}
	
	/**
	 * Send {@link #Log} 
	 * @param tag Used to identify the source of a log message. 
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	public static void v(Class<?> clazz, String msg, Throwable tr) {
		if(V) {
			String tag = clazz.getSimpleName();
			Log.d(tag, msg, tr);
		}
	}
	
	/**
	 * Send {@link #Log} 
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	public static void e(String tag, String msg) {
		if(E) Log.e(tag, msg);
		
	} 
	
	/**
	 * Send {@link #Log} 
	 * @param context Used to identify the source of a log message. 
	 * @param msg The message you would like logged.
	 */
	public static void e(Context context, String msg) {
		if(E) {
			String tag = context.getClass().getSimpleName();
			Log.e(tag, msg);
		}
		
	} 
	
	/**
	 * Send {@link #Log} 
	 * @param context Used to identify the source of a log message. 
	 * @param msg The message you would like logged.
	 */
	public static void e(Class<?> clazz, String msg) {
		if(E) {
			String tag = clazz.getSimpleName();
			Log.e(tag, msg);
		}
		
	} 
	
	/**
	 * Send {@link #Log} 
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	public static void e(String tag, String msg, Throwable tr) {
		if(E) Log.e(tag, msg, tr);
	}
	
	/**
	 * Send {@link #Log} 
	 * @param tag Used to identify the source of a log message.  
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	public static void e(Context context, String msg, Throwable tr) {
		if(E) {
			String tag = context.getClass().getSimpleName();
			Log.e(tag, msg, tr);
		}
	}
	
	/**
	 * Send {@link #Log} 
	 * @param tag Used to identify the source of a log message. 
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	public static void e(Class<?> clazz, String msg, Throwable tr) {
		if(E) {
			String tag = clazz.getSimpleName();
			Log.e(tag, msg, tr);
		}
	}
	
	/**
	 * Send {@link #Log} 
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	public static void w(String tag, String msg) {
		if(W) Log.w(tag, msg);
		
	} 
	
	/**
	 * Send {@link #Log} 
	 * @param context Used to identify the source of a log message. 
	 * @param msg The message you would like logged.
	 */
	public static void w(Context context, String msg) {
		if(W) {
			String tag = context.getClass().getSimpleName();
			Log.w(tag, msg);
		}
		
	} 
	
	/**
	 * Send {@link #Log} 
	 * @param context Used to identify the source of a log message. 
	 * @param msg The message you would like logged.
	 */
	public static void w(Class<?> clazz, String msg) {
		if(W) {
			String tag = clazz.getSimpleName();
			Log.w(tag, msg);
		}
		
	} 
	
	/**
	 * Send {@link #Log} 
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	public static void w(String tag, String msg, Throwable tr) {
		if(W) Log.w(tag, msg, tr);
	}
	
	/**
	 * Send {@link #Log} 
	 * @param tag Used to identify the source of a log message.  
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	public static void w(Context context, String msg, Throwable tr) {
		if(W) {
			String tag = context.getClass().getSimpleName();
			Log.w(tag, msg, tr);
		}
	}
	
	/**
	 * Send {@link #Log} 
	 * @param tag Used to identify the source of a log message. 
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	public static void w(Class<?> clazz, String msg, Throwable tr) {
		if(W) {
			String tag = clazz.getSimpleName();
			Log.w(tag, msg, tr);
		}
	}

}
