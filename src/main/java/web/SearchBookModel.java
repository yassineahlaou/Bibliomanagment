package web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import gestion.Book;

public class SearchBookModel implements Serializable {
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	private String  keyword;
	private String error;
	private String mode ="add";
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	private Book b = new Book();
	
	public Book getB() {
		return b;
	}
	public void setB(Book b) {
		this.b = b;
	}
	private List <Book> books = new ArrayList <Book>();
	public SearchBookModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchBookModel(String keyword, List<Book> books) {
		super();
		this.keyword = keyword;
		this.books = books;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
