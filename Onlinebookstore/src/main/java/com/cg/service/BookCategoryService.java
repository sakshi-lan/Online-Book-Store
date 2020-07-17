package com.cg.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.BookDaoI;
import com.cg.dao.CategoryDaoI;
import com.cg.entity.BookInfo;
import com.cg.entity.CategoryInfo;
import com.cg.exception.InvalidBookIdException;
import com.cg.model.BookInfoDetails;

@Service
@Transactional
public class BookCategoryService implements BookCategoryServiceI {

	@Autowired
	private BookDaoI book_dao;

	@Autowired
	private CategoryDaoI cat_dao;

	@Override
	public CategoryInfo addCategory(CategoryInfo cate_info) {

		return cat_dao.save(cate_info);
	}

	@Override
	public BookInfoDetails addBook(BookInfoDetails b_info) {
		Boolean bool = cat_dao.existsById(b_info.getCategory_Id());
		if (bool) {
			Optional<CategoryInfo> c = cat_dao.findById(b_info.getCategory_Id());

			BookInfo book_info = new BookInfo();

			book_info.setCategory_info(c.get());
			book_info.setAuthor(b_info.getAuthor());
			book_info.setDescription(b_info.getDescription());
			book_info.setIcon(b_info.getIcon());
			book_info.setIsbn(b_info.getIsbn());
			book_info.setPrice(b_info.getPrice());
			book_info.setPublished_Date(b_info.getPublished_Date());
			book_info.setTitle(b_info.getTitle());

			book_info = book_dao.save(book_info);

			return b_info;
		} else
			return null;
	}

	// Displaying Category Names
	@Override
	public List<CategoryInfo> getCategoryNames() {
		return cat_dao.getCityNames();
	}

	@Override
	public List<BookInfo> getBookNames() {
		return book_dao.getBookNames();
	}

	@Override
	public CategoryInfo updateCategory(CategoryInfo c1) {
		return cat_dao.save(c1);
	}

	@Override
	public BookInfo updateBook(BookInfo b1) {
			return book_dao.save(b1);
		
	}


	@Override
	public void deleteCategory(int id) {
		cat_dao.deleteById(id);
	}

	@Override
	public List<BookInfo>  deleteBook(int id) throws InvalidBookIdException {
		book_dao.deleteById(id);
		return null;
			
		}
	}