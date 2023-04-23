package com.inventorymanagementsystem.Service.Implementation;
import com.inventorymanagementsystem.Entity.Inventory;
import com.inventorymanagementsystem.Repository.InventoryRepository;
import com.inventorymanagementsystem.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Override
    public List<Inventory> getAllItems() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory saveItem(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory getItemById(Long id) {
        return inventoryRepository.findById(id).get();
    }

    @Override
    public Inventory updateItem(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public void deleteItemById(Long id) {
        inventoryRepository.deleteById(id);

    }
}
