package com.psca.spring.transaction.dao;

public interface AccountDao {
	void saveAccountInfo();
	
	void updateBalanceInfo();
	
	Integer showBalance();
}
