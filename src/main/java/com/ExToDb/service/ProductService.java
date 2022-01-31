package com.ExToDb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ExToDb.entity.Product;
import com.ExToDb.helper.ExcelHelper;
import com.ExToDb.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;
	
	public void save(MultipartFile file) {
		try {
			List<Product> products = ExcelHelper.convertExcelToListOfProduct(file.getInputStream());
			
			this.repo.saveAll(products);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public List<Product> getAllProduct(){
		
		return repo.findAll();
	}
}
