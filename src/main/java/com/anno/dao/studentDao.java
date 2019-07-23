package com.anno.dao;

import org.springframework.stereotype.Repository;

@Repository
public class studentDao {

    private String label1 = "1";

    @Override
    public String toString() {
        return "studentDao{" +
                "label1='" + label1 + '\'' +
                '}';
    }

    public String getLabel1() {
        return label1;
    }

    public void setLabel1(String label1) {
        this.label1 = label1;
    }
}
