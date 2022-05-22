package model;

import java.util.*;
import java.util.regex.Pattern;

public class Conjunto {


    private char ID;
    private ArrayList<String> elements;
    private Universo universe;




    /////////////////////// GETTERS AND SETTERS ////////////////////////


    public Universo getUniverse() {
        return universe;
    }

    public void setUniverse(Universo universe) {
        this.universe = universe;
    }

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
        update();
    }



    /////////////////////// CONSTRUCTORES ////////////////////////




    public Conjunto(char ID, ArrayList<String> elements, Universo universe) {
        this.ID = ID;
        this.elements = elements;
        this.universe = universe;
    }

    public Conjunto(char ID, ArrayList<String> elements) {
        this.ID = ID;
        this.elements = elements;
        update();
        sort();
    }

    /**
     * Este constructor añade el Identificador al conjunto y crea una instancia de la
     * lista @elementos cosa que esta no sea nula.
     *
     * @param ID Solo se permite
     */
    public Conjunto(char ID, Universo universe) {
        this.ID = ID;
        this.elements = new ArrayList<>();
        this.universe = universe;
    }

    /**
     * Constructor vacío
     */
    public Conjunto() {
    }

    //////////////////////////// MÉTODOS //////////////////////////////////////////////

    /**
     * Método que añade un elemento válido al conjunto.
     *
     * @param e Elemento de tipo Character
     */
    public void agregar(String e) {
        if (e != null && validElement(e) &&!elements.contains(e) && universe.getElements().contains(e)) {
            elements.add(e);
            sort();
        }
    }



    /**
     * Método que restrigirá los elementos que puedan ser agregados a los conjuntos.
     *
     * @param e elemento de tipo String a evaluar.
     * @return True si @e es un digito o una palabra. False si @e contiene espacios o simboloes especiales como '!', '.', '-', etc..
     */
    private boolean validElement(String e) {
        return (Pattern.matches("\\d*", e) || Pattern.matches("\\w*", e));
    }



    /**
     * Método que limpia valores repetidos dentro del @elementos.
     */
    public void update() {

        Set<String> hashSet = new HashSet<String>(elements); //HashSet no permite elementos repetidos.

        clean();

        if (hashSet.size() < elements.size()) {

            for (int i = 0; i < elements.size(); i++) {

                String x = elements.get(i);

                for (int j = 0; j < elements.size(); j++) {

                    if (i != j) {
                        if (elements.get(i).equals(elements.get(j))) {
                            elements.remove(j);
                            j--;
                        }
                    }
                }
            }
        }
    }

    /**
     * Método que remueve posibles elementos no deseados dentro de Conjunto.elementos.
     * Los elementos no deseados son los NULL, No-dígitos, y No-Palabras.
     * Ni las palabras ni los dígitos pueden tener espacios.
     */
    private void clean(){

        for (int i = 0; i < elements.size(); i++) {
            if(!validElement(elements.get(i)) || elements.get(i) == null){
                elements.remove(i);
                i--;
            }
        }
    }

    /**
     * Método que ordena los elementos de un conjunto según su valor en la tablas ASCII
     */
    public void sort() {
        Collections.sort(elements);
    }



    
}




