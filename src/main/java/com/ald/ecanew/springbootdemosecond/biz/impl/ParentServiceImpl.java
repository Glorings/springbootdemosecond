/**
 * 
 */
package com.ald.ecanew.springbootdemosecond.biz.impl;

import com.ald.ecanew.springbootdemosecond.biz.ParentService;
import com.ald.ecanew.springbootdemosecond.dal.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

public abstract class ParentServiceImpl<T, ID extends Serializable> implements ParentService<T, ID> {

	@Autowired
	protected HttpServletRequest request;

	@Override
	public int saveRecord(T t) {
		return getDao().saveRecord(t);
	}

	@Override
	public int updateById(T t) {
		return getDao().updateById(t);
	}
	
	@Override
	public T getById(ID id) {
		return getDao().getById(id);
	}

	@Override
	public T getByCommonCondition(T t) {
		return getDao().getByCommonCondition(t);
	}

	@Override
	public List<T> getListByCommonCondition(T t) {
		return getDao().getListByCommonCondition(t);
	}
	
	public abstract BaseDao<T, ID> getDao();
}
