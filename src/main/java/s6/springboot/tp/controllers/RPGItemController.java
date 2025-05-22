package s6.springboot.tp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import s6.springboot.tp.models.RPGItem;
import s6.springboot.tp.services.RPGItemService;

import java.util.List;

@RestController
public class RPGItemController {

    RPGItemService service;

    public RPGItemController(RPGItemService service) {
        this.service = service;
    }

    @GetMapping("/rpg/items")
    public List<RPGItem> getAllItems()
    {
        return service.getAllItems();
    }

    @GetMapping("rpg/items/{catName}")
    public List<RPGItem> getItemsByCategory(@PathVariable String catName, @RequestParam(required = false) Float maxPrice)
    {
        if(maxPrice != null)
        {
            return service.getItemsOfCategoryAndMaxPrice(catName,maxPrice);
        }
        return service.getItemsOfCategory(catName);

    }
}
