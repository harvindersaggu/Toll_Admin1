package com.jsp.tollapp.dao.search;

import java.util.Collections;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.tollapp.dto.admin.AdminDTO;

@Repository
public class SearchDAO {

	private static Logger logger = LoggerFactory.getLogger(SearchDAO.class);

	@Autowired
	private SessionFactory factory;

	public SearchDAO() {
		logger.info("created.." + this.getClass().getSimpleName());
	}

	public List<AdminDTO> searchAdmin(String username,String email,String tollName) {
		logger.info("SearchDAO searchAdmin() method started");
		Session session = factory.openSession();
		try {
		String hql="From  AdminDTO A where A.username=:un OR A.email=:em AND A.choosetoll=:ct";
		Query query=session.createQuery(hql);
		query.setParameter("un", username);
		query.setParameter("em", email);
		query.setParameter("ct", tollName);
		List<AdminDTO> list=query.list();
		return list;
		}catch (HibernateException e) {
			logger.error("Exception in SearchDAO searchAdmin() method");
			e.printStackTrace();
		}
		return Collections.EMPTY_LIST;
	}
}
