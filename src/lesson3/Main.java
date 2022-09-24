package lesson3;

public class Main {
    public static void main(String[] args) {
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
        new Player().move(5, 5);
        playerAuthorization.logOut();
    }
}
