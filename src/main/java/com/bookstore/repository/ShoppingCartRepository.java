package com.bookstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.ShoppingCart;
import com.bookstore.domain.User;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long>{
	List<ShoppingCart> findAll();
}
