package com.hakkinenT.churchmanagement.services;

import com.hakkinenT.churchmanagement.models.dto.ChurchDTO;
import com.hakkinenT.churchmanagement.models.dto.ChurchMotherDTO;
import com.hakkinenT.churchmanagement.models.entities.Church;
import com.hakkinenT.churchmanagement.models.projections.ChurchProjection;
import com.hakkinenT.churchmanagement.repositories.ChurchRepository;
import com.hakkinenT.churchmanagement.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ChurchMotherDTO searchChurchMotherAndCongregations(String cnpj){
        List<ChurchProjection> churchs = churchRepository.searchChurchMotherAndCongregations(cnpj);
        ChurchProjection mother = churchs
                .stream()
                .filter(church -> church.getMotherChurchCnpj() == null)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("A igreja nao existe"));

        List<ChurchProjection> congregations = churchs
                .stream()
                .filter(church -> church.getMotherChurchCnpj() != null)
                .toList();


        return new ChurchMotherDTO(mother, congregations);
    }
}
