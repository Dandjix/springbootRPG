package s6.springboot.tp.controllers;

import org.springframework.web.bind.annotation.*;
import s6.springboot.tp.models.RPGItem;
import s6.springboot.tp.models.RPGItemDTO;
import s6.springboot.tp.services.RPGItemService;

import java.util.List;

@RestController
public class RPGItemController {

    RPGItemService service;

    public RPGItemController(RPGItemService service) {
        this.service = service;
    }

    @PostMapping("rpg/items")
    public RPGItem postItem(@RequestBody RPGItemDTO dto)
    {
        return service.addItem(dto.getName(),dto.getIdCategory(),dto.getPrice(),dto.getEffect());
    }

    @GetMapping("/rpg/items")
    public List<RPGItem> getAllItems(@RequestParam(required = false) List<String> like)
    {
        if(like != null)
            return service.getAllItemsWithPatterns(like);

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
