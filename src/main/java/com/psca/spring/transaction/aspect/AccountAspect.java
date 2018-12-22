package com.psca.spring.transaction.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.psca.spring.transaction.dao.AccountDao;
import com.psca.spring.transaction.dao.BookDao;

@Aspect
@Component
public class AccountAspect {
	@Autowired
	private BookDao bookDao;
	@Autowired
	private AccountDao accountDao;
	@Before("BookStockAspect.declarePointCutMethod()")
	public void beforeSellBook() {
		Integer bookPrice = bookDao.showBookPrice();
		Integer balance = accountDao.showBalance();
		if(balance < bookPrice) {
			throw new RuntimeException("账户余额已经不能购买本书！");
		}
	}
}
