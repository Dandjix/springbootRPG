package s6.springboot.tp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import s6.springboot.tp.models.RPGItem;

import java.util.List;

public interface RPGItemRepository extends JpaRepository<RPGItem,Long> {
    List<RPGItem> findByIdCategoryEquals(Long id_category);

    List<RPGItem> findAllByIdCategoryEqualsAndPriceLessThanEqual(long idCategory, float priceIsLessThan);

    List<RPGItem> findAllByNameLike(String name);

    List<RPGItem> findAllByNameLikeAndNameLike(String name, String name1);
}
