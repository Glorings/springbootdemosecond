package com.ald.ecanew.springbootdemosecond.dal.dao;

import com.ald.ecanew.springbootdemosecond.dal.domain.PersonDo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Bungapa案件记录表Dao
 * 
 * @author wujun
 * @version 1.0.0 初始化
 * @date 2019-05-29 17:16:26
 * Copyright 本内容仅限于杭州阿拉丁信息科技股份有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Mapper
public interface PersonDao extends BaseDao<PersonDo, Long> {

}
