package com.psca.spring.transaction;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.psca.spring.transaction.dao.AccountDao;
import com.psca.spring.transaction.dao.BookDao;
import com.psca.spring.transaction.dao.BookStockDao;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestDaoRepository {
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private BookStockDao bookStockDao;
	@Autowired
	private BookDao bookDao;
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void testSaveAccountInfo() {
		accountDao.saveAccountInfo();
	}
	@Test
	public void testSaveBookStockInfo() {
		bookStockDao.saveBookStockInfo();
	}
	@Test
	public void testBookInfo() {
		bookDao.saveBookInfo();
	}
	

}
