# Loyalty Card

## La classe LoyaltyCard è stata sviluppata per lavorare sui codici EAN13 di un eventuale carta fedeltà.
La classe implementa i seguenti metodi:
1) __checkValidity();__ controlla la validità del check digit
2) __checkDigit();__ calcola tramite un algoritmo il check digit
3) __getCardNo();__ ritorna il numero della carta a 12 cifre
4) __getFullCardNo();__ ritorna il numera della carta a 13 cifre
5) __isMinLenght();__ controlla se il numero della carta è a 12 cifre
6) __isMaxLenght();__ controlla se il numero della carta è a 13 cifre
7) __setNumberCard();__ setter per il numero della carta
8) __isNumeric();__ controlla che il valore del numero della carta sia solo numerico

### E' stata sviluppata una Test suite adeguata per i metodi della classe *LoyaltyCard* e una Custom Exception che estende *Exception*.

## Scelte di programmazione

Ho scelto di di usare una attributo __String__ per il numero di carta, cosi da poter controllare con il metodo ___.lenght();___ che la lunghezza del codice sia valida e rientri tra: 12 cifre senza check digit e 13 cifre, con l'ultima cifra *check digit*.

Per effettuare questo controllo ho scelto di creare 2 variabili d'ambiente di tipo __int__ che contengono le 2 lunghezze consentite, e ho creato 2 metodi appositi per questo controllo.
Inoltre visto che il codice dev'essere solo numerico ho sviluppato un metodo apposito, ___isNumeric();___ ,  per controllare se il valore passato del numero della carta sia solo numerico.

Tutti questi controlli sono stati implementati nel metodo ___setNumberCard();___ che lancia delle Custom Exception se questi controlli non vengono superati.
Per controllare se il valore inserito nel costruttore sia valido richiamo il metodo ___setNumberCard();___ che controlla la validità del valore passato e poi se tutto è corretto assegna il valore a *NumberCard*.

Nel metodo ___checkDigit();___ ho scelto di prendere carattere dopo carattere il numero della carta, grazie al metodo ***charAt(index);*** del tipo __String__ , ed inserirlo come **int** in un ___ArrayList___, cosi da poter calcolare con l'apposito algoritmo il *check digit* tramite gli indici della **Lista Array**. 
