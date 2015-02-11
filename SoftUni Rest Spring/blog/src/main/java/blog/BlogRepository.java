package blog;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "blog", path = "blog")
public interface BlogRepository extends PagingAndSortingRepository<Blog,Long> {
	
	List<Blog> findByName(@Param("name") String name);
	
}
