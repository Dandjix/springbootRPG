package s6.springboot.tp.services;

import org.springframework.stereotype.Service;
import s6.springboot.tp.models.ItemCategory;
import s6.springboot.tp.models.RPGItem;
import s6.springboot.tp.repositories.RPGItemRepository;

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
        return repository.findByIdCategoryEquals(cat.getId());
    }

    public void addItem()
    {
        RPGItem item = new RPGItem();
    }

    public List<RPGItem> getItemsOfCategoryAndMaxPrice(String catName, float maxPrice) {
        ItemCategory cat = itemCategoryService.findByName(catName);
        return repository.findAllByIdCategoryEqualsAndPriceLessThanEqual(cat.getId(),maxPrice);
    }
}
