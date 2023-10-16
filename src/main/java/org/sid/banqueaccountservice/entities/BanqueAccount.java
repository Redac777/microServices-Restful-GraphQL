package org.sid.banqueaccountservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.banqueaccountservice.enums.AccountType;

import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class BanqueAccount {
    @Id
    private String id;
    private Double balance;
    private String currency;
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountType type;

}
