package org.example.task.facade.warehouse_management;

import org.example.task.converter.PlayerConverter;
import org.example.task.converter.WarehouseConverter;
import org.example.task.facade.player.model.PlayerResponseModel;
import org.example.task.facade.warehouse.model.WarehouseResponseModel;
import org.example.task.persistence.player.Player;
import org.example.task.persistence.warehouse.Warehouse;
import org.example.task.service.warehouse_management.WarehouseManagementServiceInterface;
import org.springframework.stereotype.Component;

@Component
public class WarehouseManagementFacade {
    private final PlayerConverter playerConverter;
    private final WarehouseConverter warehouseConverter;
    private final WarehouseManagementServiceInterface warehouseManagementService;

    public WarehouseManagementFacade(PlayerConverter playerConverter,
                                     WarehouseConverter warehouseConverter,
                                     WarehouseManagementServiceInterface warehouseManagementService) {
        this.playerConverter = playerConverter;
        this.warehouseConverter = warehouseConverter;
        this.warehouseManagementService = warehouseManagementService;
    }

    public PlayerResponseModel addWarehouseToPlayer(Long playerId) {
        Player player = warehouseManagementService.addWarehosueToPlayer(playerId);
        return playerConverter.playerToResponse(player);
    }

    public WarehouseResponseModel addMaterial(Long warehouseId, Long materialId, Integer  quantity) {
        Warehouse warehouse = warehouseManagementService.addMaterial(warehouseId, materialId, quantity);
        return warehouseConverter.warehouseToResponse(warehouse);
    }

    public WarehouseResponseModel subtractMaterial(Long warehouseId, Long materialId, Integer quantity) {
        Warehouse warehouse = warehouseManagementService.subtractMaterial(warehouseId, materialId, quantity);
        return warehouseConverter.warehouseToResponse(warehouse);
    }

    public WarehouseResponseModel moveMaterial(Long sourceWarehouseId, Long destinationWarehouseId,
                                               Long materialId, Integer quantity){
        Warehouse warehouse = warehouseManagementService.moveMaterial(sourceWarehouseId, destinationWarehouseId, materialId, quantity);
        return warehouseConverter.warehouseToResponse(warehouse);
    }

    public WarehouseResponseModel moveAllMaterial(Long sourceWarehouseId, Long destinationWarehouseId,
                                               Long materialId){
        Warehouse warehouse = warehouseManagementService.moveAllMaterial(sourceWarehouseId, destinationWarehouseId, materialId);
        return warehouseConverter.warehouseToResponse(warehouse);
    }
}
