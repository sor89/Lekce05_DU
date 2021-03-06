package com.company;



public class DanoveSazbyStatu {
    private String zkratka;
    private String nazev;
    private Float plnaSazba;
    private Float snizenaSazba;
    private Boolean specialniSazba;

    public String getZkratka() {
        return zkratka;
    }

    public void setZkratka(String zkratka) {
        this.zkratka = zkratka;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public Float getPlnaSazba() {
        return plnaSazba;
    }

    public void setPlnaSazba(Float plnaSazba) {
        this.plnaSazba = plnaSazba;
    }

    public Float getSnizenaSazba() {
        return snizenaSazba;
    }

    public void setSnizenaSazba(Float snizenaSazba) {
        this.snizenaSazba = snizenaSazba;
    }

    public Boolean isSpecialniSazba() {
        return specialniSazba;
    }

    public void setSpecialniSazba(Boolean specialniSazba) {
        this.specialniSazba = specialniSazba;
    }
}
