package org.example.task.service.warehouse;

import org.example.task.persistence.warehouse.Warehouse;

import java.util.List;

public interface WarehouseServiceInterface {
    Warehouse getWarehouse(Long id);
    List<Warehouse> getAllWarehouses();
    Warehouse addWarehouse(Warehouse warehouse);
    void deleteWarehouse(Long Id);
}
