package lesson3;

public class PassiveEntity extends Entity {
    private boolean canAttack;

    public PassiveEntity(String name) {
        super(name);
    }

    @Override
    public boolean canAttack() {
        return canAttack;
    }

    public void setAttack(boolean canAttack) {
        if (!(this instanceof Animal)) {
            this.canAttack = canAttack;
            System.out.println("Attack was set for entity " + this);
        } else {
            System.out.println("You cannot set attack for entity " + this);
        }
    }
}
