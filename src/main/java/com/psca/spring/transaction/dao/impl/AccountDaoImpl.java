package com.psca.spring.transaction.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.psca.spring.transaction.dao.AccountDao;
import com.psca.spring.transaction.entity.Account;
@Repository
public class AccountDaoImpl implements AccountDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate named;
	public void saveAccountInfo() {
		// TODO Auto-generated method stub
		Account account = new Account();
		account.setUsername("Tom");
		account.setBalance(300);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(account);
		String sql ="insert into account (username,balance) values (:username,:balance)";
		named.update(sql, paramSource);
	}

	public void updateBalanceInfo() {
		// TODO Auto-generated method stub
		String sql ="update account set balance = balance-50 where username=?";
		String username="Tom";
		jdbcTemplate.update(sql, username);

	}

	public Integer showBalance() {
		// TODO Auto-generated method stub
		String sql ="select balance from account where username='Tom'";
		return jdbcTemplate.queryForObject(sql,Integer.class);
	}

}
