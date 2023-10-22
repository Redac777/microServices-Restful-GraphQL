package org.sid.banqueaccountservice.services;

import org.sid.banqueaccountservice.dto.BanqueAccountRequestDTO;
import org.sid.banqueaccountservice.dto.BanqueAccountResponseDTO;

public interface BanqueAccountService {
    public BanqueAccountResponseDTO addAccount(BanqueAccountRequestDTO banqueAccountDTO);

    BanqueAccountResponseDTO updateAccount(String id, BanqueAccountRequestDTO banqueAccountDTO);
}
