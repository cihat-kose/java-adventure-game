public class Armor {
    private int id;
    private String name;
    private int block;
    private int price;

    public Armor(int id, String name, int block, int price) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.price = price;
    }

    public static Armor[] armors() {
        return new Armor[]{
                new Armor(1, "Light", 1, 15),
                new Armor(2, "Medium", 3, 25),
                new Armor(3, "Heavy", 5, 40),
                new Armor(0, "None", 0, 0)
        };
    }

    public static Armor getArmorById(int id) {
        for (Armor a : armors()) {
            if (a.getId() == id) {
                return a;
            }
        }
        return armors()[3];
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBlock() {
        return block;
    }

    public int getPrice() {
        return price;
    }
}
