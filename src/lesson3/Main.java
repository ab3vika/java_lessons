package lesson3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String FILE_PATH = "src/lesson3/Entities.txt";
    private static final List<Entity> entityList = new ArrayList<>();

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
        System.out.printf("Damage caused by %s: %d%n", eagle.getName(), angryEagle.getCausedDamage());

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

        updateEntityInList(pig.getName(), "Adult" + pig.getName());
        deleteEntityFromList(sheep.getName());
        readFromFile();

        System.out.println("Check exception:");
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

    public static void readEntityList() {
        System.out.println("Existing entities:");
        entityList.stream().forEach(e -> System.out.println(e.getName()));
    }

    public static void addEntityToList(Entity entity) {
        entityList.add(entity);
        readEntityList();
    }

    public static void deleteEntityFromList(String name) {
        entityList.remove(entityList.stream().filter(e -> name.equals(e.getName())).findFirst().get());
        readEntityList();
    }

    public static void updateEntityInList(String name, String newName) {
        entityList.stream().filter(e -> name.equals(e.getName())).forEach(e -> e.setName(newName));
        readEntityList();
    }
}
