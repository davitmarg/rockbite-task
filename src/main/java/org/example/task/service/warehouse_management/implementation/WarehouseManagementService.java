package org.example.task.service.warehouse_management.implementation;

import org.example.task.persistence.materials.Material;
import org.example.task.persistence.materials.MaterialRepository;
import org.example.task.persistence.player.Player;
import org.example.task.persistence.player.PlayerRepository;
import org.example.task.persistence.warehouse.Warehouse;
import org.example.task.persistence.warehouse.WarehouseRepository;
import org.example.task.service.warehouse_management.WarehouseManagementServiceInterface;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WarehouseManagementService implements WarehouseManagementServiceInterface {

    private final WarehouseRepository warehouseRepository;
    private final MaterialRepository materialRepository;
    private final PlayerRepository playerRepository;

    public WarehouseManagementService(WarehouseRepository warehouseRepository, MaterialRepository materialRepository, PlayerRepository playerRepository) {
        this.warehouseRepository = warehouseRepository;
        this.materialRepository = materialRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public Player addWarehosueToPlayer(Long playerId) {
        Player player = playerRepository.findById(playerId).orElse(null);
        if (player != null) {
            Warehouse warehouse = warehouseRepository.save(new Warehouse());
            player.getWarehouses().add(warehouse);
            return playerRepository.save(player);
        }
        return null;
    }

    @Override
    public Warehouse addMaterial(Long warehouseId, Long materialId, Integer quantity){
        Warehouse warehouse = warehouseRepository.findById(warehouseId).orElse(null);
        Material material = materialRepository.findById(materialId).orElse(null);
        if (warehouse != null && material != null) {
            Map<Material, Integer> materialContainer = warehouse.getMaterialContainer();
            int usedCapacity = materialContainer.getOrDefault(material, 0);
            int maxCapacity = material.getMaxCapacity();

            if (usedCapacity + quantity > maxCapacity)
                return null;

            materialContainer.put(material, usedCapacity + quantity);
            return warehouseRepository.save(warehouse);
        }
        return null;
    }

    @Override
    public Warehouse subtractMaterial(Long warehouseId, Long materialId, Integer quantity){
        Warehouse warehouse = warehouseRepository.findById(warehouseId).orElse(null);
        Material material = materialRepository.findById(materialId).orElse(null);
        if (warehouse != null && material != null) {
            Map<Material, Integer> materialContainer = warehouse.getMaterialContainer();
            int usedCapacity = materialContainer.getOrDefault(material, 0);

            if (usedCapacity < quantity)
                return null;

            materialContainer.put(material, usedCapacity - quantity);
            return warehouseRepository.save(warehouse);
        }
        else
            return null;
    }

    @Override
    public Warehouse moveMaterial(Long sourceWarehouseId, Long destinationWarehouseId,
                                  Long materialId, Integer quantity) {

        Warehouse sourceWarehouse = warehouseRepository.findById(sourceWarehouseId).orElse(null);
        Warehouse destinationWarehouse = warehouseRepository.findById(destinationWarehouseId).orElse(null);
        Material material = materialRepository.findById(materialId).orElse(null);

        if(sourceWarehouse != null && destinationWarehouse != null && material != null) {
            int sourceUsedCapacity = sourceWarehouse.getMaterialContainer().getOrDefault(material, 0);
            int destinationAvailableCapacity = material.getMaxCapacity() - destinationWarehouse.getMaterialContainer().getOrDefault(material, 0);

            if(quantity > sourceUsedCapacity || destinationAvailableCapacity < quantity)
                return null;

            subtractMaterial(sourceWarehouseId, materialId, quantity);
            return addMaterial(destinationWarehouseId, materialId, quantity);
        }
        else
            return null;

    }

    @Override
    public Warehouse moveAllMaterial(Long sourceWarehouseId, Long destinationWarehouseId, Long materialId) {
        Warehouse sourceWarehouse = warehouseRepository.findById(sourceWarehouseId).orElse(null);
        Warehouse destinationWarehouse = warehouseRepository.findById(destinationWarehouseId).orElse(null);
        Material material = materialRepository.findById(materialId).orElse(null);

        if(sourceWarehouse != null && destinationWarehouse != null && material != null) {
            int quantity = sourceWarehouse.getMaterialContainer().getOrDefault(material, 0);
            int destinationAvailableCapacity = material.getMaxCapacity() - destinationWarehouse.getMaterialContainer().getOrDefault(material, 0);

            if(quantity > destinationAvailableCapacity)
                return null;

            subtractMaterial(sourceWarehouseId, materialId, quantity);
            return addMaterial(destinationWarehouseId, materialId, quantity);
        }
        return null;
    }
}
