import java.util.Scanner; // import the Scanner class
import java.util.ArrayList; // import the ArrayList clas
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

import java.io.FileWriter;
import java.io.IOException;

public class ReadActivite {
    public static void main(String[] args) throws IOException {
        
    }

    /**Fonction pour lire le fichier database Activite
     * @return
     * @throws FileNotFoundException
     */
    public static ArrayList<Activite> read() throws FileNotFoundException {
        ArrayList<Activite> activiteTab = new ArrayList<>();
        File myObj = new File("database/Activite.txt");
        Scanner myReader = new Scanner(myObj);
        
        while (myReader.hasNextLine()) {
            String ligne = myReader.nextLine();
            String[] myArray = ligne.split(" ");
            activiteTab.add(new Activite(myArray[0],myArray[1],Integer.parseInt(myArray[2])));
            
            
        }
        myReader.close();
        return activiteTab;
    }
    

    public static ArrayList<Activite> getActiviteDatabase() throws FileNotFoundException {
        return read();
    }  
   
    //fonction qui modifie le fichier de la database
    // modifie les indormation de lactivite qui a pour nom "nom"
    //"index" corespond a quelle parrametre on veux modifier index 0= id 1=nom...
    //et "mot" contient le mot que on va placer a la place du mot que on va remplacer
   
    /**Fonction pour modifier les propriétés d'une activité
     * @param nom
     * @param mot
     * @param index
     * @throws IOException
     */
    public static void modifActivite(String nom,String mot,int index) throws IOException {
        File myObj = new File("database/Activite.txt");
        Scanner myReader = new Scanner(myObj);
        
        String text="";
        while (myReader.hasNextLine()) {
            String ligne = myReader.nextLine();
            String[] myArray = ligne.split(" ");
            if(nom.equals(myArray[0])){
                myArray[index]=mot;
            }

            text=text+myArray[0]+" "+myArray[1]+" "+myArray[2]+"\n";
            
        }
        FileWriter myWriter = new FileWriter("database/Activite.txt");
        myWriter.write(text);
        myReader.close();
        myWriter.close();
        
    }  

    //ajoute les info dune activite dans la database
    
    /**Fonction pour rajouter une activité à la database. 
     * @param nom
     * @param typeDechet
     * @param note
     * @throws IOException
     */
    public static void addActivite(String nom, String typeDechet, int note) throws IOException {
        File myObj = new File("database/Activite.txt");
        Scanner myReader = new Scanner(myObj);
        
        String text="";
        while (myReader.hasNextLine()) {
            String ligne = myReader.nextLine();
            String[] myArray = ligne.split(" ");
            
            text=text+myArray[0]+" "+myArray[1]+" "+myArray[2]+"\n";
            
        }
        text=text+nom+" "+typeDechet+" "+Integer.toString(note);
        FileWriter myWriter = new FileWriter("database/Activite.txt");
        myWriter.write(text);
        myReader.close();
        myWriter.close();
        
    } 

    /**Fonction pour supprimer une activité de la database.
     * @param nom
     */
    public static void suppActivite(String nom)  {
        File myObj = new File("database/Activite.txt");
        try (Scanner myReader = new Scanner(myObj)) {
            String text="";
            while (myReader.hasNextLine()) {
                String ligne = myReader.nextLine();
                String[] myArray = ligne.split(" ");
                if(nom.compareTo(myArray[0])==0){
                    
                }else{text=text+myArray[0]+" "+myArray[1]+" "+myArray[2]+"\n";}
                
            }
            FileWriter myWriter = new FileWriter("database/Activite.txt");
            myWriter.write(text);
            myReader.close();
            myWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }  
}