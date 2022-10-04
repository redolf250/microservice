package org.redolf.developer.rabbitmq;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Component
public class CustomMessage {

    private String messageId;
    private String message;
    private Date messageDate;

}
