package br.com.eshopper.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.eshopper.ecommerce.daos.ShoppingBrandDAO;
import br.com.eshopper.ecommerce.daos.ShoppingCategoryDAO;
import br.com.eshopper.ecommerce.daos.ShoppingPersonDAO;
import br.com.eshopper.ecommerce.models.ShoppingBrand;
import br.com.eshopper.ecommerce.models.ShoppingCategory;
import br.com.eshopper.ecommerce.models.ShoppingPerson;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	private ShoppingCategoryDAO shoppingCategoryDao;
	
	@Autowired
	private ShoppingPersonDAO shoppingPersonDao;
	
	@Autowired
	private ShoppingBrandDAO shoppingBrandDao;
	
	@RequestMapping("/category")
	public ModelAndView getCategoryReport(ModelMap modelMap, ModelAndView modelAndView) {
        List<ShoppingCategory> salesList = shoppingCategoryDao.list();
        JRDataSource dataSource = new JRBeanCollectionDataSource(salesList);
         
        modelMap.put("datasource", dataSource);
        modelMap.put("format", "pdf");
        modelAndView = new ModelAndView("rpt_categoria", modelMap);
        return modelAndView;
	}
	
	@RequestMapping("/person")
	public ModelAndView getPersonReport(ModelMap modelMap, ModelAndView modelAndView) {
        List<ShoppingPerson> salesList = shoppingPersonDao.list();
        JRDataSource dataSource = new JRBeanCollectionDataSource(salesList);
         
        modelMap.put("datasource", dataSource);
        modelMap.put("format", "pdf");
        modelAndView = new ModelAndView("rpt_genero", modelMap);
        return modelAndView;
	}
	
	@RequestMapping("/brand")
	public ModelAndView getBrandReport(ModelMap modelMap, ModelAndView modelAndView) {
        List<ShoppingBrand> salesList = shoppingBrandDao.list();
        JRDataSource dataSource = new JRBeanCollectionDataSource(salesList);
         
        modelMap.put("datasource", dataSource);
        modelMap.put("format", "pdf");
        modelAndView = new ModelAndView("rpt_marca", modelMap);
        return modelAndView;
	}

}
