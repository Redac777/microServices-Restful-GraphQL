package org.sid.banqueaccountservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.banqueaccountservice.enums.AccountType;


@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BanqueAccountRequestDTO {
    private Double balance;
    private String currency;
    private AccountType type;
}
