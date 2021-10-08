package cl.kids.data.repository;

import cl.kids.entities.data.kids.Kids;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KidsRepository extends CrudRepository<Kids, Integer> {
}
