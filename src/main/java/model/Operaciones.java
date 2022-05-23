package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Operaciones {


    /**
     * Método que calcula la union entre dos conjuntos
     * @param a Object de tipo Conjunto
     * @param b Object de tipo Conjunto
     * @return Lista con los elementos de la union.
     */
    public static ArrayList<String> getUnion(Conjunto a, Conjunto b) {

        ArrayList<String> list = new ArrayList<>();

        if(a.getUniverse() == b.getUniverse()){ //Si ambos pertenecen al mismo universo.

            for (String e: a.getElements()) {
                agregar(list,a.getUniverse(), e);
            }
            for (String e: b.getElements()) {
                agregar(list,a.getUniverse(), e);
            }
        }




        return list;
    }

    /**
     * Método que obtiene la intersección entre dos conjuntos dados.
     * @param a Object de tipo Conjunto
     * @param b Object de tipo Conjunto
     * @return Lista con los elementos de la intersección.
     */
    public static ArrayList<String> getIntersection(Conjunto a, Conjunto b) {

        ArrayList<String> list = new ArrayList<>();

        if (a.getUniverse() == b.getUniverse()){
            for (String e: a.getElements()) {

                if(b.getElements().contains(e))
                    agregar(list, a.getUniverse(), e);
            }
        }



     return list;
    }


    /**
     * Método que obtiene la diferencia simétrica entre dos conjuntos dados.
     * @param a Object de tipo Conjunto
     * @param b Object de tipo Conjunto
     * @return Lista con la diferencia simétrica.
     */
    public static ArrayList<String> getSimetricDiff(Conjunto a, Conjunto b) {

        ArrayList<String> intersec = new ArrayList<>();

        if(a.getUniverse() == b.getUniverse()){

            ArrayList<String> union = getIntersection(a,b);

            for (String e: a.getElements()) {
                if(!union.contains(e))
                    agregar(intersec, a.getUniverse(), e);
            }

            for (String e: b.getElements()) {
                if(!union.contains(e))
                    agregar(intersec, a.getUniverse(), e);
            }

        }



        return intersec;
    }

    public static ArrayList<String> getComplement (Conjunto c){

        ArrayList<String> list = new ArrayList<>();

        for (String e : c.getUniverse().getElements()) {

            if(!c.getElements().contains(e))
                agregar(list, c.getUniverse(),e);
        }

        return list;
    }

    /**
     * Método que obtiene la diferencia del conjunto "a" respecto "b" (a-b).
     * @return Una lista con la diferencia (a-b). Si ambos conjuntos no pertenecen al mismo universo,
     * entonces la lista estará vacía.
     */
    public static ArrayList<String> getDifference(Conjunto a, Conjunto b){

        ArrayList<String> list = new ArrayList<>();

        if(a.getUniverse() == b.getUniverse()){

            ArrayList<String> intersection = getIntersection(a, b);

            for (String e: a.getElements()
                 ) {
                if (!intersection.contains(e))
                    agregar(list, a.getUniverse(), e);
            }

        }
        return  list;
    }



    /**
     * Método que agrega un elemento a la lista dadas unas condiciones. Usa isValidElement().
     * @param list Lista de Strings a la que se le agrega el elemento indicado en el argumento.
     * @param universe Conjunto universo, el cual limita los elementos que puedan agregarse a la lista.
     * @param e Elemento a agregar de tipo String
     */
    public static void agregar (ArrayList<String> list, Universo universe, String e){
        if (isValidElement(e) && !list.contains(e) && universe.getElements().contains(e))
            list.add(e);
    }






    ///////////////////////////////////////////////////////////////


    public static void update(ArrayList<String> list) {

        Set<String> hashSet = new HashSet<String>(list); //HashSet no permite elementos repetidos.

        clean(list);

        if (hashSet.size() < list.size()) {

            for (int i = 0; i < list.size(); i++) {

                String x = list.get(i);

                for (int j = 0; j < list.size(); j++) {

                    if (i != j) {
                        if (list.get(i).equals(list.get(j))) {
                            list.remove(j);
                            j--;
                        }
                    }
                }
            }
        }
    }


    /**
     * Método que remueve posibles elementos no deseados dentro de una lista.
     * Los elementos no deseados son los NULL, No-dígitos, y No-Palabras.
     * Ni las palabras ni los dígitos pueden tener espacios.
     * @param list Lista a limpiar.
     */
    public static void clean(ArrayList<String> list) {

        for (int i = 0; i < list.size(); i++) {
            if (!isValidElement(list.get(i)) || list.get(i) == null) {
                list.remove(i);
                i--;
            }
        }
    }


    /**
     * Verifica que el elemento no sea un no-digito o una no-letra. Tampoco puede contener espacios ni ser nulo.
     * @param e elemento de tipo String a evaluar.
     * @return True si @e es un dígito o una palabra. False si @e contiene espacios o símbolos especiales como '!', '.', '-', etc..
     */
    public static boolean isValidElement(String e) {
        return (e!= null && Pattern.matches("\\d*", e) || Pattern.matches("\\w*", e));
    }



}