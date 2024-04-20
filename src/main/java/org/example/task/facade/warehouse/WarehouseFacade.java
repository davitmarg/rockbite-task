package org.example.task.facade.warehouse;

import org.springframework.stereotype.Component;
import org.example.task.converter.WarehouseConverter;
import org.example.task.facade.warehouse.model.WarehouseResponseModel;
import org.example.task.persistence.warehouse.Warehouse;
import org.example.task.service.warehouse.implementation.WarehouseService;

import java.util.List;

@Component
public class WarehouseFacade {

    private final WarehouseService warehouseService;
    private final WarehouseConverter warehouseConverter;

    public WarehouseFacade(WarehouseService warehouseService, WarehouseConverter warehouseConverter) {
        this.warehouseService = warehouseService;
        this.warehouseConverter = warehouseConverter;
    }

    public WarehouseResponseModel getWarehouse(Long id){
        Warehouse warehouse = warehouseService.getWarehouse(id);
        return warehouseConverter.warehouseToResponse(warehouse);
    }

    public List<WarehouseResponseModel> getWarehouses(){
        List<Warehouse> warehouses = warehouseService.getAllWarehouses();
        return warehouseConverter.warehousesToResponseList(warehouses);
    }

    public WarehouseResponseModel addWarehouse(){
        Warehouse addedWarehouse = warehouseService.addWarehouse(new Warehouse());
        return warehouseConverter.warehouseToResponse(addedWarehouse);
    }

    public void deleteWarehouse(Long id){
        warehouseService.deleteWarehouse(id);
    }
}
