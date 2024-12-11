package Croma21.controller;

import Croma21.entity.Doctor;
import Croma21.payload.DoctorDto;
import Croma21.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<DoctorDto> addDoctor(@RequestBody DoctorDto doctorDto) {
        DoctorDto doctor1 = doctorService.addDoctor(doctorDto);
        return new ResponseEntity<>(doctor1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<DoctorDto> findById(@RequestParam long doctorId) {
        DoctorDto byId = doctorService.findById(doctorId);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DoctorDto> updateDoctor(@RequestParam long doctorId, @RequestBody DoctorDto doctorDto) {
        DoctorDto doctor1 = doctorService.updateDoctor(doctorId, doctorDto);
        return new ResponseEntity<>(doctor1, HttpStatus.OK);

    }

    @DeleteMapping
    public ResponseEntity<String> deleteDoctor(@RequestParam long doctorId) {
        doctorService.deleteDoctor(doctorId);
        return new ResponseEntity<>("Doctor is Deleted ", HttpStatus.OK);
    }

    @GetMapping("/{list}")
    public ResponseEntity<List<Doctor>> getAllDoctor() {
        List<Doctor> allDoctor = doctorService.getAllDoctor();
        return new ResponseEntity<>(allDoctor, HttpStatus.OK);
    }


}
