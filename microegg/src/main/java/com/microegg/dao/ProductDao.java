package com.microegg.dao;

import com.microegg.dao.mapper.*;
import com.microegg.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProductDao {


    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> searchProductByCategory(String category){
        String query = "Select * from '" + category + "'";
        return jdbcTemplate.query(query, new ProductMapper());
    }

    public Product searchProductByCategoryAndId(String category, Integer id){
        String query = "Select * from '" + category + "'  where productId = " + id;
        return jdbcTemplate.queryForObject(query, new ProductMapper());
    }

    public Product searchProductById(Integer id){
        String query = "Select productType from product where productId = " + id;
        String category = jdbcTemplate.queryForObject(query, String.class);
        Product product =  searchProductByCategoryAndId(category,id);
        product.setCategory(category);
        return product;
    }

    public Colling getCoolingProduct(Integer productId){
        String query = "Select * from colling where productId = "+ productId;
        return jdbcTemplate.queryForObject(query, new CoolingMapper());
    }

    public Storage getStorageProduct(Integer productId){
        String query = "Select * from storages where productId = "+ productId;
        return jdbcTemplate.queryForObject(query, new StorageMapper());
    }
    public ComputerCases getComputerCasesProduct(Integer productId){
        String query = "Select * from computerCases where productId = "+ productId;
        return jdbcTemplate.queryForObject(query, new ComputerCasesMapper());
    }
    public MotherBoard getMotherBoardProduct(Integer productId){
        String query = "Select * from MotherBoard where productId = "+ productId;
        return jdbcTemplate.queryForObject(query, new MotherBoardMapper());
    }
    public GraphicCard getGraphicCardProduct(Integer productId){
        String query = "Select * from GRAPHICCARD where productId = "+ productId;
        return jdbcTemplate.queryForObject(query, new GraphicCardMapper());
    }
    public Processorrs getProcessorsProduct(Integer productId){
        String query = "Select * from PROCESSORS where productId = "+ productId;
        return jdbcTemplate.queryForObject(query, new ProcessorMapper());
    }
}
