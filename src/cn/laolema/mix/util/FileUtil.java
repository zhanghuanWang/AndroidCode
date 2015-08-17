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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import android.content.Context;
import android.os.Environment;

/**
 * FileName: L.java description：LogUtil
 * 
 * @version v1.0
 * @author WangZhanghuan
 * @date：2015-08-15 22:22:22
 */

public class FileUtil {

	public static String mSdRootPath;
	public static String mDataRootPath;
	public static String mAvailableRootPath;
	public static boolean isSdAvailable;

	public static void init(Context context) {
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)) {
			isSdAvailable = true;
			File externalStorageDirectory = Environment
					.getExternalStorageDirectory();
			if (externalStorageDirectory != null)
				mSdRootPath = externalStorageDirectory.getPath();
		}
		mDataRootPath = context.getCacheDir().getPath();

		mAvailableRootPath = mSdRootPath == null ? mDataRootPath : mSdRootPath;
	}

	public static String getSdRootPath() {
		return mSdRootPath;
	}

	public static void setmSdRootPath(String mSdRootPath) {
		FileUtil.mSdRootPath = mSdRootPath;
	}

	public static String getmDataRootPath() {
		return mDataRootPath;
	}

	public static void setmDataRootPath(String mDataRootPath) {
		FileUtil.mDataRootPath = mDataRootPath;
	}

	public static String getmAvailableRootPath() {
		return mAvailableRootPath;
	}

	public static void setmAvailableRootPath(String mAvailableRootPath) {
		FileUtil.mAvailableRootPath = mAvailableRootPath;
	}

	public static void copyFile(File from, File to) {
		try {
			int byteread = 0;
			if (from.exists() && from.isFile() && from.canRead()) { // �ļ�����ʱ
				InputStream inStream = new FileInputStream(from); // ����ԭ�ļ�
				FileOutputStream fs = new FileOutputStream(to);
				byte[] buffer = new byte[1024];
				while ((byteread = inStream.read(buffer)) != -1) {
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
				fs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
