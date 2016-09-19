package br.com.eshopper.ecommerce.controllers.integrations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.eshopper.ecommerce.daos.SaleDAO;
import br.com.eshopper.ecommerce.models.wrapers.BestSallers;
import br.com.eshopper.ecommerce.models.wrapers.ShoppingCategoryChart;

@RestController
@RequestMapping(value = "/v1/sale")
public class SaleRestController {
	
	@Autowired
	private SaleDAO saleDao;
	
	@RequestMapping(method =  RequestMethod.GET)
	public List<BestSallers> bestSallers() {
		return saleDao.bestSallers();
	}
	
	@CrossOrigin(maxAge = 3600)
	@RequestMapping(value = "/chart", method =  RequestMethod.GET)
	public List<ShoppingCategoryChart> shoppingCategoryChart() {
		return saleDao.shoppingCategoryChartList();
	}
	
}
