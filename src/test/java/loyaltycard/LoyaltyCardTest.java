package loyaltycard;

import customexception.CardLenghtException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe di Test per la classe LoyaltyCard
 */
class LoyaltyCardTest {

    /**
     * test case costruttore param 1
     * Verifico che mettendo un numero maggiore di quello consentito(13) esca un eccezione
     * @throws CardLenghtException
     */
    @Test
    void constructor_max_lenght() throws CardLenghtException {
        assertThrows(CardLenghtException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                LoyaltyCard l = new LoyaltyCard("123456789012345");
            }
        });

    }


    /**
     * test case costruttore param 2
     * Verifico che mettendo un valore minore di quello consentito(12) esca un eccezione
     * @throws CardLenghtException
     */
    @Test
    void constructor_min_lenght() throws CardLenghtException{
        assertThrows(CardLenghtException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                LoyaltyCard l = new LoyaltyCard("1234566");
            }
        });
    }


    /**
     * test case costruttore param 3
     * Verifico che non inserendo nessun carattere mi esca un eccezione
     * @throws CardLenghtException
     */
    @Test
    void constructor_nothing() throws CardLenghtException{
        assertThrows(CardLenghtException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                LoyaltyCard l = new LoyaltyCard("");
            }
        });
    }


    /**
     * test case constructor param 4
     * Verifico che inserendo delle lettere mi esca un eccezione
     * @throws CardLenghtException
     */
    @Test
    void constructor_char() throws CardLenghtException{
        assertThrows(CardLenghtException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                LoyaltyCard l = new LoyaltyCard("weweeeeee");
            }
        });
    }


    /**
     * test case constructor param 5
     * Verifico che inserendo un valore null mi esca una determinata eccezione
     * @throws NullPointerException
     */
    @Test
    void constructor_null() throws NullPointerException{
        assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                LoyaltyCard l = new LoyaltyCard(null);
            }
        });
    }


    /**
     * test case constructor param 6
     * Verifico che inserendo un valore alfanumerico mi esca un eccezione
     * @throws CardLenghtException
     */
    @Test
    void constructor_alphaNumeric() throws CardLenghtException{
        assertThrows(CardLenghtException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                LoyaltyCard l = new LoyaltyCard("123Asd3");
            }
        });
    }

    /**
     * test case checkvalidity 1
     * Mi aspetto true poichè la check digit è valida
     * @throws Exception CardLenghtException
     */
    @org.junit.jupiter.api.Test
    void checkValidity()throws Exception {
        LoyaltyCard l = new LoyaltyCard("9780141026626");
        assertTrue(l.checkValidity());
    }


    /**
     * test case checkvalidity 2
     * Mi aspetto false poichè la check digit è sbagliata
     * @throws Exception CardLenghtException
     */
    @Test
    void checkValidity_wrong_digit() throws Exception{
        LoyaltyCard l = new LoyaltyCard("9780141026624");
        assertFalse(l.checkValidity());
    }


    /**
     * test case checkValidity 3
     * Mi aspetto false poichè passo un codice a 12 cifre
     * @throws CardLenghtException
     */
    @Test
    void checkValidity_min_lenght() throws CardLenghtException{
        LoyaltyCard l = new LoyaltyCard("123456789012");
        assertFalse(l.checkValidity());
    }


    /**
     * test case checkDigit 1
     * Mi aspetto che il risultato della checkDigit sia 6
     * @throws CardLenghtException
     */
    @Test
    void checkDigit_work() throws CardLenghtException{
        LoyaltyCard l = new LoyaltyCard("978014102662");
        assertEquals(6, l.checkDigit());
    }


    /**
     * test case getCardNo 1
     * Mi aspetto che il numero di carta passato sia identico a quello ritornato di getCardNo, poichè a 12 cifre
     * il metodo getCardNomi rtorna il valore senza nessuna modifica
     * @throws CardLenghtException
     */
    @Test
    void getCardNo_min_lenght() throws CardLenghtException{
        LoyaltyCard l = new LoyaltyCard("234567891234");
        assertEquals(l.getNumberCard(), l.getCardNo());
    }


    /**
     * test case getCardNo 2
     * Mi aspetto che il numero carta passato al costruttore sia differente de quello che ritorna con getCardNo, perchè essendo a 13 cifre
     * il metodo elimina l'ultima cifra che da 13 passa a 12
     * @throws CardLenghtException
     */
    @Test
    void getCardNo_max_lenght() throws CardLenghtException{
        LoyaltyCard l = new LoyaltyCard("1234567890123");
        assertNotEquals(l.getNumberCard(), l.getCardNo());
    }


    /**
     * test case getFullCardNo 1
     * Mi aspetto che il numero di carta passato al costruttore sia uguale a quello che viene ritornato dal metodo getFullCardNo
     * poichè il metodo getFullCardNo, essendo a 13 cifre il numero carta, ritorna il valore number card senza modificarne il valore
     * @throws CardLenghtException
     */
    @Test
    void getFullCardNo_max_lenght() throws CardLenghtException{
        LoyaltyCard l = new LoyaltyCard("1234567890123");
        assertEquals(l.getNumberCard(), l.getFullCardNo());
    }


    /**
     * test case getFullCardNo 2
     * Mi aspetto che il numero carta passato al costruttore sia differente da quello ritornato dal metodo getFullCardNo
     * poichè il metodo getFullCardNo, essendo a 12 cifre il numero carta, ritorna il valore number card calcolando il check digit e appendendolo al number card passato
     * @throws CardLenghtException
     */
    @Test
    void getFullCardNo_min_lenght() throws CardLenghtException{
        LoyaltyCard l = new LoyaltyCard("123456789012");
        assertNotEquals(l.getNumberCard(), l.getFullCardNo());
    }


    /**
     * test case isMinLenght 1
     * Verifico che passando un numero carta a 12 cifre esca true
     * @throws CardLenghtException
     */
    @Test
    void isMinLenght_work() throws CardLenghtException{
        LoyaltyCard l = new LoyaltyCard("123456789012");
        assertTrue(l.isMinLenght());
    }

    /**
     * test case isMinLenght 2
     * Verifico che passando un numero carta di 13 cifre mi ritorni false
     * @throws CardLenghtException
     */
    @Test
    void isMinLenght_not_work() throws CardLenghtException{
        LoyaltyCard l = new LoyaltyCard("1234567890123");
        assertFalse(l.isMinLenght());
    }


    /**
     * test case isMaxLenght 1
     * Verifico che passando un numero carta di 13 cifre mi esca true
     * @throws CardLenghtException
     */
    @Test
    void isMaxLenght_work() throws CardLenghtException{
        LoyaltyCard l = new LoyaltyCard("1234567890123");
        assertTrue(l.isMaxLenght());
    }


    /**
     * test case isMaxLenght 2
     * Verifico che passando un numero carta di 12 cifre mi esca false
     * @throws CardLenghtException
     */
    @Test
    void isMaxLenght_not_work() throws CardLenghtException{
        LoyaltyCard l = new LoyaltyCard("123456789012");
        assertFalse(l.isMaxLenght());
    }

    /**
     * test cas setNUmberCard 1
     * Verifico che mettendo un valore minore di quello consentito esca un eccezione
     * @throws CardLenghtException
     */
    @Test
    void setNumberCard_min_lenght() throws CardLenghtException{
        assertThrows(CardLenghtException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                LoyaltyCard l = new LoyaltyCard("1234345678901");
                l.setNumberCard("1234");
            }
        });
    }


    /**
     * test case setNumberCard 2
     * Verifico che mettendo un valore maggiore di quello consentito esca un eccezione
     * @throws CardLenghtException
     */
    @Test
    void setNumberCard_max_lenght() throws CardLenghtException{
        assertThrows(CardLenghtException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                LoyaltyCard l = new LoyaltyCard("1234567890123");
                l.setNumberCard("1234567890123456");
            }
        });
    }


    /**
     * test case setNumberCard 3
     * Verifico che mettendo un valore di caratteri non numerici mi esca un eccezione
     * @throws CardLenghtException
     */
    @Test
    void setNumberCard_characters() throws CardLenghtException{
        assertThrows(CardLenghtException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                LoyaltyCard l = new LoyaltyCard("1234567890123");
                l.setNumberCard("teyuebd");
            }
        });
    }


    /**
     * test case setNumberCard 4
     * Verifico che passando come parametro a setNumberCard null esca una determinata eccezione
     * @throws NullPointerException
     */
    @Test
    void setNumberCard_null() throws NullPointerException{
        assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                LoyaltyCard l  = new LoyaltyCard("1234567890123");
                l.setNumberCard(null);
            }
        });
    }


    /**
     * test case setNumberCard 5
     * Verifico che passando come parametro a setNumberCard un valore alfanumerico esca un eccezione
     * @throws CardLenghtException
     */
    @Test
    void setNumberCard_alphaNumeric() throws CardLenghtException{
        assertThrows(CardLenghtException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                LoyaltyCard l = new LoyaltyCard("1234567890123");
                l.setNumberCard("123retU7");
            }
        });
    }

}