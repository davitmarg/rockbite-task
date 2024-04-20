package org.example.task.controller;

import org.example.task.facade.material.model.MaterialResponseModel;
import org.example.task.facade.player.model.PlayerResponseModel;
import org.example.task.facade.warehouse.model.WarehouseResponseModel;
import org.example.task.facade.warehouse_management.WarehouseManagementFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseManagementController {

    private final WarehouseManagementFacade warehouseManagementFacade;

    public WarehouseManagementController(WarehouseManagementFacade warehouseManagementFacade) {
        this.warehouseManagementFacade = warehouseManagementFacade;
    }

    @PutMapping("/addWarehouseToPlayer/{id}")
    public ResponseEntity<PlayerResponseModel> addWarehouseToPlayer(@PathVariable Long id) {
        PlayerResponseModel player = warehouseManagementFacade.addWarehouseToPlayer(id);
        return ResponseEntity.ok(player);
    }

    @PutMapping("/addMaterial/{warehouseId}/{materialId}/{quantity}")
    public ResponseEntity<WarehouseResponseModel> addMaterial(@PathVariable Long warehouseId,
                                                             @PathVariable Long materialId,
                                                              @PathVariable Integer quantity) {
        WarehouseResponseModel warehouse = warehouseManagementFacade.addMaterial(warehouseId, materialId, quantity);
        return ResponseEntity.ok(warehouse);
    }

    @PutMapping("/subtractMaterial/{warehouseId}/{materialId}/{quantity}")
    public ResponseEntity<WarehouseResponseModel> subtractMaterial(@PathVariable Long warehouseId,
                                                              @PathVariable Long materialId,
                                                              @PathVariable Integer quantity) {
        WarehouseResponseModel warehouse = warehouseManagementFacade.subtractMaterial(warehouseId, materialId, quantity);
        return ResponseEntity.ok(warehouse);
    }

    @PutMapping("/moveMaterial/{sourceWarehouseId}/{destinationWarehouseId}/{materialId}/{quantity}")
    public ResponseEntity<WarehouseResponseModel> moveMaterial(@PathVariable Long sourceWarehouseId,
                                                               @PathVariable Long destinationWarehouseId,
                                                               @PathVariable Long materialId,
                                                               @PathVariable Integer quantity){
        WarehouseResponseModel warehouse = warehouseManagementFacade.moveMaterial(sourceWarehouseId, destinationWarehouseId, materialId, quantity);
        return ResponseEntity.ok(warehouse);
    }

    @PutMapping("/moveAllMaterial/{sourceWarehouseId}/{destinationWarehouseId}/{materialId}")
    public ResponseEntity<WarehouseResponseModel> moveAllMaterial(@PathVariable Long sourceWarehouseId,
                                                               @PathVariable Long destinationWarehouseId,
                                                               @PathVariable Long materialId){
        WarehouseResponseModel warehouse = warehouseManagementFacade.moveAllMaterial(sourceWarehouseId, destinationWarehouseId, materialId);
        return ResponseEntity.ok(warehouse);
    }

}
