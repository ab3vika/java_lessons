package lesson3;

public class Player implements Movable {
    private static String status = "Offline";

    @Override
    public void move(int posX, int posY) throws MoveNegativeException {
        if (posX < 0 || posY < 0) {
            throw new MoveNegativeException();
        }
        System.out.println("Player was moved to {x='" + posX + "', y='" + posY + "'}");
    }

    public static class Authorization {
        public void logIn() {
            status = "Online";
            System.out.println("Player logged in (status='" + status + "')");
        }

        public void logOut() {
            status = "Offline";
            System.out.println("Player logged in (status='" + status + "')");
        }
    }
}
