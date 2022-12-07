import java.util.*;
import java.io.*;

public class AssassinMain{
    //  Imports names from a namelist
    //  Imports into a stack
    //  Converts stack into an array
    public static String[] getNameList() throws IOException{

        Scanner scanner = new Scanner(new FileReader ("names.txt"));

        int i = 0;
        Stack<String> st = new Stack<String>();
        while (scanner.hasNextLine()){
            st.push(scanner.nextLine());
            i++;
        }

        scanner.close();

        String[] nameArray = new String[i];
        st.toArray(nameArray);
        return nameArray;


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
    public static void DEBUGPRINTARRAY(String[] nameArray){
        for (int i = 0; i < nameArray.length; i++){
            System.out.println("Element " + i + " = " + nameArray[i]);
        }
    }
    public static void main (String args[]) throws IOException {
        String[] nameArray = getNameList();
        DEBUGPRINTARRAY(nameArray);
        
        //
        //  AssassinManager goes here
        //

        //  GAME LOOP

        // while(!(isGameOver())){
        //     display();
        //     System.out.println("Who is to die today?");
        //     System.in.read();
        // }

        //  System.out.println(winner() + " is the winner!");   DEFINE winner()

        
    }




}