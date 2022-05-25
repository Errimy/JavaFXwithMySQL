package com.example.javafxwithmysql.metier;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.Serializable;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerProduct implements Initializable {
    @FXML
    private TextField fieldMC;
    @FXML
    private Button Research;
    @FXML
    private TableView<Produit> ProductsTable;
    @FXML
    private TableColumn<Produit, Integer> IDColomn;
    @FXML
    private TableColumn<Produit, String> NameColomn;
    @FXML
    private TableColumn<Produit, Double> PriceColomn;
    @FXML
    private TableColumn<Produit, Integer> QuantityColomn;
    ObservableList<Produit> observableList= FXCollections.observableArrayList();
    private ICatalogueMetier metier;
    @Override
    public void initialize(URL location, ResourceBundle resources){
        IDColomn.setCellValueFactory(new PropertyValueFactory<>("idProduit"));
        NameColomn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        PriceColomn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        QuantityColomn.setCellValueFactory(new PropertyValueFactory<>("quantité"));
        metier= (ICatalogueMetier) new CatalogueMetierImpl();
        observableList.addAll(metier.Allproduits());
    }
    public void Rechercher(){
        String motcle=fieldMC.getText();
        List<Produit> produits= metier.produitMC(motcle);
        observableList.clear();
        observableList.addAll(produits);

    }
}
