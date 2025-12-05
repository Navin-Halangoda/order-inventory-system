package com.example.product.service;

import com.example.product.dto.Productdto;
import com.example.product.model.Product;
import com.example.product.repo.Productrepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private Productrepo productrepo;

    @Autowired
    private ModelMapper modelmapper;

    public List<Productdto> getallinvetory(){
        List<Product> inventoryList =productrepo.findAll();
        return modelmapper.map(inventoryList ,new TypeToken<List<Productdto>>(){}.getType());
    }
    public Productdto saveproduct(Productdto productdto){
        productrepo.save(modelmapper.map(productdto,Product.class));
        return productdto;
    }
    public Productdto updateproduct(Productdto productdto){
        productrepo.save(modelmapper.map(productdto,Product.class));
        return productdto;
    }

    public String deleteproduct(Integer productId){
        productrepo.deleteById(productId);
        return  "Product deleted";
    }

    public Productdto getproductbyid(Integer productId){
        Product product= productrepo.getproductbyid(productId);
        return modelmapper.map(product,Productdto.class);
    }
}