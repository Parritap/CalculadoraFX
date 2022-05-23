package com.example.calculadorafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Universo;

public class Controller {

    private Universo universo= new Universo('U');

    @FXML
    private Button btnCalcularComplemento;

    @FXML
    private Button btnCalcularComplementoRealtiv;

    @FXML
    private Button btnCalcularDiff;

    @FXML
    private Button btnCalcularIntersec;

    @FXML
    private Button btnCalcularUnion;

    @FXML
    private Label labelResultado;

    @FXML
    private TextField txtfComplemento;

    @FXML
    private TextField txtfComplementoRelativ;

    @FXML
    private TextField txtfConjunto1;

    @FXML
    private TextField txtfConjunto2;

    @FXML
    private TextField txtfConjunto3;

    @FXML
    private TextField txtfConjunto4;

    @FXML
    private TextField txtfDiff;

    @FXML
    private TextField txtfIntersecc;

    @FXML
    private TextField txtfUnion;

    @FXML
    private TextField txtfUniverso;




}
