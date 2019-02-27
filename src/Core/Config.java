package Core;

import java.io.*;
import java.util.Properties;


public class Config
   {

       private int nbcase;
       private int nbrcombinaison;
       private int nbrcolors;
       private int nbrtry;
       private boolean devellopermode;


       //Singleton
       private static  /*volatile*/ Config instance = null;



           /**
            * Charge la liste des propriétés contenu dans le fichier spécifié
            *
            * @param Config le fichier contenant les propriétés
            * @return un objet Properties contenant les propriétés du fichier
            */

           public static Properties load (String Config) throws IOException, FileNotFoundException {
               Properties properties = new Properties();

               FileInputStream input = new FileInputStream(Config);
               try {

                   properties.load(input);
                   return properties;

               } finally {

                   input.close();

               }

           }
       private Config()
       {

           try{
               // chargement des propriétés
               Properties prop = Config.load("Config.properties");

               // Affichage des propriété
               // Si la propriété n'existe pas, retourne la valeur par défaut "vide"
               setNbcase(prop.getProperty("nb.case", "vide"));
               setNbrcolors(prop.getProperty("nb.colors", "vide"));
               setNbrcombinaison(prop.getProperty("nb.combinaison", "vide"));
               setNbrtry(prop.getProperty("nb.try", "vide"));
               setDevellopermode(prop.getProperty("developpeur", "false"));
           }

           catch(Exception e){
               e.printStackTrace();
           }
       }

       public static Config getInstance()  {
           if (instance == null)
           {
               instance = new Config();
           }
           System.out.println(instance);
           return instance;
       }
       // faire les getters publics (Setters privates)


        public int getNbcase(){ return  nbcase;}

        private void setNbcase(String Case)
        {
            this.nbcase = Integer.parseInt(Case);

        }

       public int getNbrtry() {
           return nbrtry;
       }

       private void setNbrtry(String Try) {
           nbrtry = Integer.parseInt(Try);
           this.nbrtry = nbrtry;
       }

       public int getNbrcombinaison() {
           return nbrcombinaison;
       }

       private void setNbrcombinaison(String Combinaison) {
           nbrcombinaison = Integer.parseInt(Combinaison);
           this.nbrcombinaison = nbrcombinaison;
       }

       public int getNbrcolors() {
           return nbrcolors;
       }

       private void setNbrcolors(String Colors) {
           nbrcolors = Integer.parseInt(Colors);
           this.nbrcolors = nbrcolors;
       }

       public boolean getDevelloperMode(){ return devellopermode;}

       private void setDevellopermode ( String develloper)
       {
           devellopermode = Boolean.valueOf(develloper).booleanValue() ;

       }
   }
