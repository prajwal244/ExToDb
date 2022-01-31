package com.ExToDb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ExToDb.entity.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
