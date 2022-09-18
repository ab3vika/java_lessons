package lesson3;

public class Player implements Movable {
    @Override
    public void move(int posX, int posY) {
        System.out.println("Player was moved to {x='" + posX + "', y='" + posY + "'}");
    }
}
