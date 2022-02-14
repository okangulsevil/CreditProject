package tr.com.okangulsevil.creditappbackend.service;

import org.springframework.stereotype.Service;
import tr.com.okangulsevil.creditappbackend.dto.UserDto;
import tr.com.okangulsevil.creditappbackend.dto.converter.UserDtoConverter;
import tr.com.okangulsevil.creditappbackend.dto.request.CreateUserRequest;
import tr.com.okangulsevil.creditappbackend.dto.request.UpdateUserRequest;
import tr.com.okangulsevil.creditappbackend.exception.GeneralNotFoundException;
import tr.com.okangulsevil.creditappbackend.model.User;
import tr.com.okangulsevil.creditappbackend.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public List<UserDto> getAllUsers() {
        return userDtoConverter.convertToUserDtos(userRepository.findAll());
    }

    public UserDto saveUser(CreateUserRequest createUserRequest) {
        User user = new User(
                createUserRequest.getFirstName(),
                createUserRequest.getLastName(),
                createUserRequest.getIdentityNumber(),
                createUserRequest.getPhoneNumber(),
                createUserRequest.getSalary()
        );
        return userDtoConverter.convert(userRepository.save(user));
    }

    public UserDto getUserById(Long userId) {
        return userDtoConverter.convert(userRepository.findById(userId).orElseThrow(
                () -> new GeneralNotFoundException("User not found User İD: " + userId)
        ));
    }

    public UserDto updateUser(Long userId, UpdateUserRequest updateUserRequest) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            User foundUser = user.get();
            foundUser.setFirstName(updateUserRequest.getFirstName());
            foundUser.setLastName(updateUserRequest.getLastName());
            foundUser.setIdentityNumber(foundUser.getIdentityNumber());
            foundUser.setPhoneNumber(updateUserRequest.getPhoneNumber());
            foundUser.setSalary(updateUserRequest.getSalary());
            return userDtoConverter.convert(userRepository.save(foundUser));
        }else
            return null;
    }

    public void deleteUser(Long userId) {
        getUserById(userId);
        userRepository.deleteById(userId);
    }

    public UserDto findUserByIdentityNumber(String identityNumber){
        return userDtoConverter.convert(getUserByIdentityNumber(identityNumber));
    }

    protected User getUserByIdentityNumber(String identityNumber){
        return userRepository.findByIdentityNumber(identityNumber).orElseThrow(
                () -> new GeneralNotFoundException("User not found with Identity Number : " + identityNumber)
        );
    }

    public UserDto findUserByPhoneNumber(String phoneNumber) {
        return userDtoConverter.convert(userRepository.findByPhoneNumber(phoneNumber).orElseThrow(
                () -> new GeneralNotFoundException("User not found with Phone Number : " + phoneNumber)
        ));
    }

}
