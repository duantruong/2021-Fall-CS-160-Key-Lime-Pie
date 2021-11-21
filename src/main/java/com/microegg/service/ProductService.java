package com.microegg.service;

import com.microegg.dao.ProductDao;
import com.microegg.dao.mapper.ComputerCasesMapper;
import com.microegg.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    public List<Product> getAllProduct(){
        List<String> list = productDao.getListOfCategory();
        List<Product> products = new ArrayList<>();
        for(String cat : list){
            products.addAll(productDao.searchProductByCategory(cat));
        }
        return products;
    }

    public List<Product> searchProductByNameLike(String productName){
        List<Product> productList = getAllProduct();
      return   productList.stream().filter(p ->
                p.getProductName().toUpperCase().contains(productName.toUpperCase()))
                .collect(Collectors.toList());
    }

    public List<Product> searchProductByType(String category){
        return productDao.searchProductByCategory(category);
    }

    public Colling getCollingProductDetail(Integer productId ){
        return productDao.getCoolingProduct(productId);
    }

    public GraphicCard getGraphicCard(Integer productId){
        return productDao.getGraphicCardProduct(productId);
    }

    public MotherBoard getMotherBoard(Integer id){
        return productDao.getMotherBoardProduct(id);
    }

    public PowerSupply getPowerSupply(Integer id){
        return productDao.getPowerSupplyProduct(id);
    }

    public Ram getRam(Integer id){
        return productDao.getRamProduct(id);
    }

    public Storage getStorage(Integer id){
        return productDao.getStorageProduct(id);
    }

    public ComputerCases getComputerCasesProduct(Integer productId){
       return productDao.getComputerCasesProduct(productId);
    }
}
