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

      // Creo dei prodotti
      Prodotti prodotto1 = new Prodotti(1, "yogurt", 10.20);
      Prodotti prodotto2 = new Prodotti(2, "Magnum", 34.50);
      ArrayList<Prodotti>prodotti = new ArrayList<>();
      prodotti.add(prodotto1);
      prodotti.add(prodotto2);

      // istanza modulo dati
      ModuloDati moduloDati = new ModuloDati(utenti, prodotti);

      // Visualizzo il menu degli utenti
      moduloDati.menuAccesso();
   }
}
