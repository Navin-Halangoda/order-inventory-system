package com.example.product.Controller;

import com.example.product.dto.Productdto;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class productController {
    @Autowired
    private ProductService productservice;

    @GetMapping("/getproduct")
    public List<Productdto> getproduct(){
        return productservice.getallinvetory();
    }

    @GetMapping("/getproductbyid/{productId}")
    public Productdto getproductbyid(@PathVariable Integer productId){
        return productservice.getproductbyid(productId);
    }

    @PostMapping("/saveproduct")
    public Productdto saveproduct(@RequestBody Productdto productdto){
        return productservice.saveproduct(productdto);
    }

    @PutMapping("/updateproduct")
    public Productdto updateproduct(@RequestBody Productdto productdto){
        return productservice.updateproduct(productdto);
    }

    @DeleteMapping("/deleteproduct/{productid}")
    public String deleteproduct(@PathVariable Integer productid){
        return productservice.deleteproduct(productid);
    }

}
