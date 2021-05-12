package loyaltycard;

import customexception.CardLenghtException;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe per operazioni su codici Ean13
 * Calcolo del check digit e della sua validità
 * Costruttore di default private per permettere solo l'uso di quello con parametro
 */
public class LoyaltyCard {


    /**
     * Codice della carta
     */
    private String numberCard;

    /**
     * variabile d'ambiente per la minima lunghezza del codice
     */
    private static final int MIN_LENGHT = 12;

    /**
     * variabile d'ambiente per la massima lunghezza del codice
     */
    private static final int MAX_LENGHT = 13;


    private LoyaltyCard(){}


    /**
     * Costruttore che crea un oggetto con il numero carta passato, richiamando il metodo setter
     * @param numberCard Numero della carta
     * @throws CardLenghtException
     */
    public LoyaltyCard(String numberCard)throws CardLenghtException {
        setNumberCard(numberCard);
    }


    /**
     * Metodo che controlla la validità del codice e del suo checkDigit
     * @return True se il check Digit è corretto
     */
    public boolean checkValidity(){
        if (isMaxLenght()) {
            int finDigit = Character.getNumericValue(numberCard.charAt(numberCard.length() - 1));
            return checkDigit() == finDigit;
        }
        return false;
    }


    /**
     * Metodo con algoritmo per il calcolo della check digit
     * @return La check digit
     */
    public int checkDigit(){
        List<Integer> in = new ArrayList<>();
        for (int i = 0; i < MIN_LENGHT; i++) {
            in.add(i, Character.getNumericValue(numberCard.charAt(i)));
        }

        int p = 0;
        int d = 0;

        for (int i = 0; i< MIN_LENGHT; i++){
            if (i == 0 || (i % 2) == 0 ){
                p = p + in.get(i);
            }else{
                d = d + in.get(i);
            }
        }

        Integer unitDigit = p + (d*3);
        String sUnitD = unitDigit.toString();
        int uD = Character.getNumericValue(sUnitD.charAt(sUnitD.length() - 1));
        int cDigit = 10 - uD;
        return cDigit;
    }


    /**
     * Metodo che ritorna il numero di carta senza check digit
     * @return Il numero della carta senza check
     */
    public String getCardNo(){
        if (isMinLenght()){
            return numberCard;
        }else{
            String cardNo = numberCard.substring(0, numberCard.length() - 1);
            return cardNo;
        }
    }


    /**
     * Metodo che ritorna l'intero numero carta
     * @return Il numero della Carta compreso di check digit
     */
    public String getFullCardNo(){
        if (isMaxLenght()){
            return numberCard;
        }else{
            String cDgt = Integer.toString(checkDigit());
            String fullCardNo = numberCard + cDgt;
            return fullCardNo;
        }
    }

    /**
     * Metodo per il controllo sulla lunghezza del codice passato
     * Massimo 12 cifre
     * @return True se è di 12 cifre
     */
    public boolean isMinLenght(){
        return numberCard.length() == MIN_LENGHT;
    }



    /**
     * Metodo per il controllo sulla lunghezza del codice passato
     * Massimo 13 cifre
     * @return
     */
    public boolean isMaxLenght(){
        return numberCard.length() == MAX_LENGHT;
    }


    /**
     * Getter NumberCard
     * @return Numero della carta
     */
    public String getNumberCard() {
        return numberCard;
    }


    /**
     * Setter NumberCard
     * Richiama il metodo isNumeric per controllare se sono presenti solo valori numerici altrimenti esce un eccezione
     * Controlla che la lunghezza del numero della carta sia valido, altrimenti esce un eccezione
     * @param numberCard Numero della carta fedeltà
     * @throws CardLenghtException
     */
    public void setNumberCard(String numberCard) throws CardLenghtException{
        if (isNumeric()) {
            if (numberCard.length() == MIN_LENGHT || numberCard.length() == MAX_LENGHT) {
                this.numberCard = numberCard;
            } else {
                this.numberCard = null;
                throw new CardLenghtException();
            }
        }else{
            throw new CardLenghtException("Card Number not valid, there are characters not numeric, provide to change.");
        }
    }


    /**
     * Metodo per il controllo se il numero carta fedeltà è solo numerico tramite una regular expression
     * @return True se ha solo valori numerici
     */
    private boolean isNumeric(){
        return numberCard.matches("\\d+");
    }
}
