package com.jsp.tollapp.controller.login;

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
import com.jsp.tollapp.dto.login.LoginDTO;
import com.jsp.tollapp.service.login.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService service;

	public LoginController() {

		logger.info("created.." + this.getClass().getCanonicalName());
	}

	@RequestMapping(value = "/register.toll", method = RequestMethod.POST)
	public ModelAndView fetchUserController(LoginDTO loginDTO, HttpServletRequest req) {

		logger.info("Login controller method started");
		AdminDTO dtoFromDB = null;
		ModelAndView modelAndView = null;
		try {
			dtoFromDB = service.fetchUserService(loginDTO);
			HttpSession session = req.getSession();
			logger.info("dtoFromDB.getEmail()------------------------------------------"+dtoFromDB.getEmail());
			session.setAttribute("email", dtoFromDB.getEmail());
			
			if (dtoFromDB != null) {
				if (dtoFromDB.getRoles().equals("superadmin")) {
					logger.info("Login controller method ended");
					modelAndView = new ModelAndView("Home.jsp");
					modelAndView.addObject("msg", "Login Sucessful");
					modelAndView.addObject("user", loginDTO.getUsername());
				}
				else if (dtoFromDB.getRoles().equals("admin")) {
					modelAndView = new ModelAndView("Admin.jsp");
					modelAndView.addObject("msg", "Login Sucessful");
					modelAndView.addObject("user", loginDTO.getUsername());
				}
				/*
				 * modelAndView.addObject("msg","Login Sucessful");
				 * modelAndView.addObject("user",loginDTO.getUsername());
				 * return modelAndView;
				 */
				else {
					logger.info("Login controller method ended");
					return new ModelAndView("Login.jsp", "msg", "Invalid Credentials");
				}
			}
		}
		catch (Exception e) {
			logger.error("Exception in LoginController fetchUserController");
		}
		return modelAndView;
	}
}
