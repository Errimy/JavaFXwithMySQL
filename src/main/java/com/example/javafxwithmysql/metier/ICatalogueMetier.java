package com.example.javafxwithmysql.metier;

import java.util.List;

public interface ICatalogueMetier {
    public List<Produit> Allproduits();
    public List<Produit> produitMC(String mc);
    public void addProduit(Produit p);

}
