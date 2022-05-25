package com.example.javafxwithmysql.metier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogueMetierImpl implements ICatalogueMetier{

    @Override
    public List<Produit> produitMC(String mc){
        List<Produit> products=new ArrayList<>();
        try{
            Connection connect=SingletonConnection.getConnection();
            PreparedStatement p=connect.prepareStatement("select * from produit where Name like ?");
            p.setString(1,"%"+mc+"%");
            ResultSet r=p.executeQuery();
            while(r.next()){
                Produit pr=new Produit();
                pr.setIdProduit(r.getInt("Id"));
                pr.setName(r.getString("Nom"));
                pr.setPrix(r.getDouble("Prix"));
                pr.setQuantite(r.getInt("Qantité"));//Quantite ...
                products.add(pr);
            }
            p.close();
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    @Override
    public List<Produit> Allproduits(){
        Connection connect=SingletonConnection.getConnection();
        List<Produit> products=new ArrayList<>();
        try{
        PreparedStatement p=connect.prepareStatement("select * from produit");
        ResultSet resultSet=p.executeQuery();
        while(resultSet.next()) {
            Produit p1 = new Produit(resultSet.getInt("Id"), resultSet.getString("Nom"),
                    resultSet.getDouble("Prix"), resultSet.getInt("Qantité"));
            products.add(p1);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    @Override
    public void addProduit(Produit prod) {
     try{
         Connection connect=SingletonConnection.getConnection();
         PreparedStatement p=connect.prepareStatement
                 ("insert into produits (Name,Prix,Qantité) values(?,?,?)");
         p.setString(1,prod.getName());
         p.setDouble(2,prod.getPrix());
         p.setInt(1,prod.getQuantite());
         int nmbr=p.executeUpdate();
         connect.close();
     } catch (Exception e) {
         e.printStackTrace();
     }
    }
}
