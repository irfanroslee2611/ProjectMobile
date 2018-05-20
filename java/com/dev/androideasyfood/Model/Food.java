package com.dev.androideasyfood.Model;

/**
 * Created by user on 10/19/2017.
 */

public class Food {
   private String Name,Image,Description,Price,Discount,MenuId;

    public Food() {
    }

    public Food(String name, String image, String price, String description, String discount, String menuId) {
        Name = name;
        Image = image;
        Price = price;
        Description = description;
        Discount = discount;
        MenuId = menuId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
