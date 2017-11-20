package com.jsp.tollapp.controller.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.tollapp.dto.admin.AdminDTO;
import com.jsp.tollapp.service.search.SearchService;

@Controller
@RequestMapping("/")
public class SearchController {

	private static Logger logger = LoggerFactory.getLogger(SearchController.class);

	@Autowired
	private SearchService service;
	
	public SearchController() {
		logger.info("created.." + this.getClass().getSimpleName());
	}
	@RequestMapping(value="/search.toll", method=RequestMethod.POST)
	public ModelAndView searchAdminController(HttpServletRequest request)
	{
		logger.info("SearchController searchAdminController() method started");
		try {
			String username= request.getParameter("username");
			String password= request.getParameter("password");
			String tollName=request.getParameter("choosetoll");
			List<AdminDTO> dtoFromDB=service.searchService(username,password,tollName);
			logger.info("dtoFromDB"+dtoFromDB);
	
		} catch (Exception e) {
			logger.error("Exception in SearchController searchAdminController() method");
		}
		logger.info("SearchController searchAdminController() method ended");
		return new ModelAndView("Result.jsp","msg","Search Result");
		
	}
}
