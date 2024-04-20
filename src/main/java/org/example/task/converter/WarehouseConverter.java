package org.example.task.converter;

import org.example.task.facade.warehouse.model.WarehouseResponseModel;
import org.example.task.persistence.warehouse.Warehouse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarehouseConverter {

    private final MaterialConverter materialConverter;

    public WarehouseConverter(MaterialConverter materialConverter) {
        this.materialConverter = materialConverter;
    }

    public WarehouseResponseModel warehouseToResponse(Warehouse warehouse) {
        WarehouseResponseModel response = new WarehouseResponseModel();
        response.setId(warehouse.getId());
        response.setMaterialContainer(materialConverter.materialMapToResponseMap(warehouse.getMaterialContainer()));
        return response;
    }

    public List<WarehouseResponseModel> warehousesToResponseList(List<Warehouse> warehouses) {
        List<WarehouseResponseModel> responseList = new ArrayList<>();
        for (Warehouse warehouse : warehouses) {
            responseList.add(warehouseToResponse(warehouse));
        }
        return responseList;
    }
}
