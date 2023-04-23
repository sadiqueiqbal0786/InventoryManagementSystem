package com.inventorymanagementsystem.Service;

import com.inventorymanagementsystem.Entity.Inventory;
import java.util.*;

public interface InventoryService {
    List<Inventory> getAllItems();
    Inventory saveItem(Inventory inventory);
    Inventory getItemById(Long id);
    Inventory updateItem(Inventory inventory);
    void deleteItemById(Long id);
}
