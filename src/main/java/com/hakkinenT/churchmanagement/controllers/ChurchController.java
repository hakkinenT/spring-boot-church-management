package com.hakkinenT.churchmanagement.controllers;

import com.hakkinenT.churchmanagement.models.dto.ChurchDTO;
import com.hakkinenT.churchmanagement.models.dto.ChurchMinDTO;
import com.hakkinenT.churchmanagement.models.dto.ChurchMotherDTO;
import com.hakkinenT.churchmanagement.services.ChurchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/churches")
@Tag(name = "Churches", description = "Controller for Church")
public class ChurchController {
    @Autowired
    private ChurchService churchService;


    @Operation(
            description = "Create a church",
            summary = "Create a church",
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201"),
                    @ApiResponse(description = "Unauthorized", responseCode = "401"),
                    @ApiResponse(description = "Forbidden", responseCode = "403")
            }
    )
    @SecurityRequirement(name = "bearerAuth")
    @PreAuthorize("hasRole('ROLE_SECRETARY')")
    @PostMapping(produces="application/json")
    public ResponseEntity<ChurchDTO> insert(@RequestBody ChurchDTO dto){
        dto = churchService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cnpj}").buildAndExpand(dto.getCnpj()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @Operation(
            description = "Get a church with congregations",
            summary = "Get church with all your congregations",
            responses = {
                    @ApiResponse(description = "OK", responseCode = "200")
            }
    )
    @GetMapping(value="/{cnpj}/congregations", produces="application/json")
    public ResponseEntity<ChurchMotherDTO> searchChurchMotherAndCongregations(@PathVariable String cnpj){
        ChurchMotherDTO mother = churchService.searchChurchMotherAndCongregations(cnpj);
        return ResponseEntity.ok(mother);
    }

    @Operation(
            description = "Get a church",
            summary = "Get a church by cnpj",
            responses = {
                    @ApiResponse(description = "OK", responseCode = "200"),
                    @ApiResponse(description = "Not Found", responseCode = "404")
            }
    )
    @GetMapping(value ="/{cnpj}", produces="application/json")
    public ResponseEntity<ChurchDTO> findByCnpj(@PathVariable String cnpj){
        ChurchDTO church = churchService.findByCnpj(cnpj);
        return ResponseEntity.ok(church);
    }

    @Operation(
            description = "Update a church",
            summary = "Update a church",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200"),
                    @ApiResponse(description = "Unauthorized", responseCode = "401"),
                    @ApiResponse(description = "Forbidden", responseCode = "403"),
                    @ApiResponse(description = "Not Found", responseCode = "404")
            }
    )
    @SecurityRequirement(name = "bearerAuth")
    @PreAuthorize("hasRole('ROLE_SECRETARY')")
    @PutMapping(value="/{cnpj}", produces="application/json")
    public ResponseEntity<ChurchMinDTO> update(@PathVariable String cnpj, @RequestBody ChurchMinDTO dto){
        ChurchMinDTO church = churchService.update(cnpj, dto);
        return ResponseEntity.ok(church);
    }

    @Operation(
            description = "Delete a church",
            summary = "Delete a church",
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204"),
                    @ApiResponse(description = "Unauthorized", responseCode = "401"),
                    @ApiResponse(description = "Forbidden", responseCode = "403"),
                    @ApiResponse(description = "Not Found", responseCode = "404")
            }
    )
    @SecurityRequirement(name = "bearerAuth")
    @PreAuthorize("hasRole('ROLE_SECRETARY')")
    @DeleteMapping(value="/{cnpj}", produces="application/json")
    public ResponseEntity<Void> delete(@PathVariable String cnpj){
        churchService.delete(cnpj);
        return ResponseEntity.noContent().build();
    }
}
