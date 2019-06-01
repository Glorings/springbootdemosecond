/**
 *
 */
package com.ald.ecanew.springbootdemosecond.biz;

import java.io.Serializable;
import java.util.List;


/**
 * 公共父类，封装基础操作方法
 * @param <T> 目标类
 * @param <ID> 目标类主键类型
 */
public interface ParentService<T, ID extends Serializable> {
	/**
	 * 插入数据，返回对象，包含主键ID
	 * @param t 目标类
	 * @return 保存结果
	 */
	int saveRecord(T t);

	/**
	 * 通过id更新记录
	 * @param t 目标类
	 * @return 更新结果
	 */
	int updateById(T t);

	/**
	 * 通过普通条件查询对象（表字段对应的条件）
	 * @param id 主键
	 * @return
	 */
	T getById(ID id);

	/**
	 * 通过普通条件查询对象（表字段对应的条件）
	 * @param t 目标类
	 * @return 实体
	 */
	T getByCommonCondition(T t);

	/**
	 * 通过普通条件查询对象列表（表字段对应的条件）
	 * @param t 目标类
	 * @return 实体信息
	 */
	List<T> getListByCommonCondition(T t);
}
