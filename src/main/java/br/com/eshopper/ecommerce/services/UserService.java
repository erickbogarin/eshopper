package br.com.eshopper.ecommerce.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eshopper.ecommerce.daos.SummaryUserDAO;
import br.com.eshopper.ecommerce.daos.UserDAO;
import br.com.eshopper.ecommerce.models.SummaryUser;
import br.com.eshopper.ecommerce.models.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private SummaryUserDAO summaryUserDao;

	@Autowired
	private SummaryUser summaryUser;
	
	@Transactional
	public void save(User user) {
		userDao.save(user);
		updateSummaryUser();
	}
	
	private void updateSummaryUser() {
		summaryUser.setTotalGeneralUsers(userDao.findAllUsers());
		summaryUser.setTotalMaleUsers(userDao.findAllMen());
		summaryUser.setTotalFemaleUsers(userDao.findAllWomen());
		summaryUser.setTotalChildUsers(userDao.findAllChild());
		summaryUserDao.save(summaryUser);
	}
	
}
