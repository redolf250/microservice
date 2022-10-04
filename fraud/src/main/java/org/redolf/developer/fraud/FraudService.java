package org.redolf.developer.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record FraudService(FraudRepository fraudRepository) {

    public boolean isFraudulent(Integer customerId) {
        FraudChecker fraudChecker = FraudChecker.builder()
                .customerId(customerId)
                .isFraud(false)
                .timestamp(LocalDateTime.now())
                .build();
        fraudRepository.save(fraudChecker);
        return false;
    }
}
