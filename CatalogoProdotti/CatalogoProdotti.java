package CatalogoProdotti;

import java.util.ArrayList;

public class CatalogoProdotti 
{
   public static void main(String[] args)
   {
      
      // Inserimento utenti
      Utente utente1 = new Utente(1, "davide", "123");
      Utente utente2 = new Utente(2, "simone", "456");
      ArrayList<Utente>utenti = new ArrayList<>();
      utenti.add(utente1);
      utenti.add(utente2);

      // inserimento prodotti
      Prodotti prodotto1 = new Prodotti(1, "yogurt", 10.20);
      Prodotti prodotto2 = new Prodotti(2, "Magnum", 34.50);
      ArrayList<Prodotti>prodotti = new ArrayList<>();
      prodotti.add(prodotto1);
      prodotti.add(prodotto2);

      // Inserimento Utente Admin
      Admin admin1 = new Admin(1, "admin", "admin");
      ArrayList<Admin>admin = new ArrayList<>();
      admin.add(admin1);

      // istanza modulo dati
      ModuloDatiUtente moduloDatiUtente = new ModuloDatiUtente(utenti, prodotti);

      // Visualizzo il menu degli utenti
      moduloDatiUtente.menuAccesso();
   }
}
