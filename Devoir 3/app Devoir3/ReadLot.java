import java.util.Scanner; // import the Scanner class 
import java.util.ArrayList; // import the ArrayList clas
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

import java.io.FileWriter;
import java.io.IOException;


public class ReadLot {
    

    public static void main(String[] args) throws IOException {
        
        
    }



    public static ArrayList<Lot> read() throws FileNotFoundException {
        
        ArrayList<Lot> LotTab = new ArrayList<>();
        File myObj = new File("database/Lot.txt");
        Scanner myReader = new Scanner(myObj);
       
        while (myReader.hasNextLine()) {
            String ligne = myReader.nextLine();
            String[] myArray = ligne.split(" ");
            LotTab.add(new Lot (Integer.parseInt(myArray[0]),myArray[1],myArray[2],myArray[3],myArray[4],Integer.parseInt(myArray[5])));
            
            
        }
        myReader.close();
        return LotTab;
    }
    

    
    public static ArrayList<Lot> getLotsDatabase()  {
        
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
    public static void modifLot(int id,String mot,int index) throws IOException {
       

        File myObj = new File("database/Lot.txt");
        Scanner myReader = new Scanner(myObj);
        
        String text="";
        while (myReader.hasNextLine()) {
            String ligne = myReader.nextLine();
            String[] myArray = ligne.split(" ");
            if(id==Integer.parseInt(myArray[0])){
                myArray [index]=mot;
            }

            text=text+myArray[0]+" "+myArray[1]+" "+myArray[2]+" "+myArray[3]+" "+myArray[4]+" "+myArray[5]+"\n";
            
        }
        FileWriter myWriter = new FileWriter("database/Lot.txt");
        myWriter.write(text);
        myReader.close();
        myWriter.close();
        
    }  

    //ajoute les info dun Lot dans la database
    
    public static void addLot (int id,String type,String dateRamassage,String dateLivraison, String activites,Integer ConsomateurId) throws IOException {
        File myObj = new File("database/Lot.txt");
        Scanner myReader = new Scanner(myObj);
        
        String text="";
        while (myReader.hasNextLine()) {
            String ligne = myReader.nextLine();
            String[] myArray = ligne.split(" ");
            
            text=text+myArray[0]+" "+myArray[1]+" "+myArray[2]+" "+myArray[3]+" "+myArray[4]+" "+myArray[5]+"\n";
            
        }
        text=text+id+" "+type+" "+dateRamassage+" "+dateLivraison+" "+activites+" "+ConsomateurId+"\n";
        FileWriter myWriter = new FileWriter("database/Lot.txt");
        myWriter.write(text);
        myReader.close();
        myWriter.close();
        
    } 
}
