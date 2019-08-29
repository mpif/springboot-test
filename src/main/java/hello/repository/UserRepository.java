package hello.repository;

import hello.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: mpif
 * @date: 2019-08-29 09:53
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
