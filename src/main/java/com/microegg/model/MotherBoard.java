package com.microegg.model;

public class MotherBoard extends Product{

    private String chipSet;
    private int size;

    public String getChipSet() {
        return chipSet;
    }

    public void setChipSet(String chipSet) {
        this.chipSet = chipSet;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
