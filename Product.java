package com.task1;

public class Product {

    private final String productID;
    private String type;
    private String manufacturer;
    private String productionDate;
    private String expiryDate;

    public Product (String productID) {
        this.productID = productID;
    }

    public void setType (String type) {this.type = type;}
    public void setManufacturer (String manufacturer) {this.manufacturer = manufacturer;}
    public void setProductionDate (String productionDate) {this.productionDate = productionDate;}
    public void setExpiryDate (String expiryDate) {this.expiryDate = expiryDate;}
    public String getID() {return(this.productID);}
    public String getType() {return(this.type);}
    public String getManufacturer() {return(this.manufacturer);}
    public String getProductionDate() {return(this.productionDate);}
    public String getExpiryDate() {return(this.expiryDate);}
}