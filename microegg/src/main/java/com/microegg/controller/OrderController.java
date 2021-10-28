package com.microegg.controller;

import com.microegg.model.CartProduct;
import com.microegg.model.OrderProduct;
import com.microegg.model.Product;
import com.microegg.model.Request.Order;
import com.microegg.model.Request.ProductIntoCart;
import com.microegg.model.Request.Transaction;
import com.microegg.response.ApiRestResponse;
import com.microegg.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/createCart/{userId}")
    public ResponseEntity<ApiRestResponse> createCart(@PathVariable Integer userId){
        ApiRestResponse response = new ApiRestResponse();
        try{
            Integer data = orderService.createCart(userId);
            response.setData(data);
        }
        catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
    }

    @PostMapping("/addToCart")
    public ResponseEntity<ApiRestResponse> addProductToCart(@RequestBody ProductIntoCart productToCart){

        ApiRestResponse response = new ApiRestResponse();
        try{
            Integer data = orderService.addProductToCart(productToCart.getCartId(),productToCart.getProductId(),
                    productToCart.getQuantity());
            response.setData(data);
        }
        catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);

    }

    @GetMapping("/getCartProducts/{cartId}")
    public ResponseEntity<ApiRestResponse> getCartProducts(@PathVariable Integer cartId){

        ApiRestResponse response = new ApiRestResponse();
        try{
            List<CartProduct> data = orderService.getCartProducts(cartId);
            response.setData(data);
        }
        catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);

    }


    @PostMapping("/order")
    public ResponseEntity<ApiRestResponse> doOrder(@RequestBody Order order){

        ApiRestResponse response = new ApiRestResponse();
        try{
            Integer data = orderService.doOrder(order.getCartId(),order.getUserId(), order.getAddressId());
            response.setData(data);
        }
        catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);

    }

    @GetMapping("/getOrderedProductsByOrderId/{orderId}")
    public ResponseEntity<ApiRestResponse> getOrderedProductByOrderId(Integer orderId){
        ApiRestResponse response = new ApiRestResponse();
        try{
            List<OrderProduct> data = orderService.getOrderedProduct(orderId);
            response.setData(data);
        }
        catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
    }

    @GetMapping("/getOrderedProductsByUserId/{userId}")
    public ResponseEntity<ApiRestResponse> getOrderedProductByuserId(Integer userId){
        ApiRestResponse response = new ApiRestResponse();
        try{
            List<OrderProduct> data = orderService.getOrderedProductByUserId(userId);
            response.setData(data);
        }
        catch (Exception ex){
            response.setError(true);
            response.setSuccess(false);
            response.setErrorMessage(ex.getMessage());
        }
        return new ResponseEntity<>(response,
                response.getError() ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.OK);
    }



    @PostMapping("/transaction")
    public ResponseEntity<ApiRestResponse> doTransaction(@RequestBody Transaction transaction){
        ApiRestResponse response = new ApiRestResponse();
        try{
            Integer data = orderService.doTransaction(transaction.getCardId(),
                    transaction.getPaymentMode(),transaction.getOrderId());
            response.setData(data);
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
