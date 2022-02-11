package tr.com.okangulsevil.creditappbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.okangulsevil.creditappbackend.model.enums.CreditStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditDto {

    private Long id;

    private Integer creditRating;

    private Double creditLimit;

    private CreditStatus creditStatus = CreditStatus.APPROVED;

}
