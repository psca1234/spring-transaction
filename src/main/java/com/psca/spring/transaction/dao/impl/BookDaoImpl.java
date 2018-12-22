package com.psca.spring.transaction.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.psca.spring.transaction.dao.BookDao;
import com.psca.spring.transaction.entity.Book;
@Repository
public class BookDaoImpl implements BookDao {
	@Autowired
	private NamedParameterJdbcTemplate named;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void saveBookInfo() {
		// TODO Auto-generated method stub
		String sql="insert into book(isbn,book_name,price) values (:isbn,:bookName,:price)";
		Book book = new Book();
		book.setIsbn("0001");
		book.setBookName("Java");
		book.setPrice(50);
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(book);
		named.update(sql, paramSource);
	}
	public Integer showBookPrice() {
		// TODO Auto-generated method stub
		String sql ="select price from book where isbn='0001'";
		return jdbcTemplate.queryForObject(sql,Integer.class);
	}
	
	

}
