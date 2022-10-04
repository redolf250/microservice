package org.redolf.developer.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="fraud")
public class FraudChecker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer fraudId;
    private Integer customerId;
    private boolean isFraud;
    private LocalDateTime timestamp;
}
