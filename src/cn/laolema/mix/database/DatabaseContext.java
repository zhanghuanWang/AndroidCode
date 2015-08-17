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
package cn.laolema.mix.database;

import java.io.File;
import java.io.IOException;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * FileName: DatabaseContext.java
 * 
 * @version v1.0
 * @author WangZhanghuan
 * @date：2015-08-17 16:29:22
 */
public class DatabaseContext extends ContextWrapper {

	private Context mContext;
	private String dirName;
	private boolean isSDDir;

	/**
	 * 构造函数
	 * 
	 * @param context
	 *            上下文环境
	 */
	public DatabaseContext(Context context) {
		this(context, null, false);
	}

	public DatabaseContext(Context context, boolean isSdDir) {
		this(context, null, isSdDir);
	}

	/**
	 * 构造函数
	 * 
	 * @param context
	 * @param dirName
	 */
	public DatabaseContext(Context context, String dirName) {
		this(context, dirName, false);
	}

	public DatabaseContext(Context context, String dirName, boolean isSdDir) {
		super(context);
		this.mContext = context;
		this.dirName = dirName;
		this.isSDDir = isSdDir;
	}

	/**
	 * 获得数据库路径，如果不存在，则创建对象对象
	 * 
	 * @param name
	 */
	@Override
	public File getDatabasePath(String name) {
		if (isSDDir) {
			return getDatabaseSdPath(name);
		}
		return super.getDatabasePath(name);
	}

	private File getDatabaseSdPath(String name) {
		// 判断是否存在sd卡
		boolean sdExist = android.os.Environment.MEDIA_MOUNTED
				.equals(android.os.Environment.getExternalStorageState());
		if (!sdExist) {// 如果不存在,
			return null;
		} else {// 如果存在
			// 获取sd卡路径
			String dbDir = android.os.Environment.getExternalStorageDirectory()
					.getAbsolutePath();
			dbDir += File.separator
					+ ((dirName == null || "".equals(dirName)) ? mContext
							.getPackageName() : dirName);// 数据库所在目录

			String dbPath = dbDir + File.separator + name;// 数据库路径
			// 判断目录是否存在，不存在则创建该目录
			File dirFile = new File(dbDir);
			if (!dirFile.exists())
				dirFile.mkdirs();

			// 数据库文件是否创建成功
			boolean isFileCreateSuccess = false;
			// 判断文件是否存在，不存在则创建该文件
			File dbFile = new File(dbPath);
			if (!dbFile.exists()) {
				try {
					isFileCreateSuccess = dbFile.createNewFile();// 创建文件
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else
				isFileCreateSuccess = true;

			// 返回数据库文件对象
			if (isFileCreateSuccess)
				return dbFile;
			else
				return null;
		}
	}

	/**
	 * 重载这个方法，是用来打开SD卡上的数据库的，android 2.3及以下会调用这个方法。
	 * 
	 * @param name
	 * @param mode
	 * @param factory
	 */
	@Override
	public SQLiteDatabase openOrCreateDatabase(String name, int mode,
			SQLiteDatabase.CursorFactory factory) {
		if (isSDDir) {
			SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(
					getDatabasePath(name), null);
			return result;
		}
		return super.openOrCreateDatabase(name, mode, factory);
	}

	/**
	 * Android 4.0会调用此方法获取数据库。
	 * 
	 * @see android.content.ContextWrapper#openOrCreateDatabase(java.lang.String,
	 *      int, android.database.sqlite.SQLiteDatabase.CursorFactory,
	 *      android.database.DatabaseErrorHandler)
	 * @param name
	 * @param mode
	 * @param factory
	 * @param errorHandler
	 */
	@Override
	public SQLiteDatabase openOrCreateDatabase(String name, int mode,
			CursorFactory factory, DatabaseErrorHandler errorHandler) {
		if (isSDDir) {
			SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(
					getDatabasePath(name), null);
			return result;
		}
		return super.openOrCreateDatabase(name, mode, factory, errorHandler);
	}
}