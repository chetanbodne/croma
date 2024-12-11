package Croma21.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "lab_test")
public class LabTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "testId", nullable = false)
    private Long testId;

    @Column(name = "test_type", nullable = false)
    private String testType;

    @Column(name = "result", nullable = false)
    private String result;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "patient_patient_id")
    private Patient patient;

}