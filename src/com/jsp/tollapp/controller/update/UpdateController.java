package com.jsp.tollapp.controller.update;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.tollapp.dto.admin.AdminDTO;
import com.jsp.tollapp.service.update.UpdateService;

@Controller
@RequestMapping("/")
public class UpdateController {

	private static Logger logger = LoggerFactory.getLogger(UpdateController.class);

	@Autowired
	private UpdateService service;

	public UpdateController() {

		logger.info("created.." + this.getClass().getSimpleName());
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value = "/update.toll", method = RequestMethod.POST)
	public ModelAndView updateAdminController(AdminDTO adminDTO, HttpServletRequest request) {

		logger.info("UpdateController  updateAdminController() method started");
		try {
			HttpSession session = request.getSession(false);
			AdminDTO dtoFromSession = (AdminDTO) session.getAttribute("adto");
			logger.info("dtoFromSession" + dtoFromSession);
			adminDTO.setId(dtoFromSession.getId());
			AdminDTO dtoFromDB = service.updateAdminService(adminDTO);
			session.setAttribute("adto", dtoFromDB);
		}
		catch (Exception e) {
			logger.error("Exception in UpdateController updateAdminController() method");
			e.printStackTrace();
		}
		logger.info("UpdateController updateAdminController() method ended");
		return new ModelAndView("Home.jsp", "msg", "Details updated successfully");
	}
}
