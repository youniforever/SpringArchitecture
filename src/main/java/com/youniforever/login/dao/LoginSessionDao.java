package com.youniforever.login.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("LoginSessionDao")
public class LoginSessionDao {

	@Resource(name = "userSqlSessionFactory")
	SqlSessionTemplate userSqlSessionFactory;
	
	public long validUser(HashMap<String, String> loginIdPw) {
		return userSqlSessionFactory.selectOne("sql.login.select.selectUserIdx", loginIdPw);
	}
	
}
