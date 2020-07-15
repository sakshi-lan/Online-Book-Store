package com.cg.service;

import java.util.List;

import com.cg.entity.Book;
import com.cg.entity.Category;
public interface CategoryIService {
	Category addCategory (Category category);
	Book addBook (Book book);
	List<Book> deleteBook(int id);
	List<Book> listOfBook();
	Book btoC(int cid,int bid);
	public Category UpdateCategory(Category c);

}