package lesson3;

import java.util.Objects;

import static lesson3.Main.addEntityToList;
import static lesson3.Main.writeToFile;

public abstract class Entity implements Movable {
    private String name;
    private int posX;
    private int posY;

    public Entity(String name) {
        this.name = name;
        System.out.println("Entity " + this + " was created");
        writeToFile(this.name);
        addEntityToList(this);
    }

    public abstract boolean canAttack();

    public final String getName() {
        return this.name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    @Override
    public void move(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        System.out.printf("Entity %s was moved to {x='%d', y='%d'}%n", this, this.posX, this.posY);
    }

    @Override
    public String toString() {
        return String.format("{name='%s', canAttack='%b'}", this.getName(), this.canAttack());
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Entity && ((Entity) obj).name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.posX, this.posY);
    }
}
