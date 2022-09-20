package lesson3;

public abstract class Entity implements Movable {
    private String name;
    private int posX;
    private int posY;

    public Entity(String name) {
        this.name = name;
        System.out.println("Entity " + this + " was created");
    }

    public abstract boolean canAttack();

    public final String getName() {
        return this.name;
    }

    @Override
    public void move(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        System.out.println(String.format("Entity %s was moved to {x='%d', y='%d'}", this, this.posX, this.posY));
    }

    @Override
    public String toString() {
        return "{name='" + this.getName() + "', canAttack='" + this.canAttack() + "'}";
    }
}
