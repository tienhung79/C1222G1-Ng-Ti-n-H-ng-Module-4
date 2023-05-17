package com.example.cartproduct.service.impl;

import com.example.cartproduct.dto.ProductFromCartDTO;
import com.example.cartproduct.service.IServiceProductFromCart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProductFromCart implements IServiceProductFromCart {

    @Override
    public long totalBill(List<ProductFromCartDTO> productFromCartDTOList) {
        long totalBill =0;
        for (int i = 0; i < productFromCartDTOList.size(); i++) {
            totalBill+= productFromCartDTOList.get(i).getTotalPrice();
        }
        return totalBill;
    }
}
