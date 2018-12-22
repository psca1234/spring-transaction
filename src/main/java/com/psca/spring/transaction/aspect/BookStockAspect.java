package com.psca.spring.transaction.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.psca.spring.transaction.dao.BookStockDao;
@Order(2)
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
		System.out.println("开始检查图书库存！");
		if(bookStock < 0 ) {
			throw new RuntimeException("图书存量不足！");
		}else {
			System.out.println("图书库存充足可以销售！");
		}
	}
}
