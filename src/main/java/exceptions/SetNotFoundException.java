package exceptions;

public class SetNotFoundException extends Exception{

    public SetNotFoundException(String str){
        super(str);
    }

    public SetNotFoundException(){
        super();
    }
}
