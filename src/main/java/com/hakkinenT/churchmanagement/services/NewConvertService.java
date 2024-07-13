package com.hakkinenT.churchmanagement.services;

import com.hakkinenT.churchmanagement.models.dto.NewConvertDTO;
import com.hakkinenT.churchmanagement.models.entities.NewConvert;
import com.hakkinenT.churchmanagement.repositories.NewConvertRepository;
import com.hakkinenT.churchmanagement.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewConvertService {

    @Autowired
    private NewConvertRepository newConvertRepository;

    @Transactional
    public NewConvertDTO insert(NewConvertDTO dto){
        NewConvert newConvert = new NewConvert();
        newConvert.setCpf(dto.getCpf());
        newConvert.setFirstName(dto.getFirstName());
        newConvert.setLastName(dto.getLastName());
        newConvert.setEmail(dto.getEmail());
        newConvert.setBirthDate(dto.getBirthDate());
        newConvert.setMaritalStatus(dto.getMaritalStatus());
        newConvert.setConversionDate(dto.getConversionDate());

        newConvert = newConvertRepository.save(newConvert);

        return new NewConvertDTO(newConvert);
    }

}
