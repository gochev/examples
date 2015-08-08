package org.delme.repository;

import org.delme.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "user")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
