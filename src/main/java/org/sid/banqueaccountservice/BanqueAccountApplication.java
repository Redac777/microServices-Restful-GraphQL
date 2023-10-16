package org.sid.banqueaccountservice;

import org.sid.banqueaccountservice.entities.BanqueAccount;
import org.sid.banqueaccountservice.enums.AccountType;
import org.sid.banqueaccountservice.repositories.BanqueAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BanqueAccountApplication {

    public static void main(String[] args) {

        SpringApplication.run(BanqueAccountApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BanqueAccountRepository banqueAccountRepository){
        return args -> {
            for(int i=0;i<10;i++) {
                BanqueAccount banqueAccount = BanqueAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                        .balance(1000+Math.random()*9000)
                        .currency("MAD")
                        .createdAt(new Date())
                        .build();
                banqueAccountRepository.save(banqueAccount);
            }
        };
    }

}
