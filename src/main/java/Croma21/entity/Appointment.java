package Croma21.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointmentId", nullable = false)
    private Long appointmentId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "time", nullable = false, unique = true)
    private LocalTime time;

    @Column(name = "status", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "patient_patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_doctor_id")
    private Doctor doctor;

}