package CatalogoProdotti;
import java.util.ArrayList;

public class CatalogoProdotti 
{
   public static void main(String[] args)
   {
      // Inserimento utenti
      Utente utente1 = new Utente("davide", "123");
      Utente utente2 = new Utente("simone", "456");
      ArrayList<Utente>utenti = new ArrayList<>();
      utenti.add(utente1);
      utenti.add(utente2);

      // inserimento prodotti
      Prodotti prodotto1 = new Prodotti("yogurt", 10.20, 20);
      Prodotti prodotto2 = new Prodotti("magnum", 34.50, 10);
      ArrayList<Prodotti>prodotti = new ArrayList<>();
      prodotti.add(prodotto1);
      prodotti.add(prodotto2);

      // Inserimento Utente Admin
      Admin admin1 = new Admin("admin", "admin");
      ArrayList<Admin>admin = new ArrayList<>();
      admin.add(admin1);

      // istanza modulo dati
      ModuloDati moduloDati = new ModuloDati(utenti, prodotti, admin);
      

      // Visualizzo il menu degli utenti/admin
      moduloDati.login();
   }
}
