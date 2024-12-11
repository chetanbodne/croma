package Croma21.service;

import Croma21.entity.Inventory;
import Croma21.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory AddInventory(Inventory inventory) {
        Inventory save = inventoryRepository.save(inventory);
        return save;
    }
}
