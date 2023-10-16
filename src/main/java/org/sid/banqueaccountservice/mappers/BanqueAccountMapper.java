package org.sid.banqueaccountservice.mappers;

import org.sid.banqueaccountservice.dto.BanqueAccountRequestDTO;
import org.sid.banqueaccountservice.dto.BanqueAccountResponseDTO;
import org.sid.banqueaccountservice.entities.BanqueAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class BanqueAccountMapper {
    public BanqueAccountResponseDTO fromBanqueAccount(BanqueAccount banqueAccount){
        BanqueAccountResponseDTO banqueAccountResponseDTO = new BanqueAccountResponseDTO();
        BeanUtils.copyProperties(banqueAccount,banqueAccountResponseDTO);
        return banqueAccountResponseDTO;
    }
    public BanqueAccount fromBanqueAccountRequestDTO(BanqueAccountRequestDTO banqueAccountRequestDTO){
        BanqueAccount banqueAccount = BanqueAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .build();
        BeanUtils.copyProperties(banqueAccountRequestDTO,banqueAccount);
        return banqueAccount;
    }
}
