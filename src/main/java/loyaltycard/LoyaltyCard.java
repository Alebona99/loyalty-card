package loyaltycard;

import java.util.ArrayList;
import java.util.List;

public class LoyaltyCard {

    /**
     * Attributi della cartà fedeltà
     */
    private Long numberCard;
    private static final int MIN_LENGHT = 12;
    private static final int MAX_LENGHT = 13;


    /**
     * Costruttore di default
     */
    public LoyaltyCard(){}

    /**
     * Costruttore con parametro
     * @param numberCard Numero della carta
     */
    public LoyaltyCard(long numberCard){
        this.numberCard = numberCard;
    }


    /**
     * Metodo che controlla la validità del codice e del suo checkDigit
     * @return True se il check Digit è corretto
     */
    public boolean checkValidity(){
        if (isMaxLenght()) {
            String code = numberCard.toString();
            Integer finDigit = Character.getNumericValue(code.charAt(code.length() - 1));
            return checkDigit() == finDigit;
        }
        return false;
    }


    /**
     * Metodo con algoritmo per il calcolo della check digit
     * @return La check digit
     */
    public int checkDigit(){
        String s = numberCard.toString();
        List<Integer> in = new ArrayList<>();
        for (int i = 0; i < MIN_LENGHT; i++) {
            in.add(i, Character.getNumericValue(s.charAt(i)));
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
    public long getCardNo(){
        if (isMinLenght()){
            return numberCard;
        }else{
            String card = numberCard.toString();
            long cardNo = Long.getLong(card.substring(0, card.length() - 1));
            return cardNo;
        }
    }


    /**
     * Metodo che ritorna l'intero valore del codice
     * @return Ritorna l'intero valore del codice
     */
    public long getFullCardNo(){
        if (isMaxLenght()){
            return numberCard;
        }else{
            String code = numberCard.toString();
            String cDgt = Integer.toString(checkDigit());
            long fullCardNo = Long.decode(code + cDgt);
            return fullCardNo;
        }
    }

    /**
     * Metodo per il controllo sulla lunghezza del codice passato
     * Massimo 12 cifre
     * @return True se è di 12 cifre
     */
    public boolean isMinLenght(){
        return numberCard.toString().length() == MIN_LENGHT;
    }



    /**
     * Metodo per il controllo sulla lunghezza del codice passato
     * Massimo 13 cifre
     * @return
     */
    public boolean isMaxLenght(){
        return numberCard.toString().length() == MAX_LENGHT;
    }


    /**
     * Getter NumberCard
     * @return
     */
    public Long getNumberCard() {
        return numberCard;
    }


    /**
     * Setter NumberCard
     * @param numberCard Numero della carta fedeltà
     */
    public void setNumberCard(Long numberCard) {
        this.numberCard = numberCard;
    }


    public static void main(String[] args) {

        LoyaltyCard l = new LoyaltyCard(1234567809123L);

        //Check digit
        l.setNumberCard(978014102662L);
        //l.getFullCardNo();
        System.out.println("Il check Digit è: " + l.checkDigit());
        System.out.println("Full Card: " + l.getFullCardNo());

        //Check Validity
        l.setNumberCard(9780141026626L);
        System.out.println(l.checkValidity());
    }

}