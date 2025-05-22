package s6.springboot.tp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import s6.springboot.tp.models.ItemCategory;

import java.util.List;

public interface ItemCategoryRepository extends JpaRepository<ItemCategory,Long> {

    List<ItemCategory> findAllByNameLike(String name);

    ItemCategory findFirstByNameLike(String name);
}
