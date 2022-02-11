package tr.com.okangulsevil.creditappbackend.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCreditRequest {

    private Integer creditRating;

    private String identityNumber;

}
