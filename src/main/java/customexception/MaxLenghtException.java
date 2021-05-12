package customexception;

/**
 * Classe per eccezione custom
 * Per la lunghezza massima del codice della Loyalty Card
 */
public class MaxLenghtException extends Exception{

    /**
     * Costruttore di default
     */
    public MaxLenghtException(){
        super("Il codice è troppo lungo, Max 13 cifre");
    }

    /**
     * Costruttore con parametro
     * @param message Il messaggio di errore dell'eccezione
     */
    public MaxLenghtException(String message){
        super(message);
    }
}
