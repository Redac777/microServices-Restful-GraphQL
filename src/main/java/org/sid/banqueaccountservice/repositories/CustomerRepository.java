package org.sid.banqueaccountservice.repositories;

import org.sid.banqueaccountservice.entities.BanqueAccount;
import org.sid.banqueaccountservice.entities.Customer;
import org.sid.banqueaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;



public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
