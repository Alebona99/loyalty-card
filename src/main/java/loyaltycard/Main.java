package loyaltycard;

public class Main {

    public static void main(String[] args) throws Exception{

        LoyaltyCard l = new LoyaltyCard(123456780912300L);

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
