package exceptions;

public class InvalidStringException extends Exception{


    public InvalidStringException (String str){
        super(str);
    }

    public InvalidStringException (){
        super();
    }
}
