package com.microegg.controller;

import com.microegg.model.*;
import com.microegg.response.ApiRestResponse;
import com.microegg.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<ApiRestResponse> getAllProduct(){
        ApiRestResponse response = new ApiRestResponse();
        try{
            List<Product> productList = productService.getAllProduct();
            response.setData(productList);
        }
        catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
    }

    @GetMapping("/searchByType/{category}")
    public ResponseEntity<ApiRestResponse> SearchByType(@PathVariable String category){
        ApiRestResponse response = new ApiRestResponse();
        try{
            List<Product> productList = productService.searchProductByType(category);
            response.setData(productList);
        }
        catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
    }

    @GetMapping("/coolingProductDetail/{productId}")
    public ResponseEntity<ApiRestResponse> getCoolingProductDetial(@PathVariable Integer productId){
        ApiRestResponse response = new ApiRestResponse();
        try{
            Colling product = productService.getCollingProductDetail(productId);
            response.setData(product);
        }
        catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
    }

    @GetMapping("/getGraphicCardDetail/{productId}")
    public ResponseEntity<ApiRestResponse> getGraphicCard(@PathVariable Integer productId){
        ApiRestResponse response = new ApiRestResponse();
        try{
            GraphicCard product = productService.getGraphicCard(productId);
            response.setData(product);
        }
        catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
    }

    @GetMapping("/getMotherBoardDetail/{productId}")
    public ResponseEntity<ApiRestResponse> getMotherBoard(@PathVariable Integer productId){
        ApiRestResponse response = new ApiRestResponse();
        try{
            MotherBoard product = productService.getMotherBoard(productId);
            response.setData(product);
        }
        catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
    }

    @GetMapping("/getPowerSupplyDetail/{productId}")
    public ResponseEntity<ApiRestResponse> getPowerSupply(@PathVariable Integer productId){
        ApiRestResponse response = new ApiRestResponse();
        try{
            PowerSupply product = productService.getPowerSupply(productId);
            response.setData(product);
        }
        catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
    }

    @GetMapping("/getRamDetail/{productId}")
    public ResponseEntity<ApiRestResponse> getRam(@PathVariable Integer productId){
        ApiRestResponse response = new ApiRestResponse();
        try{
            Ram product = productService.getRam(productId);
            response.setData(product);
        }
        catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
    }

    @GetMapping("/getStoragesDetail/{productId}")
    public ResponseEntity<ApiRestResponse> getStorages(@PathVariable Integer productId){
        ApiRestResponse response = new ApiRestResponse();
        try{
            Storage product = productService.getStorage(productId);
            response.setData(product);
        }
        catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
    }

    @GetMapping("/getComputerCases/{productId}")
    public ResponseEntity<ApiRestResponse> getComputerCases(@PathVariable Integer productId){
        ApiRestResponse response = new ApiRestResponse();
        try{
            ComputerCases product = productService.getComputerCasesProduct(productId);
            response.setData(product);
        }
        catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
    }
}
