package com.example.calculadorafx;

import exceptions.SetNotFoundException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Conjunto;
import model.Operaciones;
import model.Universo;
import model.Utils;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Universo universo;

    @FXML
    private Button btnCalcularComplemento;

    @FXML
    private Button btnCalcularDiferenciaSimetrica;

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
    private TextField txtfDiferenciaSimetrica;

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


    public void instanciarConjuntos() {

        crearUniverso(txtfUniverso.getText());

        if (universo != null) {
            crearConjunto(txtfConjunto1.getText());
            crearConjunto(txtfConjunto2.getText());
            crearConjunto(txtfConjunto3.getText());
            crearConjunto(txtfConjunto4.getText());
        }
    }

    private void crearConjunto(String str) {

        if (str != null && !str.equals("")) {
            Conjunto aux = new Conjunto(str, universo);
            aux.update();
            universo.getListaConjuntos().add(aux);
        }
    }

    public void crearUniverso(String str) {
        if (str != null && !str.equals("")) {
            String[] strArray = str.split(",");
            ArrayList<String> list = new ArrayList<>(List.of(strArray));
            ArrayList<String> cleanList = Utils.cleanElements(list);

            this.universo = new Universo(cleanList);
        }

    }

    public void onActionUnion() throws Exception {

        instanciarConjuntos();

        Conjunto[] parConjuntos = universo.getParConjuntos(txtfUnion.getText());

        ArrayList<String> union = Operaciones.getUnion(parConjuntos[0], parConjuntos[1]);

        String str = Utils.toString(union);

        labelResultado.setText(str);

    }

    public void onActionInterseccion () throws Exception {

        instanciarConjuntos();

        Conjunto[] parConjuntos = universo.getParConjuntos(txtfIntersecc.getText());

        ArrayList<String> union = Operaciones.getIntersection(parConjuntos[0], parConjuntos[1]);

        String str = Utils.toString(union);

        labelResultado.setText(str);

    }

    public void onActionDiferencia () throws Exception {

        instanciarConjuntos();

        Conjunto[] parConjuntos = universo.getParConjuntos(txtfDiff.getText());

        ArrayList<String> union = Operaciones.getDifference(parConjuntos[0], parConjuntos[1]);

        String str = Utils.toString(union);

        labelResultado.setText(str);

    }

    public void onActionDiferenciaSimetrica() throws Exception {

        instanciarConjuntos();

        Conjunto[] parConjuntos = universo.getParConjuntos(txtfDiferenciaSimetrica.getText());

        ArrayList<String> list = Operaciones.getSimetricDiff(parConjuntos[0], parConjuntos[1]);

        String str = Utils.toString(list);

        labelResultado.setText(str);

    }


    public void onActionComplemento () throws Exception {

        Conjunto aux = universo.getConjunto(txtfComplemento.getText().charAt(0));

        ArrayList<String> list = Operaciones.getComplement(aux);

        String output = Utils.toString(list);

        labelResultado.setText(output);
    }






}


