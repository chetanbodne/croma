package Croma21.controller;

import Croma21.entity.Inventory;
import Croma21.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<Inventory> AddInventory(@RequestBody Inventory inventory) {
        Inventory inventory1 = inventoryService.AddInventory(inventory);
        return new ResponseEntity<>(inventory1, HttpStatus.CREATED);


    }

}
