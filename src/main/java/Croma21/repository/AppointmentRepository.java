package Croma21.repository;

import Croma21.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
//    @Query("SELECT a FROM Appointment a JOIN  a.patient p JOIN  a.doctor d WHERE p.name = :name")
//    List<Appointment> findAppointmentsByPatientName(@Param("name") String name);
//
//    @Query("SELECT a FROM Appointment a JOIN a,patient p JOIN a.doctor d WHERE a.appointmentId=:appointmentId")
//    Appointment findAppointmentWithDoctorAndPatient(@Param("appointmentId") long appointmentId);

    @Query("SELECT a FROM Appointment a " +
            "JOIN a.patient p " +
            "JOIN a.doctor d " +
            "WHERE a.appointmentId = :appointmentId")
    Appointment findAppointmentWithDoctorAndPatient(@Param("appointmentId") long appointmentId);
}

