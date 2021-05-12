package customexception;

/**
 * Classe per eccezione custom
 * Per la lunghezza minima del codice della Loyalty Card
 */
public class MinLenghtException extends Exception {

    /**
     * Costruttore di default
     */
    public MinLenghtException(){
        super("Il codice è troppo corto, Min 12 cifre");
    }

    /**
     * Costruttore con parametro
     * @param message Il messaggio di errore dell'eccezione
     */
    public MinLenghtException(String message){
        super(message);
    }
}
