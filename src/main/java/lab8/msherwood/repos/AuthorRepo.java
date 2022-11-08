package lab8.msherwood.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lab8.msherwood.model.Author;


@Repository
public interface AuthorRepo extends CrudRepository<Author, Integer> {
    
    
}
