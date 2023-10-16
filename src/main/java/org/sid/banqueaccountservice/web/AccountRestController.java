package org.sid.banqueaccountservice.web;

import org.sid.banqueaccountservice.dto.BanqueAccountRequestDTO;
import org.sid.banqueaccountservice.dto.BanqueAccountResponseDTO;
import org.sid.banqueaccountservice.entities.BanqueAccount;
import org.sid.banqueaccountservice.mappers.BanqueAccountMapper;
import org.sid.banqueaccountservice.repositories.BanqueAccountRepository;
import org.sid.banqueaccountservice.services.BanqueAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BanqueAccountRepository banqueAccountRepository;
    private BanqueAccountService  banqueAccountService;
    private BanqueAccountMapper banqueAccountMapper;
    public AccountRestController(BanqueAccountRepository banqueAccountRepository, BanqueAccountService banqueAccountService, BanqueAccountMapper banqueAccountMapper) {
        this.banqueAccountRepository = banqueAccountRepository;
        this.banqueAccountService = banqueAccountService;
        this.banqueAccountMapper = banqueAccountMapper;
    }


    @GetMapping("/banqueAccounts")
    public List<BanqueAccount> banqueAccounts(){
        return banqueAccountRepository.findAll();
    }
 @GetMapping("/banqueAccounts/{id}")
    public BanqueAccount banqueAccount(@PathVariable String id) {
        return banqueAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @PostMapping("/banqueAccounts")
    public BanqueAccountResponseDTO save(@RequestBody BanqueAccountRequestDTO requestDTO){
        return banqueAccountService.addAccount(requestDTO);
    }

    @PatchMapping("/banqueAccounts/{id}")
    public BanqueAccount update(@PathVariable String id, @RequestBody BanqueAccount banqueAccount){
        BanqueAccount account = banqueAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
        if(banqueAccount.getBalance()!=null) account.setBalance(banqueAccount.getBalance());
        if(banqueAccount.getCreatedAt()!=null) account.setCreatedAt(new Date());
        if(banqueAccount.getCurrency()!=null) account.setCurrency(banqueAccount.getCurrency());
        if(banqueAccount.getType() !=null) account.setType(banqueAccount.getType());
        return banqueAccountRepository.save(account);
    }

    @DeleteMapping("/banqueAccounts/{id}")
    public void deleteBanqueAccount(@PathVariable String id) {
       banqueAccountRepository.deleteById(id);
    }


}
