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

import java.util.concurrent.atomic.AtomicInteger;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.laolema.mix.entity.DbAbstractEntity;

/**
 * FileName: DatabaseHelper.java
 * 
 * @version v1.0
 * @author WangZhanghuan
 * @date：2015-08-17 16:29:22
 */
public class DatabaseHelper extends SQLiteOpenHelper {
	private static DatabaseHelper instance = null;
	private final static String DATABASE_NAME = "mix_db";
	private final static int DATABASE_VERSION = 1;

	private AtomicInteger mOpenCounter = new AtomicInteger();

	private SQLiteDatabase db;

	private DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION, null);
	}

	private DatabaseHelper(Context context, String dir) {
		super(new DatabaseContext(context, dir, true), DATABASE_NAME, null,
				DATABASE_VERSION, null);
	}

	public static synchronized void initialize(Context context) {
		if (instance == null) {
			instance = new DatabaseHelper(context);
		}
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("PRAGMA foreign_keys=ON;");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

	public static synchronized DatabaseHelper getInstance(Context context) {
		if (instance == null) {
			throw new IllegalStateException(
					DatabaseHelper.class.getSimpleName()
							+ " is not initialized, call initialize(..) method first.");
		}

		return instance;
	}

	public synchronized SQLiteDatabase openDatabase() {
		if (mOpenCounter.incrementAndGet() == 1) {
			return this.db == null ? this.getWritableDatabase() : this.db;
		} else {
			return this.db;
		}
	}

	public synchronized void closeDatabase() {
		if (mOpenCounter.decrementAndGet() == 0) {
			db.close();
		}
	}

	public void insert(DbAbstractEntity dbEntity) {
		SQLiteDatabase db = openDatabase();
		db.insert(dbEntity.getTableName(), null, dbEntity.getContentValues());
		closeDatabase();
	}

	public Cursor query(String table) {
		SQLiteDatabase db = openDatabase();
		Cursor cursor = db.query(table, null, null, null, null, null, null);
		closeDatabase();
		return cursor;
	}
}
