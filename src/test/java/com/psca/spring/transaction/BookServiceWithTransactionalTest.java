package com.psca.spring.transaction;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.psca.spring.transaction.service.BookService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class BookServiceWithTransactionalTest {
	@Autowired
	private BookService bookService;
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void testSellBook() {
		bookService.sellBook();
	}
}
