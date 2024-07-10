package com.hakkinenT.churchmanagement.controllers;

import com.hakkinenT.churchmanagement.models.dto.ChurchDTO;
import com.hakkinenT.churchmanagement.services.ChurchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/churches")
public class ChurchController {
    @Autowired
    private ChurchService churchService;

    @PostMapping
    public ResponseEntity<ChurchDTO> insert(@RequestBody ChurchDTO dto){
        dto = churchService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cnpj}").buildAndExpand(dto.getCnpj()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
