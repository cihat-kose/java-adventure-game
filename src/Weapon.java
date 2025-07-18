public class Weapon {
    private int id;
    private String name;
    private int damage;
    private int price;

    public Weapon(int id, String name, int damage, int price) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public static Weapon[] weapons() {
        return new Weapon[]{
                new Weapon(1, "Pistol", 2, 25),
                new Weapon(2, "Sword", 3, 35),
                new Weapon(3, "Rifle", 7, 45),
                new Weapon(0, "Fist", 0, 0)
        };
    }

    public static Weapon getWeaponById(int id) {
        for (Weapon w : weapons()) {
            if (w.getId() == id) {
                return w;
            }
        }
        return weapons()[3];
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getPrice() {
        return price;
    }
}
