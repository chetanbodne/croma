package Croma21.controller;

import Croma21.entity.Appointment;
import Croma21.entity.Doctor;
import Croma21.entity.Patient;
import Croma21.service.AppointmentService;
import Croma21.service.DoctorService;
import Croma21.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Appointment> addAppointment(
            @RequestBody Appointment appointment,
            @RequestParam long patientId,
            @RequestParam long doctorId) {

        Patient patient = patientService.setPatientId(patientId);
        Doctor doctor = doctorService.setDoctorId(doctorId);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        Appointment appointment1 = appointmentService.addAppointment(appointment);
        return new ResponseEntity<>(appointment1, HttpStatus.CREATED);
    }

    @GetMapping("/{appointmentId}")
    public ResponseEntity<Appointment> getAppointmentDetails(@PathVariable long appointmentId) {
        Appointment appointmentDetails = appointmentService.getAppointmentDetails(appointmentId);
        return new ResponseEntity<>(appointmentDetails, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Appointment> findId(@RequestParam long appointmentId) {
        Appointment id = appointmentService.findId(appointmentId);
        return new ResponseEntity<>(id, HttpStatus.OK);

    }

    @DeleteMapping
    public ResponseEntity<String> DeleteAppointment(@RequestParam long appointmentId) {
        appointmentService.DeleteAppointment(appointmentId);
        return new ResponseEntity<>("Appointment is Deleted", HttpStatus.OK);
    }


    @GetMapping("/list")
    public ResponseEntity<List<Appointment>> getAll() {
        List<Appointment> all = appointmentService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
