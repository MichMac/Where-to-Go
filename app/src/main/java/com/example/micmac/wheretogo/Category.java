package com.example.micmac.wheretogo;


import java.io.Serializable;

public class Category implements Serializable {

    private String CategoryName;
    private String CategoryName_GM;

    private boolean active;

    public Category(String CategoryName, String CategoryName_GM)  {
        this.CategoryName= CategoryName;
        this.CategoryName_GM = CategoryName_GM;
        this.active= true;
    }

    public Category(String CategoryName, String CategoryName_GM, boolean active)  {
        this.CategoryName= CategoryName;
        this.CategoryName_GM = CategoryName_GM;
        this.active= active;
    }

    public String getCategoryName_GMType() {
        return CategoryName_GM;
    }

    public void setCategoryName_GMType(String CategoryName_GM) {
        this.CategoryName_GM = CategoryName_GM;
    }

    public String getCategoryNameName() {
        return CategoryName;
    }

    public void setCategoryNameName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return this.CategoryName;
    }

}
