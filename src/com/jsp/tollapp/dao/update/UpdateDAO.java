package com.jsp.tollapp.dao.update;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.tollapp.dto.admin.AdminDTO;

@Repository
public class UpdateDAO {

	private static Logger logger = LoggerFactory.getLogger(UpdateDAO.class);

	@Autowired
	private SessionFactory factory;

	public UpdateDAO() {

		logger.info("created.." + this.getClass().getSimpleName());
	}

	public AdminDTO update(AdminDTO dto) {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		AdminDTO dtoFromDB = null;
		try {
			dtoFromDB = (AdminDTO) session.merge(dto);
			transaction.commit();
		}
		catch (HibernateException e) {
			logger.error("Exception in UpdateDAO update() method");
			e.printStackTrace();
		}
		return dtoFromDB;
	}
}
