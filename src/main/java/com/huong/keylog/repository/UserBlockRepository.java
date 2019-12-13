package com.huong.keylog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.huong.keylog.model.UserBlock;

@Repository
public class UserBlockRepository {
 @Autowired
 NamedParameterJdbcTemplate jdbcTemplate;
 public int create(UserBlock user) {
	 String sql = "INSERT INTO user_block(user_name, pass) VALUES(:userName, :pass)";
	 BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(user);
			 return jdbcTemplate.update(sql, source);
 }
 public List<UserBlock> getByUsername(String username){
	 String sql ="SELECT * FROM user_block WHERE user_name =:userName";
	 Map<String, Object> map = new HashMap<String, Object>();
	 map.put("userName", username);
	 return jdbcTemplate.query(sql, map,new BeanPropertyRowMapper<UserBlock>(UserBlock.class));
 }
}
