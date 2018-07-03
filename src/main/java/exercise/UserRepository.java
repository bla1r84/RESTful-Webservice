package exercise;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import exercise.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query(value = "SELECT * FROM USER WHERE EMAIL = :email OR IP_ADDRESS = :ipAddress", nativeQuery = true)
	Optional<User> getUser(@Param("email") String email, @Param("ipAddress") String ipAddress);
}
