public class AssassinNode {
    private String player;
    private String killer;
    private AssassinNode next;
    public AssassinNode(String player) {
        this(player, null);
    }
    public AssassinNode(String player, AssassinNode next) {
        this.player = player;
        this.killer = null;
        this.next = next;
    }
}
