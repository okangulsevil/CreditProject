package tr.com.okangulsevil.creditappbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.okangulsevil.creditappbackend.dto.UserDto;
import tr.com.okangulsevil.creditappbackend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByIdentityNumber(String identityNumber);

    User findByPhoneNumber(String phoneNumber);
}
