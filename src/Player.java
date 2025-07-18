import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private String charName;
    private String name;
    private Inventory inventory;
    private Scanner input = new Scanner(System.in);


    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        GameCharacter[] characterList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("Characters: ");
        System.out.println("-------------------------------");
        for (GameCharacter gameCharacter : characterList) {
            System.out.println("ID : " + gameCharacter.getId() + "\t" +
                    gameCharacter.getName() + "\t\t---->" +
                    "\t\t Damage: " + gameCharacter.getDamage() +
                    "\t\t Health: " + gameCharacter.getHealth() +
                    "\t\t Money: " + gameCharacter.getMoney());
        }
        System.out.println("------------------------------------");
        System.out.println("Please enter the ID of the character you want to select!: ");
        int selectCharacter = input.nextInt();
        switch (selectCharacter) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Character: " + this.getCharName() +
                " --> Damage: " + this.getDamage() +
                ", Health: " + this.getHealth() +
                ", Money: " + this.getMoney());
    }

    public void initPlayer(GameCharacter gameCharacter) {
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setOriginalHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
        this.setCharName(gameCharacter.getName());
    }

    public void printInfo() {
        System.out.println("Weapon: " + this.getInventory().getWeapon().getName() +
                ", Armor: " + this.getInventory().getArmor().getName() +
                ", Block: " + this.getInventory().getArmor().getBlock() +
                ", Damage: " + this.getTotalDamage() +
                ", Health: " + this.getHealth() +
                ", Money: " + this.getMoney());
    }

    public int getTotalDamage() {
        return this.damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
