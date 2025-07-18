public class Inventory {
    private Weapon weapon;
    private Armor armor;

    public Inventory() {
        this.weapon = Weapon.getWeaponById(0);
        this.armor = Armor.getArmorById(0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
