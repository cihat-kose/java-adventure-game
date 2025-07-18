import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to adventure game!");
        System.out.print("Enter a name, please! : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Dear " + player.getName() + " welcome to this dark and foggy island!!! Everything that happens here is real!");
        System.out.println("Please select a character : ");
        player.selectChar();

        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println();
            System.out.println("############ Locations ############");
            System.out.println("0 - Quit");
            System.out.println("1 - Safe House");
            System.out.println("2 - Tool Store");
            System.out.print("Please select a location: ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0:
                    System.out.println("See you next time!");
                    return;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    System.out.println("Please select a valid location!");
                    continue;
            }
            if (!location.onLocation()) {
                System.out.println("Game Over!");
                break;
            }
        }
    }
}
