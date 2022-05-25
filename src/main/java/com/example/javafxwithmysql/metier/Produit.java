package com.example.javafxwithmysql.metier;

import java.io.Serializable;

public class Produit implements Serializable {
    private int idProduit;
    private String Name;
    private double prix;
    private int quantite;

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Produit(){
        super();
    }

    public Produit(int idProduit, String name, double prix, int quantite) {
        super();
        this.idProduit = idProduit;
        Name = name;
        this.prix = prix;
        this.quantite = quantite;
    }
}
