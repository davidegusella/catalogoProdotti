package CatalogoProdotti;

public class Utente 
{
   // Attributi utente
   int id;
   String username;
   String password;

   // Costruttore
   Utente(int id, String username, String password)
   {
      this.id = id;
      this.username = username;
      this.password = password;
   }
}