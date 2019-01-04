package ErrorHandlers;

public class GUIException extends Exception{
    //para las que salten del graphics layer
    public GUIException(String message) {
        super(message);
    }

}
