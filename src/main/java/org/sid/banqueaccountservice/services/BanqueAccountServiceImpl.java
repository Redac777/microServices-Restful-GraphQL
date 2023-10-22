package org.sid.banqueaccountservice.services;

import org.sid.banqueaccountservice.dto.BanqueAccountRequestDTO;
import org.sid.banqueaccountservice.dto.BanqueAccountResponseDTO;
import org.sid.banqueaccountservice.entities.BanqueAccount;
import org.sid.banqueaccountservice.mappers.BanqueAccountMapper;
import org.sid.banqueaccountservice.repositories.BanqueAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BanqueAccountServiceImpl implements BanqueAccountService {
    @Autowired
    BanqueAccountRepository banqueAccountRepository;
    @Autowired
    BanqueAccountMapper banqueAccountMapper;
    @Override
    public BanqueAccountResponseDTO addAccount(BanqueAccountRequestDTO banqueAccountDTO) {
        BanqueAccount banqueAccount = banqueAccountMapper.fromBanqueAccountRequestDTO(banqueAccountDTO);
        BanqueAccount savedBanqueAccount = banqueAccountRepository.save(banqueAccount);
        BanqueAccountResponseDTO banqueAccountResponseDTO = banqueAccountMapper.fromBanqueAccount(savedBanqueAccount);
        return banqueAccountResponseDTO;
    }
    @Override
    public BanqueAccountResponseDTO updateAccount(String id, BanqueAccountRequestDTO banqueAccountDTO) {
        BanqueAccount banqueAccount = banqueAccountMapper.fromBanqueAccountRequestDTOForUpdate(id,banqueAccountDTO);
        BanqueAccount savedBanqueAccount = banqueAccountRepository.save(banqueAccount);
        BanqueAccountResponseDTO banqueAccountResponseDTO = banqueAccountMapper.fromBanqueAccount(savedBanqueAccount);
        return banqueAccountResponseDTO;
    }
}
