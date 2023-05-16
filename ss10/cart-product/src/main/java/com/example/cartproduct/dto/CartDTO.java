package com.example.cartproduct.dto;

import java.util.LinkedHashMap;
import java.util.Map;

public class CartDTO {
    private final Map<Integer,Integer> selectedProducts;

    public CartDTO() {
        this.selectedProducts = new LinkedHashMap<>();
    }

    public Map<Integer, Integer> getSelectedProducts() {
        return selectedProducts;
    }
}
