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
package cn.laolema.mix.entity;

import android.content.ContentValues;

/**
 * FileName: DbAbstractEntity.java
 * 
 * @version v1.0
 * @author WangZhanghuan
 * @date：2015-08-17 16:29:25
 */
public abstract class DbAbstractEntity {

	public abstract ContentValues getContentValues();

	public abstract String getTableName();
}
