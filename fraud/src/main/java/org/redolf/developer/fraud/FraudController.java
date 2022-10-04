package org.redolf.developer.fraud;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud")
public record FraudController(FraudService fraudService) {

    @GetMapping("customer/{customerId}")
    private FraudResponse isFraudster(@PathVariable("customerId") Integer customerId) {
       boolean isFraudster =fraudService.isFraudulent(customerId);
       return  new FraudResponse(isFraudster);
    }
}
