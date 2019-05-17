/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bc.lottery.common.wrapper;



import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 视图包装基类
 *
 * @author Chill
 */
public abstract class BaseEntityWrapper<E, V> {

	/**
	 * 单个实体类包装
	 * @param entity
	 * @return
	 */
	public abstract V entityVO(E entity);

	/**
	 * 实体类集合包装
	 * @param list
	 * @return
	 */
	public List<V> listVO(List<E> list) {
		return list.stream().map(this::entityVO).collect(Collectors.toList());
	}

	/**
	 * 分页实体类集合包装
	 * @param pageInfo
	 * @return
	 */
	public PageInfo<V> pageVO(PageInfo<E> pageInfo) {
		List<V> results = listVO(pageInfo.getList());
		PageInfo<V> tempPageInfo = new PageInfo<>();
		tempPageInfo.setPageNum(pageInfo.getPageNum());
		tempPageInfo.setPageSize(pageInfo.getPageSize());
		tempPageInfo.setPages(pageInfo.getPages());
		tempPageInfo.setList(results);
		return tempPageInfo;
	}

}
