package org.example.task.service.warehouse.implementation;

import org.example.task.persistence.warehouse.Warehouse;
import org.example.task.persistence.warehouse.WarehouseRepository;
import org.example.task.service.warehouse.WarehouseServiceInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WarehouseService implements WarehouseServiceInterface {

    private final WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }


    @Override
    @Transactional
    public Warehouse getWarehouse(Long id) {
        return warehouseRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    @Override
    @Transactional
    public Warehouse addWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    @Override
    @Transactional
    public void deleteWarehouse(Long Id) {
        warehouseRepository.deleteById(Id);
    }
}
