package Croma21.service;

import Croma21.entity.Appointment;
import Croma21.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment addAppointment(Appointment appointment) {
        Appointment save = appointmentRepository.save(appointment);
        return save;
    }


    public Appointment getAppointmentDetails(long appointmentId) {
        Appointment appointmentWithDoctorAndPatient = appointmentRepository.findAppointmentWithDoctorAndPatient(appointmentId);
        return appointmentWithDoctorAndPatient;
    }

    public Appointment findId(long appointmentId) {
        Optional<Appointment> byId = appointmentRepository.findById(appointmentId);
        Appointment appointment = byId.get();
        return appointment;
    }

    public void DeleteAppointment(long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }


    public List<Appointment> getAll() {
        List<Appointment> all = appointmentRepository.findAll();
        return all;
    }
}
