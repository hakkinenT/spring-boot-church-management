package com.hakkinenT.churchmanagement.services;

import com.hakkinenT.churchmanagement.models.dto.ChurchDTO;
import com.hakkinenT.churchmanagement.models.entities.Church;
import com.hakkinenT.churchmanagement.repositories.ChurchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChurchService {
    @Autowired
    private ChurchRepository churchRepository;

    public ChurchDTO insert(ChurchDTO dto){
        Church church = new Church();
        church.setName(dto.getName());
        church.setCnpj(dto.getCnpj());
        church.setEmail(dto.getEmail());

        if(dto.getMotherChurchCnpj() != null){
            Church mother = churchRepository.getReferenceById(dto.getMotherChurchCnpj());
            church.setMotherChurch(mother);
        }else{
            church.setMotherChurch(null);
        }

        church = churchRepository.save(church);

        return new ChurchDTO(church);
    }
}
