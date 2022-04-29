package com.example.ex0414;

public class ProductVO {
    private int img;
    private int proname;
    private String procount;

    public ProductVO(){}

    public ProductVO(int img, int proname, String procount) {
        this.img = img;
        this.proname = proname;
        this.procount = procount;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getName() {
        return proname;
    }

    public void setName(int name) {
        this.proname = name;
    }

    public String getProcount() {
        return procount;
    }

    public void setProcount(String procount) {
        this.procount = procount;
    }

    @Override
    public String toString() {
        return "ProductVO{" +
                "img=" + img +
                ", proname='" + proname  +
                ", procount='" + procount  +
                '}';
    }
}
