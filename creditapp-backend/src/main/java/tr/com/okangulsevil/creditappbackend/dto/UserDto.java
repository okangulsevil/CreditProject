package tr.com.okangulsevil.creditappbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String identityNumber;

    private String phoneNumber;

    private Double salary;

    private List<CreditDto> creditDtos;
}
