package Croma21.service;

import Croma21.entity.LabTest;
import Croma21.repository.LabTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabTestService {
    @Autowired
    public LabTestRepository labTestRepository;

    public LabTest labTest(LabTest labTest) {
        LabTest save = labTestRepository.save(labTest);
        return save;
    }
}
