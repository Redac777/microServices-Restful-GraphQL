package org.sid.banqueaccountservice.web;

import org.sid.banqueaccountservice.dto.BanqueAccountRequestDTO;
import org.sid.banqueaccountservice.dto.BanqueAccountResponseDTO;
import org.sid.banqueaccountservice.entities.BanqueAccount;
import org.sid.banqueaccountservice.entities.Customer;
import org.sid.banqueaccountservice.repositories.BanqueAccountRepository;
import org.sid.banqueaccountservice.repositories.CustomerRepository;
import org.sid.banqueaccountservice.services.BanqueAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Controller
public class BanqueAccountGraphQLController {
    @Autowired
    private BanqueAccountRepository banqueAccountRepository;
    @Autowired
    private BanqueAccountService banqueAccountService;
    @Autowired
    private CustomerRepository customerRepository;

    @QueryMapping
    public List<BanqueAccount> accountsList(){
        return banqueAccountRepository.findAll();
    }
    @QueryMapping
    public BanqueAccount accountById(@Argument String id){
        return banqueAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @MutationMapping
    public BanqueAccountResponseDTO addAccount(@Argument BanqueAccountRequestDTO accountDTO){
        return banqueAccountService.addAccount(accountDTO);
    }
    @MutationMapping
    public BanqueAccountResponseDTO updateAccount(@Argument String id,@Argument BanqueAccountRequestDTO accountDTO){
        return banqueAccountService.updateAccount(id,accountDTO);
    }

    @MutationMapping
    public Boolean deleteAccount(@Argument String id) {
        banqueAccountRepository.deleteById(id);
        return true;
    }

    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }

}
