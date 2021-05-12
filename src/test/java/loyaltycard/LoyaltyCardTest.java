package loyaltycard;

import customexception.CardLenghtException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe di Test per la classe LoyaltyCard
 */
class LoyaltyCardTest {

    /**
     * test case costruttore param 1
     * Verifico che mettendo un numero maggiore di quello consentito esca un eccezione
     * @throws CardLenghtException
     */
    @Test
    void constructor_max_lenght() throws CardLenghtException {
        assertThrows(CardLenghtException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                LoyaltyCard l = new LoyaltyCard(123456789012345L);
            }
        });

    }


    /**
     * test case costruttore param 2
     * Verifico che mettendo un valore minore di quello consentito esca un eccezione
     * @throws CardLenghtException
     */
    @Test
    void constructor_min_lenght() throws CardLenghtException{
        assertThrows(CardLenghtException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                LoyaltyCard l = new LoyaltyCard(1234566L);
            }
        });
    }


    /**
     * test case costruttore param 3
     * Verifico che mettendo 0 mi esca un eccezione
     * @throws CardLenghtException
     */
    @Test
    void constructor_nothing() throws CardLenghtException{
        assertThrows(CardLenghtException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                LoyaltyCard l = new LoyaltyCard(0L);
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
        LoyaltyCard l = new LoyaltyCard(9780141026626L);
        assertTrue(l.checkValidity());
    }


    /**
     * test case checkvalidity 2
     * Mi aspetto false poichè la check digit è sbagliata
     * @throws Exception CardLenghtException
     */
    @Test
    void checkValidity_wrong_digit() throws Exception{
        LoyaltyCard l = new LoyaltyCard(9780141026624L);
        assertFalse(l.checkValidity());
    }



    @Test
    void checkDigit() {
    }

    @org.junit.jupiter.api.Test
    void getCardNo() {
    }

    @org.junit.jupiter.api.Test
    void getFullCardNo() {
    }

    @org.junit.jupiter.api.Test
    void isMinLenght() {
    }

    @org.junit.jupiter.api.Test
    void isMaxLenght() {
    }

    @org.junit.jupiter.api.Test
    void getNumberCard() {
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
                LoyaltyCard l = new LoyaltyCard();
                l.setNumberCard(1234L);
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
                LoyaltyCard l = new LoyaltyCard();
                l.setNumberCard(1234567890123456L);
            }
        });
    }
}