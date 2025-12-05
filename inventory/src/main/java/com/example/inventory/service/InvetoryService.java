package com.example.inventory.service;

import com.example.inventory.dto.InvetoryDto;
import com.example.inventory.model.Inventory;
import com.example.inventory.repo.InventoryRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InvetoryService {
    @Autowired
    private InventoryRepo invetoryrepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<InvetoryDto> getallinvetory(){
        List<Inventory> inventoryList =invetoryrepo.findAll();
        return modelMapper.map(inventoryList ,new TypeToken<List<InvetoryDto>>(){}.getType());
    }

    public InvetoryDto saveinvetory(InvetoryDto invetoryDto){
        invetoryrepo.save(modelMapper.map(invetoryDto,Inventory.class));
        return invetoryDto;
    }

    public InvetoryDto updateinventory(InvetoryDto invetoryDto){
        invetoryrepo.save(modelMapper.map(invetoryDto,Inventory.class));
        return  invetoryDto;
    }

    public String deleteinventory(Integer InventoryId){
        invetoryrepo.deleteById(InventoryId);
        return "Inventory delted";
    }

    public InvetoryDto getInventorybyid(Integer InventoryId){
        Inventory inventory = invetoryrepo.getinventorybyid(InventoryId);
        return modelMapper.map(inventory,InvetoryDto.class);
    }
}
