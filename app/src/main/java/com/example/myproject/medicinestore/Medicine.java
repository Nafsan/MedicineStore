package com.example.myproject.medicinestore;

public class Medicine {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany(){
        return company;
    }
    public void setCompany(String company){
        this.company = company;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    String name,company, category, description,disease,price;
    public Medicine(String name, String company, String category, String description, String disease, String price) {
        this.name = name;
        this.company = company;
        this.category = category;
        this.description = description;
        this.disease = disease;
        this.price = price;
    }

    public Medicine() {

    }
    public String toString(){
        return name+" price: "+price+" (Per piece) "+company;

    }

}
