package Croma21.service;

import Croma21.entity.Doctor;
import Croma21.payload.DoctorDto;
import Croma21.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public DoctorDto addDoctor(DoctorDto doctorDto) {
        Doctor doctor = mapToEntity(doctorDto);
        Doctor save = doctorRepository.save(doctor);
        DoctorDto dto = mapToDto(save);
        return dto;
    }

    public DoctorDto findById(long doctorId) {
        Optional<Doctor> byId = doctorRepository.findById(doctorId);
        Doctor doctor = byId.get();
        DoctorDto dto = mapToDto(doctor);
        return dto;
    }

    public DoctorDto updateDoctor(long doctorId, DoctorDto doctorDto) {
        Optional<Doctor> byId = doctorRepository.findById(doctorId);
        Doctor doctor1 = byId.get();
        doctor1.setName(doctorDto.getName());
        doctor1.setPhone(doctorDto.getPhone());
        doctor1.setSpecialization(doctorDto.getSpecialization());
        DoctorDto dto = mapToDto(doctor1);
        return dto;
    }

    public void deleteDoctor(long doctorId) {
        doctorRepository.deleteById(doctorId);
    }

    public List<Doctor> getAllDoctor() {
        List<Doctor> all = doctorRepository.findAll();
        return all;
    }
    Doctor mapToEntity(DoctorDto dto){
        Doctor entity=new Doctor();
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setSpecialization(dto.getSpecialization());
        return entity;
    }
    DoctorDto mapToDto(Doctor doctor){
        DoctorDto dto=new DoctorDto();
        dto.setDoctorId(doctor.getDoctorId());
        dto.setName(doctor.getName());
        dto.setPhone(doctor.getPhone());
        dto.setSpecialization(doctor.getSpecialization());
        return dto;


    }


    public Doctor setDoctorId(long doctorId) {
        Optional<Doctor> byId = doctorRepository.findById(doctorId);
        Doctor doctor = byId.get();
        return doctor;
    }
}
