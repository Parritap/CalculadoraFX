package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class Universo {

    ////////////////////////////////////////// ATRIBUTOS  ///////////////////////////////////////////

    private char ID;
    private ArrayList<String> elements;
    private ArrayList<Conjunto> listaConjuntos;

    ////////////////////////////////////////// CONSTRUCTORES ///////////////////////////////////////////


    public Universo(char ID, ArrayList<String> elements, ArrayList<Conjunto> listaConjuntos) {
        this.ID = ID;
        this.elements = elements;
        this.listaConjuntos = listaConjuntos;
    }

    public Universo(char ID, ArrayList<String> elements) {
        this.ID = ID;
        this.elements = elements;
    }

    public Universo(char ID) {
        this.ID = ID;
        this.elements = new ArrayList<>();
        this.listaConjuntos = new ArrayList<Conjunto>();
    }

    /**
     * Constructor vacío
     */
    public Universo() {
    }


    //////////////////////////////////// GETTERS AND SETTERS ///////////////////////////////

    public char getID() {
        return ID;
    }

    public void setID(char ID) {
        this.ID = ID;
    }

    public ArrayList<String> getElements() {
        return elements;
    }

    public void setElements(ArrayList<String> elements) {
        this.elements = elements;
    }

    public ArrayList<Conjunto> getListaConjuntos() {
        return listaConjuntos;
    }

    public void setListaConjuntos(ArrayList<Conjunto> listaConjuntos) {
        this.listaConjuntos = listaConjuntos;
    }


    ///////////////////////////////// MÉTODOS ///////////////////////////////////////////////

    public void agregar(String e) {
        if (e != null && validElement(e) &&!elements.contains(e)) {
            elements.add(e);
            sort();
        }
    }

    private boolean validElement(String e) {
        return (Pattern.matches("\\d*", e) || Pattern.matches("\\w*", e));
    }

    public void sort() {
        Collections.sort(elements);
    }
}
