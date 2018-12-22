package com.psca.spring.transaction.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.psca.spring.transaction.dao.AccountDao;
import com.psca.spring.transaction.dao.BookDao;
@Order(1)
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
		System.out.println("开始检查账户余额！");
		if(balance < bookPrice) {
			throw new RuntimeException("账户余额已经不能购买本书！");
		}else {
			System.out.println("账户余额充足，可以购买本书！");
		}
	}
}
