package br.com.eshopper.ecommerce.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	
	@Autowired
	HttpServletRequest request;
	
	public String write(String basePath, MultipartFile file) {
		try {
			String realPath = request.getServletContext().getRealPath("/" + basePath);
			String path = realPath + "/" + file.getOriginalFilename();
			file.transferTo(new File(path));
			return basePath + "/" + file.getOriginalFilename();
		} catch (IllegalStateException | IOException e) {
			throw new RuntimeException(e);
		}
	}

}
