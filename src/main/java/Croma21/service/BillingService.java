package Croma21.service;

import Croma21.entity.Billing;
import Croma21.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingService {
    @Autowired
    private BillingRepository billingRepository;

    public Billing Billing(Billing billing) {
        Billing save = billingRepository.save(billing);
        return save;
    }
}
