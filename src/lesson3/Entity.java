package lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static lesson3.Main.readEntityList;
import static lesson3.Main.writeToFile;

public abstract class Entity implements Movable {
    public static List<Entity> entityList = new ArrayList<>();
    private String name;
    private int posX;
    private int posY;

    public Entity(String name) {
        this.name = name;
        System.out.println("Entity " + this + " was created");
        writeToFile(this.name);
        entityList.add(this);
        readEntityList();
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
        return "{name='" + this.getName() + "', canAttack='" + this.canAttack() + "'}";
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
