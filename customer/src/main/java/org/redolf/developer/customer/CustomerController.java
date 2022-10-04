package org.redolf.developer.customer;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public record CustomerController(CustomerService customerService) {



    @GetMapping("/home")
    private String home(){
        return "Is up and running";
    }

    @PostMapping("/register")
    public void registerCustomer(@RequestBody CustomerRegisterRequest customerRequest){
           customerService.registerCustomer(customerRequest);

        }
}
