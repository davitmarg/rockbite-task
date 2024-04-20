package org.example.task.converter;

import org.example.task.facade.material.model.MaterialRequestModel;
import org.example.task.facade.material.model.MaterialResponseModel;
import org.example.task.persistence.materials.Material;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MaterialConverter {
    public Material requestToMaterial(MaterialRequestModel request) {
        Material material = new Material();
        material.setType(request.getType());
        material.setMaxCapacity(request.getMaxCapacity());
        material.setDescription(request.getDescription());
        material.setDisplayName(request.getDisplayName());
        material.setIcon(request.getIcon());
        return material;
    }

    public List<MaterialResponseModel> materialsToResponsLilst(List<Material> materials) {
        List<MaterialResponseModel> responseList = new ArrayList<>();
        for (Material material : materials) {
            responseList.add(materialToResponse(material));
        }
        return responseList;
    }

    public MaterialResponseModel materialToResponse(Material material){
        MaterialResponseModel response = new MaterialResponseModel();
        response.setId(material.getId());
        response.setType(material.getType());
        response.setMaxCapacity(material.getMaxCapacity());
        response.setDescription(material.getDescription());
        response.setDisplayName(material.getDisplayName());
        response.setIcon(material.getIcon());
        return response;
    }

    public Map<MaterialResponseModel, Integer> materialMapToResponseMap(Map<Material, Integer> materialMap){
        Map<MaterialResponseModel, Integer> materialResponseMap = new HashMap<>();
        for (Material material : materialMap.keySet()) {
            materialResponseMap.put(materialToResponse(material), materialMap.get(material));
        }
        return materialResponseMap;
    }
}
