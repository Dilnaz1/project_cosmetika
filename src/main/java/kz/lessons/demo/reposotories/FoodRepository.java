package kz.lessons.demo.reposotories;


import kz.lessons.demo.models.Food;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FoodRepository extends CrudRepository<Food,Long> {
    Optional<Food> findById(Long id);
}
