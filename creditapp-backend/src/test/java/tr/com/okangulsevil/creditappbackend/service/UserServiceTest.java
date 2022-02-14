package tr.com.okangulsevil.creditappbackend.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tr.com.okangulsevil.creditappbackend.TestSupport;
import tr.com.okangulsevil.creditappbackend.dto.UserDto;
import tr.com.okangulsevil.creditappbackend.dto.converter.UserDtoConverter;
import tr.com.okangulsevil.creditappbackend.dto.request.UpdateUserRequest;
import tr.com.okangulsevil.creditappbackend.exception.GeneralNotFoundException;
import tr.com.okangulsevil.creditappbackend.model.User;
import tr.com.okangulsevil.creditappbackend.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserServiceTest extends TestSupport {

    private UserRepository userRepository;
    private UserDtoConverter userDtoConverter;

    private UserService userService;

    @BeforeEach
    void setUp(){
        userRepository = Mockito.mock(UserRepository.class);
        userDtoConverter = Mockito.mock(UserDtoConverter.class);

        userService = new UserService(userRepository, userDtoConverter);
    }

    @Test
    void testGetUserById_whenCalledExistId_itShouldReturnUserDto(){

        User user = generateUser();
        UserDto userDto = generateUserDto();

        Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        Mockito.when(userDtoConverter.convert(user)).thenReturn(userDto);

        UserDto result = userService.getUserById(user.getId());

        assertEquals(userDto, result);

        Mockito.verify(userRepository).findById(user.getId());
        Mockito.verify(userDtoConverter).convert(user);
    }

    @Test
    void testGetUserById_whenCalledIdNotExists_itShouldThrowNotFoundException() {

        Mockito.when(userRepository.findById(generateUser().getId())).thenThrow(GeneralNotFoundException.class);

        assertThrows(GeneralNotFoundException.class, () -> userService.getUserById(generateUser().getId()));

        Mockito.verify(userRepository).findById(generateUser().getId());
        Mockito.verifyNoInteractions(userDtoConverter);
    }

    @Test
    void testGetUserList_itShouldReturnListOfUserDto() {

        List<User> repositoryList = generateListOfUser();
        List<UserDto> userDtoList = generateListOfUserDto();

        Mockito.when(userRepository.findAll())
                .thenReturn(repositoryList);
        Mockito.when(userDtoConverter.convertToUserDtos(repositoryList))
                .thenReturn(userDtoList);

        List<UserDto> result = userService.getAllUsers();

        assertEquals(userDtoList, result);

        Mockito.verify(userRepository).findAll();
        Mockito.verify(userDtoConverter).convertToUserDtos(repositoryList);
    }



    @Test
    void testDeleteUser_whenCalledInValidId_itShouldThrowNotFoundException() {

        Mockito.when(userRepository.findById(generateUser().getId())).thenThrow(GeneralNotFoundException.class);

        assertThrows(GeneralNotFoundException.class, () -> userService.getUserById(generateUser().getId()));

        Mockito.verify(userRepository).findById(generateUser().getId());
        Mockito.verifyNoInteractions(userDtoConverter);
    }



    @Test
    void testUpdateUser_whenCalledIdInValid_itShouldThrowNotFoundException() {

        UpdateUserRequest request = generateUpdateUserRequest();

        Mockito.when(userRepository.findById(generateUser().getId())).thenThrow(GeneralNotFoundException.class);

        assertThrows(GeneralNotFoundException.class, () -> userService.updateUser(generateUser().getId(), request));

        Mockito.verify(userRepository).findById(generateUser().getId());
        Mockito.verifyNoInteractions(userDtoConverter);
    }
}
