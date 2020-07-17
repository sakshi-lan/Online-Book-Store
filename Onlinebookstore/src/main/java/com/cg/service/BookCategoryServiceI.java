package com.cg.service;

import java.util.List;

import com.cg.entity.BookInfo;
import com.cg.entity.CategoryInfo;
import com.cg.exception.InvalidBookIdException;
import com.cg.model.BookInfoDetails;

public interface BookCategoryServiceI {

	BookInfoDetails addBook(BookInfoDetails b_info);

	CategoryInfo addCategory(CategoryInfo cate_info);

	List<CategoryInfo> getCategoryNames();

	List<BookInfo> getBookNames();

	CategoryInfo updateCategory(CategoryInfo c1);

	BookInfo updateBook(BookInfo b1);
	
	void deleteCategory(int id);

	List<BookInfo> deleteBook(int id)throws InvalidBookIdException;
	

}