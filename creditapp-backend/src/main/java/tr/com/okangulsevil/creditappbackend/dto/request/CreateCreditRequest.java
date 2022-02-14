package tr.com.okangulsevil.creditappbackend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateCreditRequest {

    private Integer creditRating;

    private String identityNumber;

}
