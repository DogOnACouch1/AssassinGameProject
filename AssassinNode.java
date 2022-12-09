public class AssassinNode {
    public String player; //Name of player
    public String killer; //Nameo of person who killed the player
    public AssassinNode next; //Points to the next node
    public AssassinNode(String player) { //Node with  player name and a null pointer
        this(player, null);
    }
    public AssassinNode(String player, AssassinNode next) { //Node with player name, points to next node
        this.player = player;
        this.killer = null;
        this.next = next;
    }
}
