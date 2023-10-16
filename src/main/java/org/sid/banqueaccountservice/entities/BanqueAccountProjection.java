package org.sid.banqueaccountservice.entities;

import org.sid.banqueaccountservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BanqueAccount.class , name="p1")
public interface BanqueAccountProjection {
    public String getId();
    public AccountType getType();
}
