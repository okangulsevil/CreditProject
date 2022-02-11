package tr.com.okangulsevil.creditappbackend.controller;

import org.springframework.web.bind.annotation.*;
import tr.com.okangulsevil.creditappbackend.dto.UserDto;
import tr.com.okangulsevil.creditappbackend.dto.request.CreateUserRequest;
import tr.com.okangulsevil.creditappbackend.dto.request.UpdateUserRequest;
import tr.com.okangulsevil.creditappbackend.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getall")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getById/{userId}")
    public UserDto getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/getByIdentityNumber/{identityNumber}")
    public UserDto findUserByIdentityNumber(@PathVariable String identityNumber){
        return userService.findUserByIdentityNumber(identityNumber);
    }

    @GetMapping("/getByPhoneNumber/{phoneNumber}")
    public UserDto findUserByPhoneNumber(@PathVariable String phoneNumber){
        return userService.findUserByPhoneNumber(phoneNumber);
    }

    @PostMapping("/create")
    public UserDto createUser(@RequestBody CreateUserRequest createUserRequest){
        return userService.saveUser(createUserRequest);
    }

    @PutMapping("/update/{userId}")
    public UserDto updateUser(@PathVariable Long userId, @RequestBody UpdateUserRequest updateUserRequest){
        return userService.updateUser(userId, updateUserRequest);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}
