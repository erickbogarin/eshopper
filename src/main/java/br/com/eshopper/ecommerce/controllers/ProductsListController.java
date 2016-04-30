package br.com.eshopper.ecommerce.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.eshopper.ecommerce.daos.ProductDAO;
import br.com.eshopper.ecommerce.models.Product;

@Controller
@Transactional
@RequestMapping("/produtos")
public class ProductsListController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = "/{nameId}")
    @Cacheable(value = "productDetails")
    public ModelAndView show(@PathVariable("nameId") String nameId) {
        ModelAndView modelAndView = new ModelAndView("products/show");
        Product product = productDAO.findNameId(nameId);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Cacheable(value = "productsFeatures")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("products/list");
        modelAndView.addObject("products", productDAO.list());
        return modelAndView;
    }

    @RequestMapping("/categorias/{category}/{id}")
    @Cacheable(value = "productsCategory")
    public ModelAndView categories(@PathVariable("id") Integer id, @PathVariable("category") String category) {
        ModelAndView modelAndView = new ModelAndView("products/categories");
        modelAndView.addObject("categoryId", id);
        modelAndView.addObject("products", productDAO.filterByCategory(id));

        return modelAndView;
    }

    @RequestMapping("/marcas/{brandName}/{brandId}")
    @Cacheable(value = "productsBrand")
    public ModelAndView brands(@PathVariable("brandId") Integer brandId, @PathVariable("brandName") String category) {
        ModelAndView modelAndView = new ModelAndView("products/brands");
        modelAndView.addObject("brandId", brandId);
        modelAndView.addObject("products", productDAO.filterByBrand(brandId));

        return modelAndView;
    }

    @RequestMapping("{person}/{personId}/{categoryId}")
    public ModelAndView personAndCategoryList(@PathVariable("personId") Integer personId, @PathVariable("categoryId") Integer categoryId,
                                              @PathVariable("person") String person) {
        ModelAndView modelAndView = new ModelAndView("products/person");
        modelAndView.addObject("person", person);
        modelAndView.addObject("products", productDAO.filterByPersonAndCategory(personId, categoryId));

        return modelAndView;
    }

}
