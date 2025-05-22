package s6.springboot.tp.services;

import org.springframework.stereotype.Service;
import s6.springboot.tp.models.ItemCategory;
import s6.springboot.tp.models.RPGItem;
import s6.springboot.tp.repositories.RPGItemRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class RPGItemService {
    RPGItemRepository repository;
    ItemCategoryService itemCategoryService;

    public  RPGItemService(RPGItemRepository repository, ItemCategoryService itemCategoryService)
    {
        this.itemCategoryService = itemCategoryService;
        this.repository = repository;
    }

    public List<RPGItem> getAllItems()
    {
        return repository.findAll();
    }

    public List<RPGItem> getItemsOfCategory(String catName)
    {
        ItemCategory cat = itemCategoryService.findByName(catName);
        if(cat == null)
            return new ArrayList<RPGItem>(0);
        return repository.findByIdCategoryEquals(cat.getId());
    }

    public RPGItem addItem(String name, long id_category, float price, String effect)
    {
        RPGItem item = new RPGItem(name,id_category,price,effect);

        repository.save(item);

        return item;
    }

    public List<RPGItem> getItemsOfCategoryAndMaxPrice(String catName, float maxPrice) {
        ItemCategory cat = itemCategoryService.findByName(catName);
        if(cat == null)
            return new ArrayList<RPGItem>(0);
        return repository.findAllByIdCategoryEqualsAndPriceLessThanEqual(cat.getId(),maxPrice);
    }

    public List<RPGItem> getAllItemsWithPatterns(List<String> namePaterns) {
        HashMap<String,RPGItem> foundItems = new HashMap<String, RPGItem>();
        for(String pattern : namePaterns)
        {
            List<RPGItem> items = repository.findAllByNameLike(pattern);
            for(RPGItem item : items)
            {
                foundItems.put(item.getName(),item);
            }
        }
        return new ArrayList<RPGItem>(foundItems.values());
    }
}
