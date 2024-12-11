package Croma21.service;

import Croma21.entity.Patient;
import Croma21.exception.ResourceNotFound;
import Croma21.payload.PaDto;
import Croma21.payload.PatientDto;
import Croma21.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public PatientDto addPatient(PatientDto patientDto) {
        Patient patient = mapToEntity(patientDto);

        Patient saved = patientRepository.save(patient);
        PatientDto dto = mapToDto(saved);
        return dto;


    }

    public PatientDto getId(long patientId) {
        Patient patient1 = patientRepository.findById(patientId).orElseThrow(() -> new ResourceNotFound("Patient Not Found Id=" + patientId));

        PatientDto dto = mapToDto(patient1);
        return dto;
    }

    public PatientDto updatePatient(long patientId, PatientDto patientDto) {
        Optional<Patient> byId = patientRepository.findById(patientId);
        Patient pat = byId.get();
        pat.setName(patientDto.getName());
        pat.setAge(patientDto.getAge());
        pat.setGender(patientDto.getGender());
        pat.setAddress(patientDto.getAddress());
        pat.setEmail(patientDto.getEmail());
        pat.setPhone(patientDto.getPhone());
        PatientDto dto = mapToDto(pat);
        return dto;


    }

    public void deletePatient(long patientId) {
        patientRepository.deleteById(patientId);
    }

    public PaDto<PatientDto> getAllPatient(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(Sort.Direction.ASC, sortBy) : Sort.by(Sort.Direction.DESC, sortBy);
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);// Sort.by(sortBy)
        Page<Patient> all = patientRepository.findAll(pageRequest);
        List<Patient> content = all.getContent();
        List<PatientDto> collect = content.stream().map(r -> mapToDto(r)).collect(Collectors.toList());
        PaDto<PatientDto> dto = new PaDto<>();
        dto.setDto(collect);
        dto.setPageSize(all.getSize());
        dto.setPageNo(all.getNumber());
        dto.setTotalPage(all.getTotalPages());
        return dto;
    }

    Patient mapToEntity(PatientDto dto) {
        Patient entity = new Patient();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setGender(dto.getGender());
        entity.setAddress(dto.getAddress());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        return entity;

    }

    PatientDto mapToDto(Patient patient) {
        PatientDto dto = new PatientDto();
        dto.setPatientId(patient.getPatientId());
        dto.setName(patient.getName());
        dto.setGender(patient.getGender());
        dto.setAge(patient.getAge());
        dto.setAddress(patient.getAddress());
        dto.setPhone(patient.getPhone());
        dto.setEmail(patient.getEmail());
        return dto;


    }


    public Patient setPatientId(long patientId) {
        Optional<Patient> byId = patientRepository.findById(patientId);
        Patient patient = byId.get();
        return patient;
    }
}
