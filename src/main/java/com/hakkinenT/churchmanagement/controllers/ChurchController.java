package com.hakkinenT.churchmanagement.controllers;

import com.hakkinenT.churchmanagement.models.dto.ChurchDTO;
import com.hakkinenT.churchmanagement.models.dto.ChurchMinDTO;
import com.hakkinenT.churchmanagement.models.dto.ChurchMotherDTO;
import com.hakkinenT.churchmanagement.services.ChurchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/churches")
public class ChurchController {
    @Autowired
    private ChurchService churchService;

    @PreAuthorize("hasRole('ROLE_SECRETARY')")
    @PostMapping
    public ResponseEntity<ChurchDTO> insert(@RequestBody ChurchDTO dto){
        dto = churchService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cnpj}").buildAndExpand(dto.getCnpj()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/{cnpj}/congregations")
    public ResponseEntity<ChurchMotherDTO> searchChurchMotherAndCongregations(@PathVariable String cnpj){
        ChurchMotherDTO mother = churchService.searchChurchMotherAndCongregations(cnpj);
        return ResponseEntity.ok(mother);
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<ChurchDTO> findByCnpj(@PathVariable String cnpj){
        ChurchDTO church = churchService.findByCnpj(cnpj);
        return ResponseEntity.ok(church);
    }

    @PreAuthorize("hasRole('ROLE_SECRETARY')")
    @PutMapping("/{cnpj}")
    public ResponseEntity<ChurchMinDTO> update(@PathVariable String cnpj, @RequestBody ChurchMinDTO dto){
        ChurchMinDTO church = churchService.update(cnpj, dto);
        return ResponseEntity.ok(church);
    }

    @PreAuthorize("hasRole('ROLE_SECRETARY')")
    @DeleteMapping("/{cnpj}")
    public ResponseEntity<Void> delete(@PathVariable String cnpj){
        churchService.delete(cnpj);
        return ResponseEntity.noContent().build();
    }
}
