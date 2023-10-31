package CatalogoProdotti;

public class Admin 
{
   // Attributi Admin
   // identificativo univoco dell'admin
   int id; 
   String username;
   String password;

   // Admin livello "1" di default
   int livello;

   // Costruttore
   Admin(int id, String username, String password)
   {
      this.id = id;
      this.username = username;
      this.password = password;
      livello = 1;
   }
}