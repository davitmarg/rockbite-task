package org.example.task.controller;

import org.example.task.facade.warehouse.WarehouseFacade;
import org.example.task.facade.warehouse.model.WarehouseResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WarehouseController {

    private final WarehouseFacade warehouseFacade;

    @Autowired
    public WarehouseController(WarehouseFacade warehouseFacade) {
        this.warehouseFacade = warehouseFacade;
    }

    @GetMapping("/warehouse/{id}")
    public ResponseEntity<WarehouseResponseModel> getWarehouse(@PathVariable Long id) {
        return ResponseEntity.ok(warehouseFacade.getWarehouse(id));
    }

    @GetMapping("/warehouses")
    public ResponseEntity<List<WarehouseResponseModel>> getWarehouses() {
        return ResponseEntity.ok(warehouseFacade.getWarehouses());
    }

    @PostMapping("/warehouse")
    public ResponseEntity<WarehouseResponseModel> addWarehouse() {
        return ResponseEntity.ok(warehouseFacade.addWarehouse());
    }

    @DeleteMapping("/warehouse/{id}")
    public void deleteWarehouse(@PathVariable Long id) {
        warehouseFacade.deleteWarehouse(id);
    }

}
