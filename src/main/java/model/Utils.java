package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Utils {

    public static void main(String[] args) {
        String n = null;
        String str = "1,2,3,4,5";

        String[] strArray = str.split(",");

       // System.out.println(Arrays.toString(strArray));
        ArrayList<String> list = new ArrayList<>(List.of(strArray));
        //System.out.println(List.of(strArray));

        String x = String.join(", ", strArray);
        System.out.println(x);
    }

    /**
     * Método que corta un String cuando encuentre una coma, y mete todos los elementos
     * dentro de un arreglo de tipo String.
     *
     * @param str String a cortar.
     * @return Arreglo de Strings sin la coma.
     */
    public static String[] dividirPorComas(String str) {
        return str.split(",");
    }

    /**
     * Convierte un String que debe estar separado por comas
     * en un arreglo de enteros.
     * <p>
     * Es decir, si el String es "1,2,3,4", entonces el método retornará el siguiente arreglo de enteros: {1,2,3,4}
     *
     * @param str String que se divide por las comas y cuyos elementos se convierte en números.
     * @return Arreglo de numeros.
     */
    public static int[] stringToIntArray(String str) {

        String[] strArray = dividirPorComas(str);
        int[] intArray = new int[strArray.length];

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }

        return intArray;
    }


    public static int[][] dividirStringPorEspacios(String str) {

        String[] strArray = str.split(" ");
        int[][] matrix = new int[strArray.length][];

        for (int i = 0; i < matrix.length; i++) {

            matrix[i] = stringToIntArray(strArray[i]);
        }

        return matrix;
    }

    public static int[] toIntArray(ArrayList<Integer> list) {

        int[] array = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static int[] removerDuplicados(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int element : array) {
            if (!list.contains(element))
                list.add(element);
        }
        return toIntArray(list);
    }

    public static ArrayList<String> cleanElements(ArrayList<String> list) {

        ArrayList<String> newList = new ArrayList<>(list);

        for (int i = 0; i < newList.size(); i++) {
            String aux = list.get(i);

            if (!validElement(aux)) {
                list.remove(i);
                i--;
            }
        }
        return newList;
    }

    private static boolean validElement(String e) {
        return (Pattern.matches("\\d*", e) || Pattern.matches("\\w*", e));
    }

    public static String toString(ArrayList<String> list){
        return String.join(", ", list);
    }


}
