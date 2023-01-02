package com.controller;

import com.domain.Category;
import com.exception.BadRequestAlertException;
import com.exception.NotFoundAlertException;
import com.service.CategoryService;
import com.service.CategoryService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @CrossOrigin
    @PostMapping("/cat")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) throws Exception {
        if (category.getId() != null) {
            throw new BadRequestAlertException("A new leave application cannot have an id value");
        }
        System.out.println(category);
        categoryService.insert(category);
        return ResponseEntity.created(new URI("/cat/"))
                .body(category);
    }
    @CrossOrigin
    @PutMapping("/cat")
    public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category) throws Exception {
        if (category.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        categoryService.update(category);
        return ResponseEntity.created(new URI("/cat/"))
                .body(category);
    }

    @CrossOrigin
    @PutMapping("/cat/{category_name}")
    public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category,@PathVariable String category_name) throws Exception {
        Category t = categoryService.getByCategoryName(category_name);
        // taxCategory.setCategory_id(t.getCategory_id());
        category.setId(t.getId());
        System.out.println(category.getId());
        if (category.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        categoryService.update(category);
        return ResponseEntity.created(new URI("/cat/"))
                .body(category);
    }

    @CrossOrigin
    @GetMapping("/cat")
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> category = categoryService.getAll();
        //System.out.println(category.);
        return ResponseEntity.ok().body(category);
    }
    @CrossOrigin
    @GetMapping("/cat/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        Optional<Category> category = Optional.ofNullable(categoryService.get(id));
        if (category.isPresent()) {
            return ResponseEntity.ok().body(category.get());
        }
        throw new NotFoundAlertException("Record not found [" + id + "]");
    }
    @CrossOrigin
    @DeleteMapping("/cat/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }




}
