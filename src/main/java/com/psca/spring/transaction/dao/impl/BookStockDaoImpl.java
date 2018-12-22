package com.psca.spring.transaction.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.psca.spring.transaction.dao.BookStockDao;
@Repository
public class BookStockDaoImpl implements BookStockDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void saveBookStockInfo() {
		// TODO Auto-generated method stub
		String sql="insert into book_stock (isbn,stock) values (?,?)";
		Object[] args = new Object[] {"0001",10};
		jdbcTemplate.update(sql, args);
	}

	public void updateStockInfo() {
		// TODO Auto-generated method stub
		String sql="update book_stock set stock = stock-1 where isbn=?";
		String isbn = "0001";
		jdbcTemplate.update(sql, isbn);
	}

	public Integer showStock() {
		// TODO Auto-generated method stub
		String sql = "select stock from book_stock where isbn='0001'";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

}
