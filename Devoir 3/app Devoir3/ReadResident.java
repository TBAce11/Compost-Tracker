import java.util.Scanner; // import the Scanner class 
import java.util.ArrayList; // import the ArrayList clas
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

import java.io.FileWriter;
import java.io.IOException;


public class ReadResident {
    

    public static void main(String[] args) throws IOException {
       
       
    }



    public static ArrayList<Resident> read() throws FileNotFoundException {
        
        ArrayList<Resident> ResidentTab = new ArrayList<>();
        File myObj = new File("database/Resident.txt");
        Scanner myReader = new Scanner(myObj);
        
        while (myReader.hasNextLine()) {
            String ligne = myReader.nextLine();
            String[] myArray = ligne.split(" ");
            ResidentTab.add(new Resident (Integer.parseInt(myArray[0]),myArray[1],myArray[2],myArray[3],myArray[4],myArray[5],myArray[6]));
             
            
        }
        myReader.close();
        return ResidentTab;
    }
    

    public static ArrayList<Resident> getResidentsDatabase() {
        
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
    //"index" corespond a quelle parrametre on veux modifier index 0= id 1=nom 2 =prenom 3=telephone 4=Mdp 5=email 6=adresse
    //et "mot" contient le mot que on va placer a la place du mot que on va remplacer
    public static void modifResident(int id,String mot,int index) throws IOException {
       

        File myObj = new File("database/Resident.txt");
        Scanner myReader = new Scanner(myObj);
        
        String text="";
        while (myReader.hasNextLine()) {
            String ligne = myReader.nextLine();
            String[] myArray = ligne.split(" ");
            if(id==Integer.parseInt(myArray[0])){
                myArray [index]=mot;
            }

            text=text+myArray[0]+" "+myArray[1]+" "+myArray[2]+" "+myArray[3]+" "+myArray[4]+" "+myArray[5]+" "+myArray[6]+"\n";
            
        }
        FileWriter myWriter = new FileWriter("database/Resident.txt");
        myWriter.write(text);
        myReader.close();
        myWriter.close();
        
    }  

    //ajoute les info dun resident dans la database
    
    public void addResident(int id,String Nom,String Prenom,String Telephone,String Mdp,String Email,String Adresse) throws IOException {
        File myObj = new File("database/Resident.txt");
        Scanner myReader = new Scanner(myObj);
        
        String text="";
        while (myReader.hasNextLine()) {
            String ligne = myReader.nextLine();
            String[] myArray = ligne.split(" ");
            
            text=text+myArray[0]+" "+myArray[1]+" "+myArray[2]+" "+myArray[3]+" "+myArray[4]+" "+myArray[5]+" "+myArray[6]+"\n";
            
        }
        text=text+id+" "+Nom+" "+Prenom+" "+Telephone+" "+Mdp+" "+Email+" "+Adresse+"\n";
        FileWriter myWriter = new FileWriter("database/Resident.txt");
        myWriter.write(text);
        myReader.close();
        myWriter.close();
        
    } 
}
