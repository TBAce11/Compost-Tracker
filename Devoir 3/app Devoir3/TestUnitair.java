public class TestUnitair {
    
    
    public static void main(String[] args)  {
        System.out.println(TestUnitairIS());
}

    //Test Ismail Simo 20153080
    //cette fonction fait trois test unitaire de succes ,d'Echec et sanitaire
    //elle return un Boolean qui est True seulment si les 3 teste sont valider 
    public static Boolean TestUnitairIS(){
        //on genere la liste de conssomateur dans MunicipInfo
        MunicipInfo.ListConsomateur();
        //test succes---------------------------
                //on en parametre l'id du consommateur que on veut recuperer
                //pour id=12 on doit avoir le conssomateur quia pour nom Consomateur12
                Consomateur test1=MunicipInfo.getConsommateur(12);
                //le nom du conssomateur
                String test1Nom=test1.getNom();
                //Boolean qui prend true si le test est valide sinon false 
                Boolean resultTest1;
                if("Consomateur12".compareTo(test1Nom)==0){
                    resultTest1=true;
                }else{
                    resultTest1=false;
                }
        //test Echec---------------------------
                //pour id=20 on doit avoir la valeur null
                Consomateur test2=MunicipInfo.getConsommateur(20);
                Boolean resultTest2;
                if(test2==null){
                    resultTest2=true;
                }else{
                    resultTest2=false;
                }
        
        
        //test sanitaire---------------------------
                //pour id=12 on doit avoir le conssomateur qui a pour nom Consomateur12 en plusiere etape 
                //reccupere le consomateur qui a pour id 12 on recupere sont id 
                //avec l'id que on a recuperer on recherche le conssomateur avec l'id 
                Consomateur test3=MunicipInfo.getConsommateur(MunicipInfo.getConsommateur(12).getid());
                //le nom du conssomateur 
                String test3Nom=test3.getNom();
                //Boolean qui prend true si le test est valide sinon false 
                Boolean resultTest3;
                if("Consomateur12".compareTo(test3Nom)==0){
                    resultTest3=true;
                }else{
                    resultTest3=false;
                }
                
                return (resultTest1 && resultTest2 && resultTest3);
            }














} 

