package mx.escom.fescom.controllers;

import mx.escom.fescom.dtos.CompanyDto;
import mx.escom.fescom.service.impl.CompanyServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

    private final CompanyServiceImpl companyService;

    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/")
    public ResponseEntity<CompanyDto> createCompany(CompanyDto companyDto){

        return  ResponseEntity.ok(new CompanyDto());
    }

}
