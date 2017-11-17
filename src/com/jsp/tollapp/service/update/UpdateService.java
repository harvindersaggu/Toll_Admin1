package com.jsp.tollapp.service.update;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.tollapp.dao.update.UpdateDAO;
import com.jsp.tollapp.dto.admin.AdminDTO;

@Service
public class UpdateService {
	
	private static Logger logger = LoggerFactory.getLogger(UpdateService.class);
	
	@Autowired
	private UpdateDAO dao;
	
	public UpdateService() {

		logger.info("created.." + this.getClass().getSimpleName());
	}
	
	public AdminDTO updateAdminService(AdminDTO dto)
	{
		return dao.update(dto);
	}
}
