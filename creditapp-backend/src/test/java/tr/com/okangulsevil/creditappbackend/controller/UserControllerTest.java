package tr.com.okangulsevil.creditappbackend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import tr.com.okangulsevil.creditappbackend.BaseIntegrationTest;
import tr.com.okangulsevil.creditappbackend.dto.request.CreateUserRequest;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest extends BaseIntegrationTest {

    @Test
    void should_create_user() {

        //given
        CreateUserRequest request1 = new CreateUserRequest();
        request1.setFirstName("test user name");
        request1.setLastName("test last name");
        request1.setIdentityNumber("test id num");
        request1.setPhoneNumber("0123012");
        request1.setSalary(10000.0);

        CreateUserRequest request2 = new CreateUserRequest();
        request2.setFirstName("test user name2");
        request2.setLastName("test last name2");
        request2.setIdentityNumber("test id num2");
        request2.setPhoneNumber("0321321312");
        request2.setSalary(20000.0);

        //when

        //then
    }
}