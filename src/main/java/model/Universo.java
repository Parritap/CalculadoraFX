package model;

import exceptions.InvalidStringException;
import exceptions.MoreThanTwoSetsException;
import exceptions.SetNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.List;



public class Universo {

    ////////////////////////////////////////// ATRIBUTOS  ///////////////////////////////////////////

    private char ID = 'U';
    private ArrayList<String> elements;
    private ArrayList<Conjunto> listaConjuntos;

    ////////////////////////////////////////// CONSTRUCTORES ///////////////////////////////////////////


    public Universo(char ID, ArrayList<String> elements, ArrayList<Conjunto> listaConjuntos) {
        this.ID = ID;
        this.elements = elements;
        this.listaConjuntos = listaConjuntos;
    }

    public Universo(ArrayList<String> elements) {
        this.elements = elements;
        this.listaConjuntos = new ArrayList<>();
    }

    public Universo (String str){
        String[] s = str.split(",");
        this.elements = new ArrayList<>(List.of(s));
        this.listaConjuntos = new ArrayList<>();
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

    public  Conjunto getConjunto (char c) throws SetNotFoundException{

        for (Conjunto e: listaConjuntos) {

            if (e.getID() == c)
                return e;
        }
        throw new SetNotFoundException("EL CONJUNTO CON LA LETRA -" + c +"- NO EXISTE");
    }

    public Conjunto[] getParConjuntos (String str) throws  Exception {

        if(str.length()>=4)
            throw new MoreThanTwoSetsException("No pueden haber más de 3 caracteres dentro del cuadro de texto de operación");

        if(str.length()<=2){
            throw new InvalidStringException ("Hay dos o menos caracteres dentro de la operación.");
        }

        if(str.charAt(1)!=',')
            throw new InvalidStringException ("Los conjuntos han de estar separados una coma");

        Conjunto[] list = new Conjunto[2];
        list[0]=getConjunto(str.charAt(0));
        list[1]=getConjunto(str.charAt(2));

        return list;
    }
}
