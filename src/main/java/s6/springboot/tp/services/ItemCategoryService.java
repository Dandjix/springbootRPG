package s6.springboot.tp.services;

import org.springframework.stereotype.Service;
import s6.springboot.tp.models.ItemCategory;
import s6.springboot.tp.repositories.ItemCategoryRepository;

import java.util.List;

@Service
public class ItemCategoryService {

    ItemCategoryRepository repository;

    public ItemCategoryService(ItemCategoryRepository repository)
    {
        this.repository = repository;
    }

    public List<ItemCategory> getAllItemCategories()
    {
        return repository.findAll();
    }

    public ItemCategory findByName(String name)
    {
        return repository.findFirstByNameLike(name);
    }

    public ItemCategory createCategory(String name)
    {
        ItemCategory category = new ItemCategory(name);
        if(!repository.findAllByNameLike(name).isEmpty())
            return null;

        repository.save(category);
        return category;
    }
}
