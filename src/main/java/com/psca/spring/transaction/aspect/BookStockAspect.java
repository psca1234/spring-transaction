package com.psca.spring.transaction.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.psca.spring.transaction.dao.BookStockDao;

@Aspect
@Component
public class BookStockAspect {
	@Autowired
	private BookStockDao bookStockDao;
	@Pointcut("execution(* com.psca.spring.transaction.service.BookService.*())")
	public void declarePointCutMethod() {};
	@Before("declarePointCutMethod()")
	public void beforeSellBook() {
		Integer bookStock =bookStockDao.showStock();
		if(bookStock < 0 ) {
			throw new RuntimeException("图书存量不足");
		}
	}
}
