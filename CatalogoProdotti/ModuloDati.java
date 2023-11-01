package CatalogoProdotti;
import java.util.ArrayList;
import java.util.Scanner;

public class ModuloDati
{
   // Attributi - Strutture dati contenenti i dati
   ArrayList<Utente> utenti;
   ArrayList<Prodotti> prodotti;
   ArrayList<Admin> admin;

   // Allocazione oggetti utili
   Scanner input;

   // Costruttore
   ModuloDati(ArrayList<Utente> utenti, ArrayList<Prodotti> prodotti, ArrayList<Admin> admin)
   {
      // Inizializzazione
      this.utenti = utenti;
      this.prodotti = prodotti;
      this.admin = admin;
      input = new Scanner(System.in);
   }

   /**
    * Metodo per effettuare il login
    */
   public void login()
   {
      int scelta = 0;
      do
      {
         System.out.println();
         System.out.println("Menu Login:");
         System.out.println("1. Amministratore");
         System.out.println("2. Utente");
         System.out.println("3. Esci");

         // Inserimento scelta
         System.out.print("Inserisci la tua scelta: ");
         scelta = input.nextInt();

         // Esegue l'azione corrispondente alla scelta
         switch (scelta) 
         {
            case 1:
                  menuAccessoAdmin();
               break;

            case 2:
                  menuAccessoUtente();
               break;

            case 3:
                  System.exit(0);
               break;

            default:
                  System.out.println("Scelta non valida.");
         }

      }while(scelta != 3);
   }

   // METODI PER L'UTENTE ****************************************************


   /**
    * Metodo in grado di mostrare il menu
   */
   public void menuAccessoUtente()
   {
      int scelta = 0;
      do
      {
         System.out.println();
         System.out.println("Menu Principale Utente:");
         System.out.println("1. Accedi come utente");
         System.out.println("2. Registrazione nuovo utente");
         System.out.println("3. Esci");

         // Inserimento scelta
         System.out.print("Inserisci la tua scelta: ");
         scelta = input.nextInt();

         // Appoggio per controllare il risultato delle funzioni
         boolean flag = false;

         // Esegue l'azione corrispondente alla scelta
         switch (scelta) 
         {
            case 1:
               flag = accessoUtente();

               // Se l'accesso è avvenuto correttamente, l'utente visualizza il menu con le operazioni
               if(flag)
               {
                  System.out.println("Accesso effettuato con successo.");
                  menuUtente();
               }
               else
               {
                  System.out.println("Username o Password errati");
               }
               break;

            case 2:
               flag = inserimentoNuovoUtente();

               // Controllo se l'inserimento è avvenuto correttamente
               if(flag)
               {
                  System.out.println("Inserimento nuovo utente efettuato con successo");
               }
               else
               {
                  System.out.println("Username o Password già esistenti");
               }
               break;

            case 3:
                  // esegui la funzione login che si trova nel modulo dati
                  login();
               break;

            default:
                  System.out.println("Scelta non valida.");
         }

      }while(scelta != 3);
   }

   /**
    * Metodo in grado di inserire un nuovo utente
   * @return
   * Risultato funzione: "false" operazione fallita, "true" operazione riuscita
   */
   public boolean inserimentoNuovoUtente()
   {
      // Inizializzazione pessimistica
      boolean ris = false;

      // Flag di controllo, inizializzazione ottimistica
      boolean check = false;

      // Inserimento dati utente
      System.out.print("Inserisci il tuo username: ");
      String username = input.next();
      System.out.print("Inserisci la tua password: ");
      String password = input.next();

      // Controllo credenziali utente
      check = controlloCredenzialiUtente(username, password);
      if(check == false)
      {
         // Aggiorno lo stato del flag
         ris = true;
         Utente utente = new Utente(username, password);
         utenti.add(utente);
      }
      return ris;
   }

   /**
    * Metodo in grado di controllo le credenziali dell'utente
   * @param username
   * @param password
   * @return
   Risultato funzione: "false" credenziali errate, "true" credenziali corrette
   */
   public boolean controlloCredenzialiUtente(String username, String password)
   {
      // Inizializzazione pessimistica
      boolean flag = false;
      boolean flagCiclo = false;

      // Verifica se l'utente esiste
      for (int i = 0; i < utenti.size() && flagCiclo == false; i++)
      {
         if ((username.equals(utenti.get(i).username)) && (password.equals(utenti.get(i).password)))
         {
            // Aggiorno flag ottimizzazione ciclo
            flagCiclo = true;

            // Aggiorno il risultato
            flag = true;
         }
      }
      return flag;
   }

   /**
    * Metodo in grado di eseguire l'accesso
   */
   public boolean accessoUtente()
   {
      System.out.print("Inserisci il tuo username: ");
      String username = input.next();
      System.out.print("Inserisci la tua password: ");
      String password = input.next();

      boolean flag = controlloCredenzialiUtente(username, password);
      return flag;
   }

   /**
    * Metodo in grado di mostrare il menu dell'utente
   */
   public void menuUtente()
   {
      int scelta = 0;
      do
      {
         System.out.println();
         System.out.println("Menu Utente:");
         System.out.println("1. Visualizza prodotti");
         System.out.println("2. Esci");

         // Inserimento scelta
         System.out.print("Inserisci la tua scelta: ");
         scelta = input.nextInt();

         // Esegue l'azione corrispondente alla scelta
         switch (scelta) 
         {
            case 1:
                  visualizzaProdotti(prodotti);
               break;

            case 2:
                  menuAccessoUtente();
               break;

            default:
                  System.out.println("Scelta non valida.");
         }

      }while(scelta != 2);
   }

   // ADMIN *******************************************************************


   /**
    * Metodo in grado di mostrare il menu
   */
   public void menuAccessoAdmin()
   {
      int scelta = 0;
      do
      {
         System.out.println();
         System.out.println("Menu Principale Admin:");
         System.out.println("1. Accedi come Amministratore");
         System.out.println("2. Esci");

         // Inserimento scelta
         System.out.print("Inserisci la tua scelta: ");
         scelta = input.nextInt();

         // Appoggio per controllare il risultato delle funzioni
         boolean flag = false;

         // Esegue l'azione corrispondente alla scelta
         switch (scelta) 
         {
            case 1:
                  flag = accessoAdmin();

                  // Se l'accesso è avvenuto correttamente, l'utente visualizza il menu con le operazioni
                  if(flag)
                  {
                     System.out.println("Accesso effettuato con successo.");
                     menuAdmin();
                  }
                  else
                  {
                     System.out.println("Username o Password errati");
                  }
               break;

            case 2:
                  login();
               break;

            default:
                  System.out.println("Scelta non valida.");
         }

      }while(scelta != 3);
   }

   /**
    * Metodo in grado di controllo le credenziali dell'admin
    * @param username
    * @param password
    * @return
    Risultato funzione: "false" credenziali errate, "true" credenziali corrette
   */
   public boolean controlloCredenzialiAdmin(String username, String password)
   {
      // Inizializzazione pessimistica
      boolean flag = false;
      boolean flagCiclo = false;

      // Verifica se l'utente esiste
      for (int i = 0; i < admin.size() && flagCiclo == false; i++)
      {
         if ((username.equals(admin.get(i).username)) && (password.equals(admin.get(i).password)))
         {
            // Aggiorno flag ottimizzazione ciclo
            flagCiclo = true;

            // Aggiorno il risultato
            flag = true;
         }
      }
      return flag;
   }

   /**
    * Metodo in grado di eseguire l'accesso
    */
   public boolean accessoAdmin()
   {
      System.out.print("Inserisci il tuo username: ");
      String username = input.next();
      System.out.print("Inserisci la tua password: ");
      String password = input.next();

      boolean flag = controlloCredenzialiAdmin(username, password);
      return flag;
   }

   /**
    * Metodo in grado di mostrare il menu dell'admin
    */
   public void menuAdmin()
   {
      int scelta = 0;
      do
      {
         System.out.println();
         System.out.println("Menu Admin:");
         System.out.println("1. Visualizza prodotti");
         System.out.println("2. Registrazione nuovi prodotti");
         System.out.println("3. Eliminazione prodotti");
         System.out.println("4. Modifica prodotti");
         System.out.println("5. Cerca prodotto");
         System.out.println("6. Esci");

         // Inserimento scelta
         System.out.print("Inserisci la tua scelta: ");
         scelta = input.nextInt();

         // Appoggio per controllare il risultato delle funzioni
         boolean flag = false;

         // Esegue l'azione corrispondente alla scelta
         switch (scelta) 
         {
            case 1:
                  visualizzaProdotti(prodotti);
               break;

            case 2:
                  flag = inserimentoNuovoProdotto();
                  if(flag)
                  {
                     System.out.println("Inserimento nuovo prodotto efettuato con successo");
                  }
                  else
                  {
                     System.out.println("Prodotto già esistente");
                  }
               break;

            case 3:
                  flag = eliminaProdotto();
                  if(flag)
                  {
                     System.out.println("Eliminazione prodotto efettuata con successo");
                  }
                  else
                  {
                     System.out.println("Errore! Elimina un prodotto esistente");
                  }
               break;

            case 4:
                  flag = modificaProdotto();
                  if(flag)
                  {
                     System.out.println("Modifica prodotto effettuata con successo");
                  }
                  else
                  {
                     System.out.println("Errore! Modifica un prodotto esistente");
                  }
               break;

            case 5:
                  cercaProdotto(prodotti);
               break;

            case 6:
                  menuAccessoAdmin();

            default:
                  System.out.println("Scelta non valida.");
         }

      }while(scelta != 6);
   }


   // PRODOTTI ****************************************************************

   /**
    * Metodo in grado di inserire un nuovo prodotto
    * @return
    * Risultato funzione: "false" operazione fallita, "true" operazione riuscita
    */
   public boolean inserimentoNuovoProdotto()
   {
      // Inizializzazione pessimistica
      boolean ris = false;

      // Inserimento dati
      System.out.print("Inserisci il nome del prodotto: ");
      String nome = input.next();
      System.out.print("Inserisci il prezzo del prodotto: ");
      double prezzo = input.nextDouble();
      System.out.print("Inserisci la quantità del prodotto: ");
      int quantita = input.nextInt();

      Prodotti prodotto = new Prodotti(nome, prezzo, quantita);
      prodotti.add(prodotto);

      // Aggiorno lo stato del flag
      ris = true;

      return ris;
   }

   /**
    * Metodo in grado di visualizzare i prodotti registrati
    * @param prodotti
    * ArrayList dei prodotti
    */
   public void visualizzaProdotti(ArrayList<Prodotti> prodotti)
   {
      for (Prodotti p : prodotti) 
      {
         System.out.println("NOME: " + p.nome + " PREZZO: " + p.prezzo + " euro" + " QUANTITA: " + p.quantita);
      }
   }

   /**
    * Metodo in grado di controllare se il prodotto esiste già
   * @param nome
   * Nome Prodotto
   * @return
   * Risultato funzione: "false" Prodotto no esistente, "true" Prodotto esistente
   */
   public boolean controlloProdotto(String nome)
   {
      // Inizializzazione pessimistica
      boolean flag = false;

      // Flag ottimizzazione ciclo
      boolean flagCiclo = false;

      // Verifica se il prodotto esiste
      for (int i = 0; i < prodotti.size() && flagCiclo == false; i++)
      {
         if (nome.equalsIgnoreCase(prodotti.get(i).nome))
         {
            // Aggiorno flag ottimizzazione ciclo
            flagCiclo = true;

            // Aggiorno il risultato
            flag = true;
         }
      }
      return flag;
   }

   /**
    * Metodo in grado di eliminare un prodotto
    * @return
    * Risultato funzione: "false" operazione fallita, "true" operazione riuscita
    */
   public boolean eliminaProdotto()
   {
      // Inizializzazione pessimistica
      boolean ris = false;

      // Flag di controllo, inizializzazione ottimistica
      boolean check = false;

      // Inserimento dati
      System.out.print("Nome prodotto da eliminare: ");
      String nome = input.next();

      // Controllo se il prodotto esiste già
      check = controlloProdotto(nome);
      if(check)
      {
         // Rimuovo il prodotto
         for (int i = 0; i < prodotti.size(); i++)
         {
            if (nome.equalsIgnoreCase(prodotti.get(i).nome))
            {
               prodotti.remove(i);
            }
         }

         // Aggiorno lo stato del flag
         ris = true;
      }
      return ris;
   }

   /**
    * Metodo in grado di modificare un prodotto
    * @return
    * Risultato funzione: "false" operazione fallita, "true" operazione riuscita
    */
   public boolean modificaProdotto()
   {
      // Inizializzazione pessimistica
      boolean ris = false;

      // Flag di controllo, inizializzazione ottimistica
      boolean check = false;

      // Inserimento dati
      System.out.print("Nome prodotto da modificare: ");
      String nome = input.next();

      // Controllo se il prodotto esiste già
      check = controlloProdotto(nome);
      if(check)
      {
         // Cerco indice prodotto da eliminare
         for (int i = 0; i < prodotti.size(); i++)
         {
            if (nome.equalsIgnoreCase(prodotti.get(i).nome))
            {
               System.out.print("Inserisci nuovo nome prodotto: ");
               String nuovoNome = input.next();
               System.out.print("Inserisci nuovo prezzo prodotto: ");
               double nuovoPrezzo = input.nextDouble();
               System.out.print("Inserisci nuova quantità prodotto: ");
               int nuovaQuantita = input.nextInt();

               Prodotti prodotto = new Prodotti(nuovoNome, nuovoPrezzo, nuovaQuantita);
               prodotti.set(i, prodotto);

               // Aggiorno lo stato del flag
               ris = true;
            }
         }
      }
      return ris;
   }

   /**
    * Metodo in grado di cercare un prodotto
    * @param prodotti
    * ArrayList dei prodotti
    */
   public void cercaProdotto(ArrayList<Prodotti> prodotti)
   {
      // Flag ottimizzazione ciclo, inizializzazione pessimistica
      boolean flagCiclo = false;

      System.out.print("Inserisci il nome del prodotto da cercare: ");
      String nome = input.next();

      for (int i = 0; i < prodotti.size(); i++)
      {
         if (nome.equalsIgnoreCase(prodotti.get(i).nome))
         {
            // Stampo i dati del prodotto
            System.out.println("NOME: " + prodotti.get(i).nome + " PREZZO: " + prodotti.get(i).prezzo + " euro" + " QUANTITA: " + prodotti.get(i).quantita);

            // Aggiorno flag ottimizzazione ciclo
            flagCiclo = true;
         }
      }

      if (flagCiclo == false) 
      {
         System.out.println("Prodotto non trovato");
      }
   }
}
