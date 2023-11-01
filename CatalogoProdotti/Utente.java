package CatalogoProdotti;
import java.util.Scanner;

public class Utente
{
   // Attributi utente
   String username;
   String password;

   // Allocazione oggetti utili
   Scanner input;
   ModuloDati moduloDati;
   Prodotti prodotto;

   // Costruttore
   Utente(String username, String password)
   {
      this.username = username;
      this.password = password;

      input = new Scanner(System.in);
   }
}