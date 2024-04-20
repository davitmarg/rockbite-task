package org.example.task.facade.material;

import org.example.task.converter.MaterialConverter;
import org.example.task.facade.material.model.MaterialRequestModel;
import org.example.task.facade.material.model.MaterialResponseModel;
import org.example.task.persistence.materials.Material;
import org.example.task.service.material.MaterialServiceInterface;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MaterialFacade {
    private final MaterialServiceInterface materialService;
    private final MaterialConverter materialConverter;

    public MaterialFacade(MaterialServiceInterface materialService, MaterialConverter materialConverter) {
        this.materialService = materialService;
        this.materialConverter = materialConverter;
    }

    public List<MaterialResponseModel> getAll() {
        List<Material> materials = materialService.getAllMaterials();
        return materialConverter.materialsToResponsLilst(materials);
    }

    public MaterialResponseModel get(Long id) {
        Material material = materialService.getMaterial(id);
        return materialConverter.materialToResponse(material);
    }

    public MaterialResponseModel add(MaterialRequestModel request) {
        Material material = materialConverter.requestToMaterial(request);
        Material addedMaterial = materialService.addMaterial(material);
        return materialConverter.materialToResponse(addedMaterial);
    }

    public MaterialResponseModel update(Long id, MaterialRequestModel request) {
        Material material = materialConverter.requestToMaterial(request);
        Material updatedMaterial = materialService.updateMaterial(id, material);
        return materialConverter.materialToResponse(updatedMaterial);
    }

    public void delete(Long id) {
        materialService.deleteMaterial(id);
    }


}
