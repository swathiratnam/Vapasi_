package com.laptop;

public class HDD {
    private int size;
    private String htype;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getHtype() {
        return htype;
    }

    public void setHtype(String htype) {
        this.htype = htype;
    }

    @Override
    public String toString() {
        return "LaptopExample.HDD{" +
                "size=" + size +
                ", htype='" + htype + '\'' +
                '}';
    }
}
