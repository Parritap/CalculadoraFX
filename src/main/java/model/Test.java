package model;

public class Test {

    public static void main(String[] args) {

        Universo u = new Universo('U');


        Conjunto a = new Conjunto('A', u);
        Conjunto b = new Conjunto('B', u);

        u.agregar("1");
        u.agregar("2");
        u.agregar("3");
        u.agregar("4");
        u.agregar("5");
        u.agregar("6");
        u.agregar("7");


        a.agregar("1");
        a.agregar("2");
        a.agregar("3");

        b.agregar("3");
        b.agregar("4");
        b.agregar("5");

        System.out.println(u.getElements());
        System.out.println(a.getElements());
        System.out.println(b.getElements());

        System.out.println("");

        System.out.println(Operaciones.getUnion(a,b));
        System.out.println(Operaciones.getIntersection(a,b));
        System.out.println(Operaciones.getSimetricDiff(a,b)); //Union menos la interseccion.
        System.out.println(Operaciones.getComplement(a));
        System.out.println(Operaciones.getDifference(a, b));




    }


}
