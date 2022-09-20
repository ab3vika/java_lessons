package lesson3;

public class Main {
    public static void main(String[] args) {
        Animal pig = new Animal("Pig");
        pig.move(2, 4);
        PassiveEntity sheep = new Animal("Sheep");
        sheep.setAttack(true);
        PassiveEntity eagle = new PassiveEntity("Eagle");
        eagle.setAttack(true);
        AggressiveEntity zombie = new AggressiveEntity("Zombie");
        zombie.move(4, 2);
        new Player().move(5, 5);
    }
}
