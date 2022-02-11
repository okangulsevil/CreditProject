package tr.com.okangulsevil.creditappbackend.dto.converter;

import org.springframework.stereotype.Component;
import tr.com.okangulsevil.creditappbackend.dto.UserDto;
import tr.com.okangulsevil.creditappbackend.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {

    private final CreditDtoConverter creditDtoConverter;

    public UserDtoConverter(CreditDtoConverter creditDtoConverter) {
        this.creditDtoConverter = creditDtoConverter;
    }

    public UserDto convert(User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getIdentityNumber(),
                user.getPhoneNumber(),
                user.getSalary(),
                creditDtoConverter.convertToCreditDtos(user.getCredits())
        );
    }

    public List<UserDto> convertToUserDtos(List<User> users){
        return users.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
