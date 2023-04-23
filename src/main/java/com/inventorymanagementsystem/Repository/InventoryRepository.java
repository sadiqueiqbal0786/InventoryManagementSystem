package com.inventorymanagementsystem.Repository;

import com.inventorymanagementsystem.Entity.Inventory;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
