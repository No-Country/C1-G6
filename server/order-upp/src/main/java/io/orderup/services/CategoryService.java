package io.orderup.services;

import io.orderup.models.Category;
import io.orderup.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategorys(){
        List<Category> categorys = new ArrayList<>();
        categoryRepository.findAll()
                .forEach(categorys::add);
        return categorys;
    }

    public Optional<Category> getCategory(long id){
        return categoryRepository.findById(id);
    }


    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    public void updateCategory(long id, Category category){
        categoryRepository.save(category);
    }
    public void deleteCategory(long id){
        categoryRepository.deleteById(id);
    }

}
