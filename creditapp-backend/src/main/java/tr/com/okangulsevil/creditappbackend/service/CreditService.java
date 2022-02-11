package tr.com.okangulsevil.creditappbackend.service;

import org.springframework.stereotype.Service;
import tr.com.okangulsevil.creditappbackend.dto.CreditDto;
import tr.com.okangulsevil.creditappbackend.dto.converter.CreditDtoConverter;
import tr.com.okangulsevil.creditappbackend.dto.request.CreateCreditRequest;
import tr.com.okangulsevil.creditappbackend.model.Credit;
import tr.com.okangulsevil.creditappbackend.model.User;
import tr.com.okangulsevil.creditappbackend.model.enums.CreditStatus;
import tr.com.okangulsevil.creditappbackend.repository.CreditRepository;

@Service
public class CreditService {

    private final CreditRepository creditRepository;
    private final UserService userService;
    private final CreditDtoConverter creditDtoConverter;

    public CreditService(CreditRepository creditRepository, UserService userService, CreditDtoConverter creditDtoConverter) {
        this.creditRepository = creditRepository;
        this.userService = userService;
        this.creditDtoConverter = creditDtoConverter;
    }

    public CreditDto createCreditByIdentityNumber(CreateCreditRequest createCreditRequest) {

        User user = userService.getUserByIdentityNumber(createCreditRequest.getIdentityNumber());
        if(createCreditRequest.getCreditRating() < 500){
            Credit credit = new Credit(
                    createCreditRequest.getCreditRating(),
                    CreditStatus.DENIED,
                    user
            );
            return creditDtoConverter.convert(creditRepository.save(credit));
        }else if(createCreditRequest.getCreditRating() >= 500 && createCreditRequest.getCreditRating() < 1000 && user.getSalary() < 5000){
            Credit credit = new Credit(
                    createCreditRequest.getCreditRating(),
                    10000.0,
                    CreditStatus.APPROVED,
                    user
            );
            return creditDtoConverter.convert(creditRepository.save(credit));
        }else if(createCreditRequest.getCreditRating() >= 500 && createCreditRequest.getCreditRating() < 1000 && user.getSalary() > 5000){
            Credit credit = new Credit(
                    createCreditRequest.getCreditRating(),
                    20000.0,
                    CreditStatus.APPROVED,
                    user
            );
            return creditDtoConverter.convert(creditRepository.save(credit));
        }else if(createCreditRequest.getCreditRating() >= 1000){
            Credit credit = new Credit(
                    createCreditRequest.getCreditRating(),
                    user.getSalary() * 4,
                    CreditStatus.APPROVED,
                    user
            );
            return creditDtoConverter.convert(creditRepository.save(credit));
        }else
            return null;
    }
}
