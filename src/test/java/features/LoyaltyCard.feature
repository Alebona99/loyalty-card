Feature: Check validity of Loyalty Card (EAN13)
  A User check the validity of his Loyalty Card
  and calculate the check digit of the Card
  The Code of Loyalty Card is an EAN13 code

  Scenario Outline: User Check digit of Loyalty Card
    Given user have a Loyalty Card
    When insert the number of Card "<numberCard>"
    Then the user see the <checkDigitNumber>

    Examples:
    | numberCard   | checkDigitNumber |
    | 978014102662 | 6                |
    | 123789456738 | 1                |
    | 234098354772 | 6                |
    | 345829048564 | 4                |
    | adrsf4562282 |                  |
    |              |                  |
    | asd          |                  |
    | 234566       |                  |
    | null         |                  |



  Scenario Outline: User check validity of Loyalty Card
    Given user have a Loyalty Card
    When insert the number of Card "<numberCard>"
    Then the user control and see if the card is valid

    Examples:
    | numberCard    |
    | 9780141026626 |
    | 1237894567381 |
    | 1324637489905 |
    | 12334444444   |
    | adsfeg2345    |
    |               |
    | 2344          |
    | null          |
    | 2345789656566 |


