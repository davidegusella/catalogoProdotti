package CatalogoProdotti;

public class Utente 
{
   // Attributi utente
   // identificativo univoco dell'utente
   int id; 
   String username;
   String password;

   // Utente livello "0" di default
   int livello;

   // Costruttore
   Utente(int id, String username, String password)
   {
      this.id = id;
      this.username = username;
      this.password = password;
      livello = 0;
   }
}