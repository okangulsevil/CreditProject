package tr.com.okangulsevil.creditappbackend.controller;

import org.springframework.web.bind.annotation.*;
import tr.com.okangulsevil.creditappbackend.dto.CreditDto;
import tr.com.okangulsevil.creditappbackend.dto.request.CreateCreditRequest;
import tr.com.okangulsevil.creditappbackend.service.CreditService;
@RestController
@RequestMapping("/credits")
public class CreditController {

    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @PostMapping
    public CreditDto createCredit(@RequestBody CreateCreditRequest createCreditRequest){
        return  creditService.createCreditByIdentityNumber(createCreditRequest);
    }
}
