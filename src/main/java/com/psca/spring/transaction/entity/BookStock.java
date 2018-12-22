package com.psca.spring.transaction.entity;

public class BookStock {
	private String isbn;
	private Integer stock;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "BookStock [isbn=" + isbn + ", stock=" + stock + "]";
	}
	
}
