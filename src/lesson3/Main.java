package lesson3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    private static final String FILE_PATH = "src/lesson3/Entities.txt";

    public static void main(String[] args) throws MoveNegativeException {
        Animal pig = new Animal("Pig");
        pig.move(2, 4);
        PassiveEntity sheep = new Animal("Sheep");
        sheep.setAttack(true);
        PassiveEntity eagle = new PassiveEntity("Eagle");
        eagle.setAttack(true);
        PassiveEntity.AngryPassiveEntity angryEagle = eagle.new AngryPassiveEntity();
        angryEagle.attack(3);
        angryEagle.attack(2);
        System.out.println("Damage caused by " + eagle.getName() + ": " + angryEagle.getCausedDamage());
        AggressiveEntity zombie = new AggressiveEntity("Zombie") {
            @Override
            public void move(int posX, int posY) {
                super.move(posX * 2, posY * 2);
                System.out.println(this.getName() + " moves with x2 speed");
            }
        };
        zombie.move(4, 2);
        Player.Authorization playerAuthorization = new Player.Authorization();
        playerAuthorization.logIn();
        Player player = new Player();
        player.move(5, 5);
        playerAuthorization.logOut();
        readFromFile();
        player.move(-1, -1);
    }

    public static void writeToFile(String line) {
        try (FileOutputStream output = new FileOutputStream(FILE_PATH, true)) {
            output.write(line.concat("\n").getBytes());
        } catch (IOException e) {
            System.out.println("File wasn't found");
        }
    }

    public static void readFromFile() {
        try (FileInputStream input = new FileInputStream(FILE_PATH)) {
            int i;
            while ((i = input.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            System.out.println("File wasn't found");
        }
    }
}
