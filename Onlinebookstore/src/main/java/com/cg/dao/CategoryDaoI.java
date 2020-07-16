package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.entity.CategoryInfo;

public interface CategoryDaoI extends JpaRepository<CategoryInfo, Integer>{
	@Query("select c from CategoryInfo c")
	List<CategoryInfo> getCityNames();

}