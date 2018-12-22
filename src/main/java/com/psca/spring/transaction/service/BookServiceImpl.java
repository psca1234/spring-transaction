package com.psca.spring.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psca.spring.transaction.dao.AccountDao;
import com.psca.spring.transaction.dao.BookStockDao;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookStockDao bookStockDao;
	@Autowired
	private AccountDao accountDao;
	@Transactional
	public void sellBook() {
		// TODO Auto-generated method stub
		bookStockDao.updateStockInfo();
		accountDao.updateBalanceInfo();
	}

}
