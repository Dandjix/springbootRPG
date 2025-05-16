package s6.springboot.tp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import s6.springboot.tp.models.ItemCategory;
import s6.springboot.tp.services.ItemCategoryService;

import java.util.List;

@RestController
public class ItemCategoryController {
    public ItemCategoryService service;

    public ItemCategoryController(ItemCategoryService service)
    {
        this.service = service;
    }

    @GetMapping("/rpg/categories")
    public List<ItemCategory> getAllCategories()
    {
        return  service.getAllItemCategories();
    }

    @PostMapping("/rpg/categories/{name}")
    public ItemCategory createCategory(@PathVariable(required = true)String name)
    {
        return service.createCategory(name);
    }
}
