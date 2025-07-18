public class SafeHouse extends Location {
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in the Safe House.");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        System.out.println("Your health has been restored.");
        return true;
    }
}
