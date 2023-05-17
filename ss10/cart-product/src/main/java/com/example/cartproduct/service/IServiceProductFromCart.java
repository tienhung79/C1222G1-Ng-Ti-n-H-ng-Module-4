package com.example.cartproduct.service;

import com.example.cartproduct.dto.ProductFromCartDTO;

import java.util.List;

public interface IServiceProductFromCart {

    long totalBill(List<ProductFromCartDTO> productFromCartDTOList);
}
