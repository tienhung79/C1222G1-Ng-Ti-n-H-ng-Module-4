package com.example.cartproduct.dto;

public class ProductFromCartDTO {
    private int id;

    private String nameProductFromCartDTO;
    private long priceProductFromCartDTO;
    private int quantityProductFromCartDTO;

    public ProductFromCartDTO() {
    }

    public ProductFromCartDTO(int id, String nameProductFromCartDTO, long priceProductFromCartDTO, int quantityProductFromCartDTO) {
        this.id = id;
        this.nameProductFromCartDTO = nameProductFromCartDTO;
        this.priceProductFromCartDTO = priceProductFromCartDTO;
        this.quantityProductFromCartDTO = quantityProductFromCartDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProductFromCartDTO() {
        return nameProductFromCartDTO;
    }

    public void setNameProductFromCartDTO(String nameProductFromCartDTO) {
        this.nameProductFromCartDTO = nameProductFromCartDTO;
    }

    public long getPriceProductFromCartDTO() {
        return priceProductFromCartDTO;
    }

    public void setPriceProductFromCartDTO(long priceProductFromCartDTO) {
        this.priceProductFromCartDTO = priceProductFromCartDTO;
    }

    public int getQuantityProductFromCartDTO() {
        return quantityProductFromCartDTO;
    }

    public void setQuantityProductFromCartDTO(int quantityProductFromCartDTO) {
        this.quantityProductFromCartDTO = quantityProductFromCartDTO;
    }
}
