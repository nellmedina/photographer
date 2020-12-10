package com.poc.photographer.repository;

import com.poc.photographer.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long>
{

}
