package com.example.sparepartapplication.Room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SparePart {

    @PrimaryKey(autoGenerate = true)
    private int id;
    public String name;
    public String price;
    public String number;
    public String type;
    public String model;
    public String description1;
    public String description2;
    public String description3;
    public String detail_picture;
    public String type_picture;
    public String model_logo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public String getDetail_picture() {
        return detail_picture;
    }

    public void setDetail_picture(String detail_picture) {
        this.detail_picture = detail_picture;
    }

    public String getType_picture() {
        return type_picture;
    }

    public void setType_picture(String type_picture) {
        this.type_picture = type_picture;
    }

    public String getModel_logo() {
        return model_logo;
    }

    public void setModel_logo(String model_logo) {
        this.model_logo = model_logo;
    }
}
