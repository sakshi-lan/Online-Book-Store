package com.cg.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.dao.BookDaoI;
import com.cg.entity.BookInfo;
import com.cg.service.BookCategoryService;

@SpringBootTest
class OnlinebookstoreApplicationTests {

	@Autowired
	private BookCategoryService bs;
	
	@MockBean
	BookDaoI bd;
	
	@Test
	public void deleteBookTest(){ 
		BookInfo b=new BookInfo();
		bd.delete(b);
		verify(bd,times(1)).delete(b);
	}
	
	@Test
	public void getAllBooksTest() {
		List<BookInfo> bookinfo=new ArrayList<>();
		bookinfo.add(null);
		bookinfo.add(null);
		Mockito.when(bd.getBookNames()).thenReturn(bookinfo);
		
		List<BookInfo> returnedData=bd.getBookNames();
		assertEquals(2,returnedData.size());
	}
	

	}
