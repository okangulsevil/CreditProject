package tr.com.okangulsevil.creditappbackend;

import org.hibernate.sql.Update;
import tr.com.okangulsevil.creditappbackend.dto.CreditDto;
import tr.com.okangulsevil.creditappbackend.dto.UserDto;
import tr.com.okangulsevil.creditappbackend.dto.request.CreateCreditRequest;
import tr.com.okangulsevil.creditappbackend.dto.request.CreateUserRequest;
import tr.com.okangulsevil.creditappbackend.dto.request.UpdateUserRequest;
import tr.com.okangulsevil.creditappbackend.model.Credit;
import tr.com.okangulsevil.creditappbackend.model.User;
import tr.com.okangulsevil.creditappbackend.model.enums.CreditStatus;

import java.util.List;

public class TestSupport {

    //User Test Support
    public User generateUser() {
        return new User(
                "firstname",
                "lastname",
                "identityNumber",
                "phoneNumber",
                10000.0
        );
    }

    public UserDto generateUserDto(){
        return new UserDto(
                generateUser().getId(),
                "firstName",
                "lastName",
                "identityNumber",
                "phoneNumber",
                12000.0,
                null
        );
    }

    public List<User> generateListOfUser(){
        User user = generateUser();
        return List.of(user);
    }

    public List<UserDto> generateListOfUserDto(){
        UserDto user = generateUserDto();
        return List.of(user);
    }

    public CreateUserRequest generateCreateUserRequest(){
        return new CreateUserRequest(
                "firstName",
                "lastName",
                "identityNumber",
                "phoneNumber",
                12000.0
        );
    }

    public UpdateUserRequest generateUpdateUserRequest(){
        return new UpdateUserRequest(
                "firstname",
                "lastname",
                "phoneNumber",
                14000.0
        );
    }

    public User generateUpdatedUser(User from, UpdateUserRequest request){
        return new User(
                from.getId(),
                request.getFirstName(),
                request.getLastName(),
                from.getIdentityNumber(),
                request.getPhoneNumber(),
                request.getSalary(),
                null
        );
    }

    //Credit Test Support
    public Credit generateCredit(){
        User user = generateUser();
        return new Credit(
                1000,
                CreditStatus.APPROVED,
                user

        );
    }

    public CreditDto generateCreditDto(){
        UserDto user = generateUserDto();
        return new CreditDto(
                generateCreditDto().getId(),
                450,
                1000.0,
                CreditStatus.DENIED
        );
    }

    public List<Credit> generateCreditList(){
        return List.of(generateCredit());
    }

    public List<CreditDto> generateCreditDtoList(){
        return List.of(generateCreditDto());
    }

    public CreateCreditRequest generateCreateCreditRequest(){
        return new CreateCreditRequest(
                123,
                "identityNumber"
        );
    }
}