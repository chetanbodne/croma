package Croma21.controller;

import Croma21.payload.PaDto;
import Croma21.payload.PatientDto;
import Croma21.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<?> addPatient(@Valid @RequestBody PatientDto patientDto, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.CREATED);
        }
        PatientDto patient1 = patientService.addPatient(patientDto);
        return new ResponseEntity<>(patient1, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<PatientDto> getId(@RequestParam long patientId) {
        PatientDto id = patientService.getId(patientId);
        return new ResponseEntity<>(id, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<PatientDto> updatePatient(@RequestParam long patientId, @RequestBody PatientDto patientDto) {
        PatientDto patient1 = patientService.updatePatient(patientId, patientDto);
        return new ResponseEntity<>(patient1, HttpStatus.OK);

    }

    @DeleteMapping
    public ResponseEntity<String> deletePatient(@RequestParam long patientId) {
        patientService.deletePatient(patientId);
        return new ResponseEntity<>("Patient is Deleted", HttpStatus.OK);
    }

    @GetMapping("/{list}")
    public ResponseEntity<PaDto<PatientDto>> getAllPatient(
            @RequestParam(name = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(name = "pageSize",defaultValue = "5",required = false)int pageSize,
            @RequestParam(name = "sortBy",defaultValue = "name",required = false)String sortBy,
            @RequestParam(name = "sortDir",defaultValue = "name",required = false)String sortDir

    ) {
        PaDto<PatientDto> allPatient = patientService.getAllPatient(pageNo,pageSize,sortBy,sortDir);
        return new ResponseEntity<>(allPatient, HttpStatus.OK);
    }
}
