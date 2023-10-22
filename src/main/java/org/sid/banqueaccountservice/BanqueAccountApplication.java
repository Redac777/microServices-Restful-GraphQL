package org.sid.banqueaccountservice;

import org.sid.banqueaccountservice.entities.BanqueAccount;
import org.sid.banqueaccountservice.entities.Customer;
import org.sid.banqueaccountservice.enums.AccountType;
import org.sid.banqueaccountservice.repositories.BanqueAccountRepository;
import org.sid.banqueaccountservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BanqueAccountApplication {

    public static void main(String[] args) {

        SpringApplication.run(BanqueAccountApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BanqueAccountRepository banqueAccountRepository, CustomerRepository customerRepository){
        return args -> {
            Stream.of("Mohammed","Yassine","Hanae","Imane").forEach(c->{
                Customer customer = Customer.builder()
                        .name(c)
                        .build();
               customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer->{
                for(int i=0;i<10;i++) {
                    BanqueAccount banqueAccount = BanqueAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                            .balance(1000+Math.random()*9000)
                            .currency("MAD")
                            .createdAt(new Date())
                            .customer(customer)
                            .build();
                    banqueAccountRepository.save(banqueAccount);
                }
            });

        };
    }

}
