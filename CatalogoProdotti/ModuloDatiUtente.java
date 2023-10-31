package CatalogoProdotti;

import java.util.ArrayList;
import java.util.Scanner;

public class ModuloDatiUtente
{
   // Attributi
   ArrayList<Utente> utenti;
   ArrayList<Prodotti> prodotti;
   ArrayList<Admin> admin;
   Scanner input;

   // Costruttore
   ModuloDatiUtente(ArrayList<Utente> utenti, ArrayList<Prodotti> prodotti)
   {
      this.utenti = utenti;
      this.prodotti = prodotti;
      input = new Scanner(System.in);
   }


   /**
    * Metodo in grado di mostrare il menu principale
    */
   public void menuAccesso()
   {
      int scelta = 0;
      do
      {
         System.out.println();
         System.out.println("Menu Principale:");
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
                  flag = accedi();

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
                  if(flag)
                  {
                     System.out.println("Inserimento nuovo utente efettuato con successo");
                  }
                  else
                  {
                     System.out.println("Username o Password errati");
                  }
               break;

            case 3:
                  System.exit(0);
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
      check = controlloCredenziali(username, password);
      if(check == false)
      {
         // Aggiorno lo stato del flag
         ris = true;
         Utente utente = new Utente(1, username, password);
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
   public boolean controlloCredenziali(String username, String password)
   {
      // Inizializzazione pessimistica
      boolean flag = false;
      boolean flagCiclo = false;

      // Verifica se l'utente esiste
      for (int i = 0; i < utenti.size() && flagCiclo == false; i++)
      {
         if (username.equals(utenti.get(i).username))
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
   public boolean accedi()
   {
      System.out.print("Inserisci il tuo username: ");
      String username = input.next();
      System.out.print("Inserisci la tua password: ");
      String password = input.next();

      boolean flag = controlloCredenziali(username, password);
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
                  menuAccesso();
               break;

            default:
                  System.out.println("Scelta non valida.");
         }

      }while(scelta != 2);
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
         System.out.println("ID: " + p.id + " NOME: " + p.nome + " PREZZO: " + p.prezzo + " euro");
      }
   }
}
