package br.com.eshopper.ecommerce.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.eshopper.ecommerce.daos.ProductDAO;
import br.com.eshopper.ecommerce.formatters.ProductIdFormatter;
import br.com.eshopper.ecommerce.infra.FileSaver;
import br.com.eshopper.ecommerce.models.Product;

/**
 * @author Erick
 *
 */
@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private FileSaver fileSaver;
	
	/**
	 * @param product
	 * @param smallPhoto
	 * @param mediumPhoto
	 * @param largePhoto
	 * 
	 * Save the product
	 */
	@Transactional
	@CacheEvict(value = "products", allEntries = true)
	public void save(Product product, MultipartFile smallPhoto, MultipartFile mediumPhoto, MultipartFile largePhoto) {
		
		String unformatted = product.getName();
		product.setNameId(ProductIdFormatter.format(unformatted ));
		
		product.setSmallPhotoPath(webPath(smallPhoto));
		product.setMediumPhotoPath(webPath(mediumPhoto));
		product.setLargePhotoPath(webPath(largePhoto));
		
		productDAO.save(product);
	}
	
	/**
	 * @param sizePhoto
	 * @return photo URL
	 * 
	 * Upload photos in 'uploaded-images' folder
	 * 
	 */
	private String webPath(MultipartFile sizePhoto) {
		return fileSaver.write("uploaded-images", sizePhoto);
	}
	
	/**
	 * @return Product List
	 */
	@Cacheable(value = "products")
	public List<Product> list() {
		return productDAO.list();
	}
	
}
