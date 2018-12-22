package com.psca.spring.transaction.dao;

public interface BookStockDao {
	void saveBookStockInfo();
	void updateStockInfo();
	Integer showStock();
}
