package br.com.eshopper.ecommerce.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import br.com.eshopper.ecommerce.daos.ShoppingBrandDAO;
import br.com.eshopper.ecommerce.daos.ShoppingCategoryDAO;
import br.com.eshopper.ecommerce.daos.ShoppingPersonDAO;
import br.com.eshopper.ecommerce.models.wrapers.ShoppingBrand;
import br.com.eshopper.ecommerce.models.wrapers.ShoppingCategory;
import br.com.eshopper.ecommerce.models.wrapers.ShoppingPerson;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author Erick
 *
 */
@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private ShoppingCategoryDAO shoppingCategoryDao;

	@Autowired
	private ShoppingPersonDAO shoppingPersonDao;

	@Autowired
	private ShoppingBrandDAO shoppingBrandDao;

	private static final Logger logger = Logger.getLogger(ReportController.class);

	/**
	 * @param modelMap
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/category")
	public ModelAndView getCategoryReport(ModelMap modelMap, ModelAndView modelAndView) {

		List<ShoppingCategory> salesList = shoppingCategoryDao.list();
		JRDataSource dataSource = new JRBeanCollectionDataSource(salesList);

		modelMap.put("datasource", dataSource);
		modelMap.put("format", "pdf");
		modelAndView = new ModelAndView("rpt_categoria", modelMap);
		return modelAndView;
	}

	/**
	 * @param modelMap
	 * @param modelAndView
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/person")
	public ModelAndView getPersonReport(ModelMap modelMap, ModelAndView modelAndView,
			@RequestParam(value = "starts", required = true) String starts,
			@RequestParam(value = "ends", required = true) String ends) throws Exception {
		
		List<ShoppingPerson> salesList = shoppingPersonDao.list();
		JRDataSource dataSource = new JRBeanCollectionDataSource(salesList);

		modelMap.put("datasource", dataSource);
		modelMap.put("format", "pdf");
		modelAndView = new ModelAndView("rpt_genero", modelMap);

		return modelAndView;
	}

	/**
	 * @param modelMap
	 * @param modelAndView
	 * @param starts
	 * @param ends
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/brand")
	public ModelAndView getBrandReport(ModelMap modelMap, ModelAndView modelAndView,
			@RequestParam(value = "start", required = true) String start,
			@RequestParam(value = "ends", required = true) String ends) throws Exception {

		List<ShoppingBrand> salesList = shoppingBrandDao.list();
		JRDataSource dataSource = new JRBeanCollectionDataSource(salesList);

		Date startDate = setDateFormart(start);
		Date endDate = setDateFormart(ends);

		modelMap.put("START", startDate);
		modelMap.put("END", endDate);
		modelMap.put("datasource", dataSource);
		modelMap.put("format", "pdf");
		modelAndView = new ModelAndView("rpt_marca", modelMap);

		return modelAndView;
	}

	private Date setDateFormart(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dataInicial = sdf.parse(date);

		return dataInicial;
	}

	/**
	 * @param e
	 * @return
	 */
	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody String handlerMissingParamsError(MissingServletRequestParameterException e) {
		logger.error("Error: ", e);
		return "Internal Error!";
	}

}
