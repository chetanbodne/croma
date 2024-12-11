package Croma21.controller;

import Croma21.entity.Billing;
import Croma21.entity.Patient;
import Croma21.service.BillingService;
import Croma21.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/billing")

public class BillingController {
    @Autowired
    private BillingService billingService;
    @Autowired
   private PatientService patientService;
    @PostMapping
    public ResponseEntity<Billing> Billing(@RequestBody Billing billing,@RequestParam long patientId) {
        Patient patient = patientService.setPatientId(patientId);
        billing.setPatient(patient);
        Billing billing1 = billingService.Billing(billing);

        return new ResponseEntity<>(billing1, HttpStatus.CREATED);

    }
}
