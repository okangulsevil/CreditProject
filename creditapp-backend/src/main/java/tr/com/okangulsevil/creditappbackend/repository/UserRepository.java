package tr.com.okangulsevil.creditappbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.okangulsevil.creditappbackend.dto.UserDto;
import tr.com.okangulsevil.creditappbackend.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByIdentityNumber(String identityNumber);

    Optional<User> findByPhoneNumber(String phoneNumber);


}
