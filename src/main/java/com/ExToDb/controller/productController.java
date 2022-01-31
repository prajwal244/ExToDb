package com.ExToDb.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ExToDb.entity.Product;
import com.ExToDb.helper.ExcelHelper;
import com.ExToDb.service.ProductService;

@RestController
@CrossOrigin
public class productController {

	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/product/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
		
		if(ExcelHelper.checkExcelFormat(file)) {
			 productService.save(file);
			 
			 return ResponseEntity.status(HttpStatus.OK).body("file uploaded");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload excel file");
		
		
	}
	
	@GetMapping("/product")
	public List<Product> getAllProduct(){
		return productService.getAllProduct();
	}
}
