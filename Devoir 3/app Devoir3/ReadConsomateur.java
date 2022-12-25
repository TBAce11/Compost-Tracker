import java.util.Scanner; // import the Scanner class 
import java.util.ArrayList; // import the ArrayList clas
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

import java.io.FileWriter;
import java.io.IOException;


public class ReadConsomateur {
    

    public static void main(String[] args) throws IOException {
        
    }



    public static ArrayList<Consomateur> read() throws FileNotFoundException {
        
        ArrayList<Consomateur> ConsomateurTab = new ArrayList<>();
        File myObj = new File("database/Consomateur.txt");
        Scanner myReader = new Scanner(myObj);
        
        while (myReader.hasNextLine()) {
            String ligne = myReader.nextLine();
            String[] myArray = ligne.split(" ");
            ConsomateurTab.add(new Consomateur (Integer.parseInt(myArray[0]),myArray[1],myArray[2],myArray[3],myArray[4],myArray[5],myArray[6],myArray[7],myArray[8]));
            
            
        }
        myReader.close();
        return ConsomateurTab;
    }
    

    public static ArrayList<Consomateur> getConsomateursDatabase() throws FileNotFoundException {
        
        return read();
    }  
   
    //fonction qui modifie le fichier de la database
    // modifie les indormation de lutilisateur qui a pour numero "id"
    //"index" corespond a quelle parrametre on veux modifier index 0= id 1=nom...
    //et "mot" contient le mot que on va placer a la place du mot que on va remplacer
    public static void modifConsomateur(int id,String mot,int index) throws IOException {
       

        File myObj = new File("database/Consomateur.txt");
        Scanner myReader = new Scanner(myObj);
        
        String text="";
        while (myReader.hasNextLine()) {
            String ligne = myReader.nextLine();
            String[] myArray = ligne.split(" ");
            if(id==Integer.parseInt(myArray[0])){
                myArray [index]=mot;
            }

            text=text+myArray[0]+" "+myArray[1]+" "+myArray[2]+" "+myArray[3]+" "+myArray[4]+" "+myArray[5]+" "+myArray[6]+" "+myArray[7]+" "+myArray[8]+"\n";
            
        }
        FileWriter myWriter = new FileWriter("database/Consomateur.txt");
        myWriter.write(text);
        myReader.close();
        myWriter.close();
        
    }  

    //ajoute les info dun Consomateur dans la database
    
    public static void addConsomateur(int id,String Nom,String Adresse,String Mdp,String Email,String Telephone,Activite activites,String TypeDechet,String capacite) throws IOException {
        File myObj = new File("database/Consomateur.txt");
        Scanner myReader = new Scanner(myObj);
        
        String text="";
        while (myReader.hasNextLine()) {
            String ligne = myReader.nextLine();
            String[] myArray = ligne.split(" ");
            
            text=text+myArray[0]+" "+myArray[1]+" "+myArray[2]+" "+myArray[3]+" "+myArray[4]+" "+myArray[5]+" "+myArray[6]+" "+myArray[7]+" "+myArray[8]+"\n";
            
        }
        text=text+id+" "+Nom+" "+Adresse+" "+Telephone+" "+Mdp+" "+Email+" "+Telephone+" "+activites+" "+TypeDechet+" "+capacite+"\n";
        FileWriter myWriter = new FileWriter("database/Consomateur.txt");
        myWriter.write(text);
        myReader.close();
        myWriter.close();
        
    } 
}
