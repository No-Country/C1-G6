package io.orderup.controllers;

import io.orderup.models.Category;
import io.orderup.services.CategoryService;
import io.orderup.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getcategorys(@RequestParam(required = false) String name){
        return categoryService.getAllCategorys();
    }

    @RequestMapping("/categories/{id}")
    public Optional<Category> getCategory(@PathVariable long id){
        return categoryService.getCategory(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/categories", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void addCategory(@ModelAttribute Category category, MultipartFile imgFile) throws IOException {
        String fileName = StringUtils.cleanPath(imgFile.getOriginalFilename());
        String Dir = "X:/Éxito/Desarrollo Web/OrderUp/src/main/resources/images/" + fileName;
        FileUploadUtil.saveFile(Dir, fileName, imgFile);
        category.setImage(Dir);
        categoryService.addCategory(category);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/categories/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateCategory(@PathVariable long id, @ModelAttribute Category category, Optional<MultipartFile> imgFile) throws IOException {
        if (imgFile != null){
            MultipartFile img = imgFile.get();
            String fileName = StringUtils.cleanPath(img.getOriginalFilename());
            String Dir = "C:/xampp/htdocs/Xavier-Motors-frontend/src/assets/css/Images/" + fileName;
            FileUploadUtil.saveFile(Dir, fileName, img);
            category.setImage(Dir);
        }
        Category oldcategory = getCategory(id).get();
        if (category.getName() == null){
            category.setName(oldcategory.getName());
        }
        if (category.getImage() == null){
            category.setImage(oldcategory.getImage());
        }
        categoryService.updateCategory(id, category);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/categories/{id}")
    public void deleteCategory(@PathVariable long id){
        categoryService.deleteCategory(id);
    }
}
