package com.jsp.tollapp.controller.search;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

	@RequestMapping(value = "/search.toll", method = RequestMethod.POST)
	public ModelAndView searchAdminController(HttpServletRequest request) {

		logger.info("SearchController searchAdminController() method started");
		List<AdminDTO> list = null;
		try {
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String tollName = request.getParameter("choosetoll");
			list = service.searchService(username, email, tollName);
			logger.info("dtoFromDB" + list);
		}
		catch (Exception e) {
			logger.error("Exception in SearchController searchAdminController() method");
		}
		logger.info("SearchController searchAdminController() method ended");
		return new ModelAndView("Result.jsp", "list", list);
	}
}
