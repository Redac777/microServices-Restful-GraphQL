package org.sid.banqueaccountservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.banqueaccountservice.enums.AccountType;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BanqueAccountResponseDTO {
    private String id;
    private Double balance;
    private String currency;
    private Date createdAt;
    private AccountType type;
}
