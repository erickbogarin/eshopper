package br.com.eshopper.ecommerce.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.eshopper.ecommerce.daos.SummaryUserDAO;
import br.com.eshopper.ecommerce.daos.UserDAO;
import br.com.eshopper.ecommerce.models.SummaryUser;
import br.com.eshopper.ecommerce.models.SystemUser;

@Controller
@RequestMapping("/auth")
public class UserController {

	@Autowired
	private UserDAO userDao;

	@Autowired
	private SummaryUserDAO summaryUserDao;

	@Autowired
	private SummaryUser summaryUser;

	@RequestMapping(method = RequestMethod.POST)
	@Transactional
	public ModelAndView register(@Valid SystemUser user, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return new ModelAndView("/login");
		}

		userDao.save(user);
		updateSummaryUser();

		redirectAttributes.addFlashAttribute("sucesso", "Cadastro realizado com sucesso.");
		return new ModelAndView("redirect:/login");
	}

	private void updateSummaryUser() {
		summaryUser.setTotalGeneralUsers(userDao.findAllUsers());
		summaryUser.setTotalMaleUsers(userDao.findAllMen());
		summaryUser.setTotalFemaleUsers(userDao.findAllWomen());
		summaryUser.setTotalChildUsers(userDao.findAllChild());
		summaryUserDao.save(summaryUser);
	}
}
