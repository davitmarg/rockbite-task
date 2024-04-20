package org.example.task.service.material.implementation;

import org.example.task.persistence.materials.Material;
import org.example.task.persistence.materials.MaterialRepository;
import org.example.task.service.material.MaterialServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService implements MaterialServiceInterface {

    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public Material getMaterial(Long id) {
        Optional<Material> material = materialRepository.findById(id);
        return material.orElse(null);
    }

    @Override
    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    @Override
    public Material addMaterial(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public Material updateMaterial(Long id, Material material) {
        Material materialById = materialRepository.findById(id).orElse(null);
        if (materialById != null) {
            materialById.setType(material.getType());
            materialById.setMaxCapacity(material.getMaxCapacity());
            materialById.setDescription(material.getDescription());
            materialById.setDisplayName(material.getDisplayName());
            materialById.setIcon(material.getIcon());
            return materialRepository.save(materialById);
        }
        return null;
    }

    @Override
    public void deleteMaterial(Long id) {
        materialRepository.deleteById(id);
    }
}
