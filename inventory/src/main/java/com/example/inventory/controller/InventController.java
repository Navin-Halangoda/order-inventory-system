package com.example.inventory.controller;
import com.example.inventory.dto.InvetoryDto;
import com.example.inventory.model.Inventory;
import com.example.inventory.service.InvetoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1")
public class InventController {
    @Autowired
    private InvetoryService inventoryservice;

    @GetMapping("/getinvent")
    public List<InvetoryDto> getinventory(){
        return inventoryservice.getallinvetory();
    }

    @GetMapping("/getinventbyid/{invetid}")
    public InvetoryDto getinventbyid(@PathVariable Integer invetid){
        return inventoryservice.getInventorybyid(invetid);
    }

    @PostMapping("/saveinvent")
    public InvetoryDto saveinvent(@RequestBody InvetoryDto invetoryDto){
        return inventoryservice.saveinvetory(invetoryDto);
    }

    @PutMapping("/updateinvent")
    public InvetoryDto updateinvent(@RequestBody InvetoryDto invetoryDto){
        return  inventoryservice.updateinventory(invetoryDto);
    }

    @DeleteMapping("/deleteinvent/{inventid}")
    public  String delteinvent(@PathVariable Integer inventid){
        return  inventoryservice.deleteinventory(inventid);
    }
}
