package org.sid.banqueaccountservice.entities;

import jakarta.persistence.*;
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
    @ManyToOne
    private Customer customer;

}
