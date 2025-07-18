import java.util.Scanner;

public class ToolStore extends Location {
    private Scanner input = new Scanner(System.in);

    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the Tool Store!");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1 - Weapons");
            System.out.println("2 - Armors");
            System.out.println("0 - Exit");
            System.out.print("Your choice: ");
            int select = input.nextInt();
            while (select < 0 || select > 2) {
                System.out.print("Invalid choice, try again: ");
                select = input.nextInt();
            }
            switch (select) {
                case 0:
                    showMenu = false;
                    break;
                case 1:
                    printWeapons();
                    buyWeapon();
                    break;
                case 2:
                    printArmors();
                    buyArmor();
                    break;
            }
        }
        return true;
    }

    private void printWeapons() {
        System.out.println("Weapons:");
        for (Weapon w : Weapon.weapons()) {
            if (w.getId() != 0) {
                System.out.println(w.getId() + " - " + w.getName() + " <Price: " + w.getPrice() + ", Damage: " + w.getDamage() + ">");
            }
        }
    }

    private void buyWeapon() {
        System.out.print("Select a weapon ID: ");
        int selectWeaponID = input.nextInt();
        Weapon selectedWeapon = Weapon.getWeaponById(selectWeaponID);
        if (selectedWeapon.getId() == 0) {
            System.out.println("No such weapon.");
            return;
        }
        if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
            System.out.println("You don't have enough money!");
            return;
        }
        System.out.println("You bought " + selectedWeapon.getName() + ".");
        this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedWeapon.getPrice());
        this.getPlayer().getInventory().setWeapon(selectedWeapon);
    }

    private void printArmors() {
        System.out.println("Armors:");
        for (Armor a : Armor.armors()) {
            if (a.getId() != 0) {
                System.out.println(a.getId() + " - " + a.getName() + " <Price: " + a.getPrice() + ", Block: " + a.getBlock() + ">");
            }
        }
    }

    private void buyArmor() {
        System.out.print("Select an armor ID: ");
        int selectArmorID = input.nextInt();
        Armor selectedArmor = Armor.getArmorById(selectArmorID);
        if (selectedArmor.getId() == 0) {
            System.out.println("No such armor.");
            return;
        }
        if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
            System.out.println("You don't have enough money!");
            return;
        }
        System.out.println("You bought " + selectedArmor.getName() + ".");
        this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
        this.getPlayer().getInventory().setArmor(selectedArmor);
    }
}
