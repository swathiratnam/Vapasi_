package com.example;

public class Calculator {

    public double caldouble(int val) {
        double res;
        if (val == 0) {

            throw new MyArithException("Zero not allowed");

        } else if (val < 0) {

            throw new MyArithException("negative not allowed");

        } else {
            res = val;
            return res;
        }


    }
}
