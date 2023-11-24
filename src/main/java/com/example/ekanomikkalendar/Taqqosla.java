package com.example.ekanomikkalendar;

import android.graphics.Color;

public class Taqqosla {
    private static final String[] chars = {"-",".","0","1","2","3","4","5","6","7","8","9"};
    private String satr_son1 = "",satr_son2 = "";
    private String satr1,satr2;
    private double son1,son2;
    private String natija;
    private int rang;

    public Taqqosla(String satr1,String satr2){
        this.satr1 = satr1;
        this.satr2 = satr2;
        for(int i = 0; i < this.satr1.length(); i ++){
            for(String ch:chars){
                if(String.valueOf(this.satr1.charAt(i)).hashCode() == ch.hashCode()){
                    satr_son1 += String.valueOf(this.satr1.charAt(i));
                }
            }
        }
        for(int i = 0;i < this.satr2.length(); i ++){
            for(String ch:chars){
                if(String.valueOf(this.satr2.charAt(i)).hashCode() == ch.hashCode()){
                    satr_son2 += String.valueOf(this.satr2.charAt(i));
                }
            }
        }
        if(String.valueOf(satr_son1).isEmpty()){
            satr_son1 = "0";
        }
        if(String.valueOf(satr_son2).isEmpty()){
            satr_son2 = "0";
        }

        son1 = Double.parseDouble(String.valueOf(satr_son1));
        son2 = Double.parseDouble(String.valueOf(satr_son2));

        if(son2 == 0){
            natija = "/";
            rang = Color.rgb(147,148,150);
        }else {
            if (son2 > son1){
                natija = "+";
                rang = Color.rgb(0,255,0);
            } else if(son2 < son1){
                natija = "-";
                rang = Color.rgb(255,0,0);
            } else if(son1 == son2){
                natija = "/";
                rang = Color.rgb(147,148,150);
            }
        }

    }
    public String natija(){
        return natija;
    }
    public int rang(){
        return rang;
    }
}

