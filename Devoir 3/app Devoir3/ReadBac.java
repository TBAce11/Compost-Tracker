import java.util.Scanner; // import the Scanner class 
import java.util.ArrayList; // import the ArrayList clas
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

import java.io.FileWriter;
import java.io.IOException;


public class ReadBac {
    

    public static void main(String[] args) throws IOException {
        
        
    }



    public static ArrayList<Bac> read() throws FileNotFoundException {
        
        ArrayList<Bac> BacTab = new ArrayList<>();
        File myObj = new File("database/Bac.txt");
        Scanner myReader = new Scanner(myObj);
       
        while (myReader.hasNextLine()) {
            String ligne = myReader.nextLine();
            String[] myArray = ligne.split(" ");
            BacTab.add(new Bac (Integer.parseInt(myArray[0]),myArray[1],myArray[2],myArray[3]));
            
            
        }
        myReader.close();
        return BacTab;
    }
    

    public static ArrayList<Bac> getBacsDatabase()  {
        
        try {
            return read();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }  
   
    //fonction qui modifie le fichier de la database
    // modifie les indormation de lutilisateur qui a pour numero "id"
    //"index" corespond a quelle parrametre on veux modifier index 0= id 1=nom...
    //et "mot" contient le mot que on va placer a la place du mot que on va remplacer
    public static void modifBac(int id,String mot,int index) throws IOException {
       

        File myObj = new File("database/Bac.txt");
        Scanner myReader = new Scanner(myObj);
        
        String text="";
        while (myReader.hasNextLine()) {
            String ligne = myReader.nextLine();
            String[] myArray = ligne.split(" ");
            if(id==Integer.parseInt(myArray[0])){
                myArray [index]=mot;
            }

            text=text+myArray[0]+" "+myArray[1]+" "+myArray[2]+" "+myArray[3]+"\n";
            
        }
        FileWriter myWriter = new FileWriter("database/Bac.txt");
        myWriter.write(text);
        myReader.close();
        myWriter.close();
        
    }  

    //ajoute les info dun Bac dans la database
    
    public static void addBac(int id,String Adresse,String DateEmission,String type) throws IOException {
        File myObj = new File("database/Bac.txt");
        Scanner myReader = new Scanner(myObj);
        
        String text="";
        while (myReader.hasNextLine()) {
            String ligne = myReader.nextLine();
            String[] myArray = ligne.split(" ");
            
            text=text+myArray[0]+" "+myArray[1]+" "+myArray[2]+" "+myArray[3]+"\n";
            
        }
        text=text+id+" "+Adresse+" "+DateEmission+" "+type+"\n";
        FileWriter myWriter = new FileWriter("database/Bac.txt");
        myWriter.write(text);
        myReader.close();
        myWriter.close();
        
    } 
}
