package com.hakkinenT.churchmanagement.services;

import com.hakkinenT.churchmanagement.models.dto.NewConvertDTO;
import com.hakkinenT.churchmanagement.models.entities.Church;
import com.hakkinenT.churchmanagement.models.entities.NewConvert;
import com.hakkinenT.churchmanagement.repositories.ChurchRepository;
import com.hakkinenT.churchmanagement.repositories.NewConvertRepository;
import com.hakkinenT.churchmanagement.repositories.PersonRepository;
import com.hakkinenT.churchmanagement.services.exceptions.DatabaseException;
import com.hakkinenT.churchmanagement.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewConvertService {

    @Autowired
    private NewConvertRepository newConvertRepository;

    @Autowired
    private ChurchRepository churchRepository;

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

        Church church = churchRepository.getReferenceById(dto.getChurchCnpj());
        newConvert.setChurch(church);

        newConvert = newConvertRepository.save(newConvert);

        return new NewConvertDTO(newConvert);
    }

    @Transactional(readOnly = true)
    public NewConvertDTO findById(String cpf){
        NewConvert newConvert = newConvertRepository
                .findById(cpf)
                .orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada"));

        return new NewConvertDTO(newConvert);
    }

    @Transactional(readOnly = true)
    public List<NewConvertDTO> findAll(){
        List<NewConvert> newConvert = newConvertRepository.findAll();

        return newConvert.stream().map(NewConvertDTO::new).toList();
    }

    @Transactional
    public NewConvertDTO update(String cpf, NewConvertDTO dto){
        NewConvert newConvert = newConvertRepository.getReferenceById(cpf);
        newConvert.setFirstName(dto.getFirstName());
        newConvert.setLastName(dto.getLastName());
        newConvert.setEmail(dto.getEmail());
        newConvert.setBirthDate(dto.getBirthDate());
        newConvert.setMaritalStatus(dto.getMaritalStatus());
        newConvert.setConversionDate(dto.getConversionDate());

        newConvert = newConvertRepository.save(newConvert);

        return new NewConvertDTO(newConvert);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(String cpf){
        if(!newConvertRepository.existsById(cpf)){
            throw new ResourceNotFoundException("Pessoa não encontrada");
        }

        try {
            newConvertRepository.deleteById(cpf);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Violação de integração");
        }
    }
}
