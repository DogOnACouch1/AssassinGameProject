import java.util.*;
public class AssassinManager {
    private AssassinNode killRingHead = null;
    private AssassinNode graveYardHead = null;
    public AssassinManager(List<String> names) { //loop might go through list in reverse, may need to fix
        if (names == null || (names.size() == 0)){
            throw new IllegalArgumentException();
        }
        for(int i = 0; i <= names.size() -1; i++) {
            killRingHead = new AssassinNode(names.get(i), killRingHead);
        }
    }
    public void printKillRing() {
        AssassinNode node = killRingHead; // Grabs the name of the first player before iterating through the linked list chain
        String firstPlayerName = node.player;
        while(node.next != null) { //Prints out who is stalking who if the list is not empty
            System.out.println("  " + node.player + " is stalking " + node.next.player);
            node = node.next; //Progresses through list
        }

        System.out.println("  " + node.player + " is stalking " + firstPlayerName); // Hooks the last player to the first player text

    }
    public void printGraveyard() {
        AssassinNode node = graveYardHead;
        while(node != null) { //Prints out who was killed by who if list is not empty
            System.out.println("  " + node.player + " was killed by " + node.killer);
            node = node.next; //Progresses through list
        }
    }
    public boolean killRingContains(String name) {
        AssassinNode node = killRingHead;
        while(node != null) {  //Returns true if a name entered is found in the kill ring
            if(name.equalsIgnoreCase(node.player)) {
                return true;
            }
            node = node.next; //Progresses through list until name entered is found
        }
        return false;
    }
    public boolean graveYardContains(String name) {
        AssassinNode node = graveYardHead;
        while(node != null) { //Returns true if a name entered is found in the graveyard
            if(name.equalsIgnoreCase(node.player)) {
                return true;
            }
            node = node.next; //Progresses through list until name entered is found
        }
        return false;
    }
    public boolean isGameOver() {
        if(killRingHead.next == null) {  //Returns true if there is only one piece of data in the list
            return true;
        }
        return false;
    }
    public String winner() {
        if(isGameOver()) {    //If method isGameOver() is true, then returns the only player left in the list
            return killRingHead.player;
        }
        return null; //Returns null if the list has more than one person
    }
    public void kill(String name) throws IllegalStateException, IllegalArgumentException {
        if(isGameOver()) {  //Throws IllegalStateException if the game is not over, takes precedence over IllegalArgumentException
            throw new IllegalStateException();
        }
        else if (!isGameOver() && graveYardContains(name)){
            System.out.println(name + " is already dead.");
        }
        else if(!killRingContains(name)) {  //Throws IllegalArgumentException is name entered is not found
            throw new IllegalArgumentException();
        }
        if(!isGameOver() && killRingContains(name)) {    //If the game isn't over and the name entered is found in the kill ring
            AssassinNode head = killRingHead;               
            AssassinNode dead = killRingHead;
            if(head.player.equalsIgnoreCase(name)) {
                while(head.next != null) {
                    head = head.next;
                }
                dead.killer = head.player;
                killRingHead = killRingHead.next;
            }
            else {
                while(!head.next.player.equalsIgnoreCase(name)) {
                    head = head.next;
                }
                head.next.killer = head.player;
                dead = head.next;
                head.next = head.next.next;
            }
            if(graveYardHead == null) {
                graveYardHead = dead;
                graveYardHead.next = null;
            }
            else {
                dead.next = graveYardHead;
                graveYardHead = dead;
            }
        }

    }
}
