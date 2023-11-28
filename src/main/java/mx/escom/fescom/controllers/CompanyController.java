package mx.escom.fescom.controllers;

import com.example.fescom.jwt.issuer.dtos.UserDto;
import mx.escom.fescom.dtos.CompanyDto;
import mx.escom.fescom.dtos.GenericResponse;
import mx.escom.fescom.service.impl.CompanyServiceImpl;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

    private final CompanyServiceImpl companyService;

    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }


    @PostMapping("/invite")
    public ResponseEntity<GenericResponse> inviteCompany(@RequestBody CompanyDto companyDto,
                                                         @RequestParam("imageFile") MultipartFile imageFile) {
        return ResponseEntity.ok(companyService.inviteCompany(companyDto, imageFile));
    }

    @PostMapping("/register")
    public ResponseEntity<CompanyDto> registerCompany(@RequestBody UserDto userDto){

        return ResponseEntity.ok(companyService.register(userDto));
    }

    @PostMapping("/resend-token/{companyId}")
    public ResponseEntity<GenericResponse> resendToken(@PathVariable Long companyId){

        return  ResponseEntity.ok(companyService.resendInvitation(companyId));
    }

    @GetMapping("/{companyId}/candidates-applied/{jobPostId}")
    public ResponseEntity<Void> sendApplyCandidates( @PathVariable Long companyId,
                                                     @PathVariable Long jobPostId){

        companyService.sendApplyCandidates(companyId, jobPostId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/")
    public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyDto companyDto) {
        return ResponseEntity.ok(companyService.createCompany(companyDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<CompanyDto>> getAllCompanies( @DefaultValue("0") @RequestParam("page") int page,
                                                             @DefaultValue("50") @RequestParam("limit") int limit ){

        return ResponseEntity.ok(companyService.getAllCompanies(page, limit));
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyDto> getCompany( @PathVariable Long companyId){

        return ResponseEntity.ok(companyService.getCompanyById(companyId));
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<CompanyDto> updateMapping(@RequestBody CompanyDto companyDto,
                                                    @PathVariable Long companyId){
        if (companyId != null)
            companyDto.setId(companyId);
        return ResponseEntity.ok(companyService.createCompany(companyDto));
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> deleteCompany( @PathVariable Long companyId){

        companyService.deleteCompany(companyId);

        return ResponseEntity.noContent().build();
    }

}
