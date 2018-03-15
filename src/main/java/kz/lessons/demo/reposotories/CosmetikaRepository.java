package kz.lessons.demo.reposotories;


import kz.lessons.demo.models.Cosmetika;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CosmetikaRepository extends CrudRepository<Cosmetika,Long> {
    Optional<Cosmetika> findById(Long id);
}
