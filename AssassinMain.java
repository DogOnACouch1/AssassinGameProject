import java.util.*;
import java.io.*;

public class AssassinMain{
    //  Imports names from a namelist
    //  Imports into a stack
    //  Converts stack into an array
    public static List<String> getNameList() throws IOException{

        Scanner scanner = new Scanner(new FileReader ("names.txt"));
        List<String> nameList = new ArrayList<String>();

        while (scanner.hasNextLine()){
            String name = scanner.nextLine();
            nameList.add(name);
        }
        scanner.close();
        return nameList;


    }
    public static void printKillRing(){
        //  Get array from Manager
        //  Iterate array
        //     (two space indent) NAME is stalking NAME
    }

    public static void printGraveyard(){
        //  Get array from Manager
        //  Iterate array
        //     (two space indent) NAME was killed by NAME

        
        
    }

    public static void display(){
        System.out.println("Current kill ring:");
        printKillRing();
        System.out.println("Current graveyard");
        printGraveyard();
    }
    
    //  TODO DELETE THIS FUNCTION BEFORE PUBLISHING
    public static void DEBUGPRINTARRAY(List<String> nameList){
        for (int i = 0; i < nameList.size(); i++){
            System.out.println("Element " + i + " = " + nameList.get(i));
        }
    }
    public static void main (String args[]) throws IOException {
        List<String> nameList = getNameList();
        DEBUGPRINTARRAY(nameList);
        
        AssassinManager AssassinManager = new AssassinManager(nameList);

        //  GAME LOOP
        
        Scanner inputScanner = new Scanner(System.in);

        while(!(AssassinManager.isGameOver())){
            System.out.println("Current kill ring:");
            AssassinManager.printKillRing();
            System.out.println("Current graveyard:");
            AssassinManager.printGraveyard();

            System.out.println("Who is to die today?");
            String userInput = inputScanner.nextLine();
            System.out.println(userInput);
            AssassinManager.kill(userInput);
        }

        System.out.println("Game was won by " + AssassinManager.winner());

        System.out.println("Final graveyard is as follows:");
        AssassinManager.printGraveyard();

        inputScanner.close();

        
    }




}