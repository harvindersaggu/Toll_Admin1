package com.jsp.tollapp.controller.changepwd;

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
import com.jsp.tollapp.dto.changepwd.ChangeDTO;
import com.jsp.tollapp.service.changepwd.ChangeService;

@Controller
@RequestMapping("/")
public class ChangeController {

	private static Logger logger = LoggerFactory.getLogger(ChangeController.class);

	@Autowired
	private ChangeService service;

	public ChangeController() {

		logger.info("created.." + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/changepwd.toll", method = RequestMethod.POST)
	public ModelAndView changePassController(ChangeDTO dto, HttpServletRequest req) {

		logger.info("ActivationController activate() method started");
		String message = null;
		HttpSession session = req.getSession(false);
		AdminDTO dtoFromSession = (AdminDTO) session.getAttribute("adto");
		String email = dtoFromSession.getEmail();
		try {
			message = service.changePassService(dto,email);
		} catch (Exception e) {
			logger.error("Exception in ActivationController activate method");
			e.printStackTrace();
		}
		logger.info("ActivationController activate() method ended");
		if (message.equals("Password Changed Successfully")) {
			return new ModelAndView("Login.jsp", "msg", message);
		} else {
			return new ModelAndView("Changepwd.jsp", "msg", message);
		}
	}
}
