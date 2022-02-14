package tr.com.okangulsevil.creditappbackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateUserRequest {

    private String firstName;

    private String lastName;

    private String identityNumber;

    private String phoneNumber;

    private Double salary;

}
