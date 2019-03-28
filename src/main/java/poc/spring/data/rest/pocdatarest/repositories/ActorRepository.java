package poc.spring.data.rest.pocdatarest.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import poc.spring.data.rest.pocdatarest.entities.Actor;

@RepositoryRestResource(collectionResourceRel = "actors", path = "actors")
public interface ActorRepository extends PagingAndSortingRepository<Actor, Long>{
	List<Actor> findByFirstName(@Param("name") String name);
}
