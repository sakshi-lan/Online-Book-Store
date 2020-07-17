package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entity.BookInfo;
import com.cg.entity.CategoryInfo;
import com.cg.exception.InvalidBookIdException;
import com.cg.model.BookInfoDetails;
import com.cg.service.BookCategoryServiceI;

@RestController
@CrossOrigin("http://localhost:4200")
public class CategoryController {
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="controller account is not present")
	@ExceptionHandler({Exception.class})
	public void handleException()
	{
		
	}
	
	@Autowired
	private BookCategoryServiceI book_catg_service;
	//add book in the webiste
	@PostMapping("/add/book")
	public ResponseEntity<String> addBook(@RequestBody BookInfoDetails b_info){
		BookInfoDetails b = book_catg_service.addBook(b_info);
		if(b !=null )
			return new ResponseEntity<>("book was added successfully..!!",HttpStatus.OK);
		else
			return new ResponseEntity<>("sorry, book was not added..!!", HttpStatus.OK);
	}
	//add category
	@PostMapping("/add/category")
	public ResponseEntity<String> addCategory(@RequestBody CategoryInfo cate_info){
		CategoryInfo c = book_catg_service.addCategory(cate_info);
		if(c !=null )
			return new ResponseEntity<>("category added succesfully..!!",HttpStatus.OK);
		else
			return new ResponseEntity<>("sorry, category  not added..!!",HttpStatus.OK);
	}
	//displaying categories
		@GetMapping("/displaycategories")
		public List<CategoryInfo> categoryNames(){
			List<CategoryInfo> list = book_catg_service.getCategoryNames();
			return list;
		}
	//displaying list of books
		@GetMapping("/displaybooks")
		public List<BookInfo> bookNames(){
		List<BookInfo> list1 = book_catg_service.getBookNames();
		return list1;
		}
		//updating category
		@PutMapping("/update_category")
		public String updateCategory(@RequestBody CategoryInfo c1) {
			//String string = book_catg_service.updateCategory(c1);
			//return string;
			CategoryInfo cat1=book_catg_service.updateCategory(c1);
			if(cat1!=null)
			{
				return "updated successfully!"+cat1.getCategory_Id()+cat1.getCategory_Name();
			}
			else
			{
				return "details not updated ";
			}
		}
		
		//updating Book
				@PutMapping("/update_book")
				public String updateBook(@RequestBody BookInfo b1) {
				//	String string = book_catg_service.updateBook(b1);
					//return string;
					BookInfo book1=book_catg_service.updateBook(b1);
					if(book1!=null)
					{
						return "updated successfully"+book1.getBook_id()+book1.getAuthor()+book1.getDescription()+
								book1.getIcon()+book1.getIsbn()+book1.getPrice()+
								book1.getPublished_Date()+book1.getTitle();
					}
					else
					{
						return "not updated! check again!";
					}
				}
				
		//delete Book
				@DeleteMapping("/delete_book/{id}")
				public ResponseEntity<List<BookInfo>> deleteBook(@PathVariable ("id") int id)throws InvalidBookIdException{
					List<BookInfo> list=book_catg_service.deleteBook(id);
					return new ResponseEntity<List<BookInfo>>(list, HttpStatus.OK);
				
				
				}				
			//delete category
				@DeleteMapping("/delete_category/{id}")
				public void deleteCategory(@PathVariable ("id") int id){
				book_catg_service.deleteCategory(id);
				
				}				
}