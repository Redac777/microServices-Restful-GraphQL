package org.sid.banqueaccountservice.repositories;

import org.sid.banqueaccountservice.entities.BanqueAccount;
import org.sid.banqueaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


@RepositoryRestResource
public interface BanqueAccountRepository extends JpaRepository<BanqueAccount,String> {
    @RestResource(path = "/byType")
    List<BanqueAccount> findByType(@Param("t") AccountType type);

}
