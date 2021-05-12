package customexception;

/**
 * Classe per eccezione custom
 * Per la lunghezza minima del codice della Loyalty Card
 */
public class CardLenghtException extends Exception {

    /**
     * Costruttore di default
     */
    public CardLenghtException(){
        super("Value lenght of Card Number not valid, control if is in the range of validity.");
    }

    /**
     * Costruttore con parametro
     * @param message Il messaggio di errore dell'eccezione
     */
    public CardLenghtException(String message){
        super(message);
    }
}
