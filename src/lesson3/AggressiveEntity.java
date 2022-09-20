package lesson3;

public class AggressiveEntity extends Entity {
    private static final boolean CAN_ATTACK = true;

    public AggressiveEntity(String name) {
        super(name);
    }

    @Override
    public boolean canAttack() {
        return CAN_ATTACK;
    }
}
