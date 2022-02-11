package tr.com.okangulsevil.creditappbackend.dto.converter;

import org.springframework.stereotype.Component;
import tr.com.okangulsevil.creditappbackend.dto.CreditDto;
import tr.com.okangulsevil.creditappbackend.model.Credit;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreditDtoConverter {

    public CreditDto convert(Credit credit){
        return new CreditDto(
                credit.getId(),
                credit.getCreditRating(),
                credit.getCreditLimit(),
                credit.getCreditStatus()
        );
    }

    public List<CreditDto> convertToCreditDtos(List<Credit> credits){
        return credits.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
