package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.entity.BookInfo;
import com.cg.entity.CategoryInfo;

public interface BookDaoI extends JpaRepository<BookInfo, Integer>{

	@Query("select b from BookInfo b")
	List<BookInfo> getBookNames();

}