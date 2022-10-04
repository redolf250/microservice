package org.redolf.developer.customer;


import lombok.AllArgsConstructor;
import org.redolf.developer.rabbitmq.MessagePublisher;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static org.redolf.developer.rabbitmq.RabbitMQConfiguration.MESSAGE_QUEUE;

@Service
public record CustomerService(CustomerRepository repository, CustomerConfig customerConfig) {

    public void registerCustomer(CustomerRegisterRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
        repository.saveAndFlush(customer);
       FraudResponse response = customerConfig.restTemplate().getForObject(
                "http://FRAUD/api/v1/fraud/customer/{customerId}",
                FraudResponse.class,customer.getCustomerId()
        );
    if (response.isFraudulent()){
            throw new IllegalStateException("Fraud detected");
     }
        System.out.println("Consumer registered");
    }
}
