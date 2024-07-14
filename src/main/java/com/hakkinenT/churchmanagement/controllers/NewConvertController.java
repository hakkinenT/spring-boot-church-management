package com.hakkinenT.churchmanagement.controllers;

import com.hakkinenT.churchmanagement.models.dto.NewConvertDTO;
import com.hakkinenT.churchmanagement.services.NewConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/new-converts")
public class NewConvertController {
    @Autowired
    private NewConvertService newConvertService;

    @PostMapping
    public ResponseEntity<NewConvertDTO> insert(@RequestBody NewConvertDTO dto){
        dto = newConvertService.insert(dto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{cpf}")
                .buildAndExpand(dto.getCpf()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<NewConvertDTO> findById(@PathVariable String cpf){
        NewConvertDTO newConvertDTO = newConvertService.findById(cpf);
        return ResponseEntity.ok(newConvertDTO);
    }

    @GetMapping
    public ResponseEntity<List<NewConvertDTO>> findAll(){
        List<NewConvertDTO> newConverts = newConvertService.findAll();
        return ResponseEntity.ok(newConverts);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<NewConvertDTO> update(@PathVariable String cpf, @RequestBody NewConvertDTO dto){
        NewConvertDTO newConvertDTO = newConvertService.update(cpf, dto);
        return ResponseEntity.ok(newConvertDTO);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> delete(@PathVariable String cpf){
        newConvertService.delete(cpf);
        return ResponseEntity.noContent().build();
    }
}
