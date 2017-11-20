package com.jsp.tollapp.service.search;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.tollapp.dao.search.SearchDAO;
import com.jsp.tollapp.dto.admin.AdminDTO;

@Service
public class SearchService {

	private static Logger logger = LoggerFactory.getLogger(SearchService.class);

	@Autowired
	private SearchDAO dao;

	public SearchService() {
		logger.info("created.." + this.getClass().getSimpleName());
	}

	public List<AdminDTO> searchService(String username,String email,String tollName) {
		logger.info("SearchService searchService() method started");
		List<AdminDTO> dtoFromDB=dao.searchAdmin(username,email,tollName);
		logger.info("SearchService searchService() method ended");
		return dtoFromDB;
	}
}
