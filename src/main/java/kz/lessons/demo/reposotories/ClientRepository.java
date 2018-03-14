package kz.lessons.demo.reposotories;

import kz.lessons.demo.models.Client;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long>{
    Optional<Client> findById(Long id);

}
