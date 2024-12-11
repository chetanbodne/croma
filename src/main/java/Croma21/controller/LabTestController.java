package Croma21.controller;

import Croma21.entity.LabTest;
import Croma21.entity.Patient;
import Croma21.service.BillingService;
import Croma21.service.LabTestService;
import Croma21.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/labTest")
public class LabTestController {
    @Autowired
    private LabTestService labTestService;
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<LabTest> labTest(@RequestBody LabTest labTest, @RequestParam long patientId) {
        Patient patient = patientService.setPatientId(patientId);

       // labTest.setPatient(patient);
        LabTest labTest1 = labTestService.labTest(labTest);
        return new ResponseEntity<>(labTest1, HttpStatus.CREATED);


    }

}
