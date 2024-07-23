package com.hakkinenT.churchmanagement.controllers;

import com.hakkinenT.churchmanagement.models.dto.NewConvertDTO;
import com.hakkinenT.churchmanagement.services.NewConvertService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/new-converts")
@Tag(name = "New Converts", description = "Controller for New Convert")
public class NewConvertController {
    @Autowired
    private NewConvertService newConvertService;

    @Operation(
            description = "Create a new convert",
            summary = "Create a new convert",
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201"),
                    @ApiResponse(description = "Unauthorized", responseCode = "401"),
                    @ApiResponse(description = "Forbidden", responseCode = "403")
            }
    )
    @PostMapping(produces="application/json")
    public ResponseEntity<NewConvertDTO> insert(@RequestBody NewConvertDTO dto){
        dto = newConvertService.insert(dto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{cpf}")
                .buildAndExpand(dto.getCpf()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @Operation(
            description = "Get a new convert",
            summary = "Get a new convert by cpf",
            responses = {
                    @ApiResponse(description = "OK", responseCode = "200"),
                    @ApiResponse(description = "Not Found", responseCode = "404")
            }
    )
    @GetMapping(value="/{cpf}", produces="application/json")
    public ResponseEntity<NewConvertDTO> findById(@PathVariable String cpf){
        NewConvertDTO newConvertDTO = newConvertService.findById(cpf);
        return ResponseEntity.ok(newConvertDTO);
    }

    @Operation(
            description = "Get a new convert list",
            summary = "Get all new converts",
            responses = {
                    @ApiResponse(description = "OK", responseCode = "200")
            }
    )
    @GetMapping(produces="application/json")
    public ResponseEntity<List<NewConvertDTO>> findAll(){
        List<NewConvertDTO> newConverts = newConvertService.findAll();
        return ResponseEntity.ok(newConverts);
    }

    @Operation(
            description = "Update a new convert",
            summary = "Update a new convert",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200"),
                    @ApiResponse(description = "Unauthorized", responseCode = "401"),
                    @ApiResponse(description = "Forbidden", responseCode = "403"),
                    @ApiResponse(description = "Not Found", responseCode = "404")
            }
    )
    @PutMapping(value="/{cpf}", produces="application/json")
    public ResponseEntity<NewConvertDTO> update(@PathVariable String cpf, @RequestBody NewConvertDTO dto){
        NewConvertDTO newConvertDTO = newConvertService.update(cpf, dto);
        return ResponseEntity.ok(newConvertDTO);
    }

    @Operation(
            description = "Delete a new convert",
            summary = "Delete a new convert",
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204"),
                    @ApiResponse(description = "Unauthorized", responseCode = "401"),
                    @ApiResponse(description = "Forbidden", responseCode = "403"),
                    @ApiResponse(description = "Not Found", responseCode = "404")
            }
    )
    @DeleteMapping(value="/{cpf}", produces="application/json")
    public ResponseEntity<Void> delete(@PathVariable String cpf){
        newConvertService.delete(cpf);
        return ResponseEntity.noContent().build();
    }
}
