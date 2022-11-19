package sql;

import java.util.Scanner;

public class Main {

    private static final String HELP = new StringBuilder()
            .append("Commands:\n")
            .append("client add [name] [address] [phone],\n")
            .append("client delete [name],\n")
            .append("client get all,\n")
            .append("category add [name],\n")
            .append("category delete [name],\n")
            .append("category get all,\n")
            .append("order add [clicentId] [categoryId] [price],\n")
            .append("order deleteBy client|category [clientId|categoryId],\n")
            .append("order get all,\n")
            .append("order getBy client|category [clientId|categoryId],\n")
            .append("help,\n")
            .append("exit\n")
            .toString();

    public static void main(String[] args) {
        Sql sql = new Sql();
        sql.connect();
        System.out.println(HELP);
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String type = input.next().toLowerCase();
            String action;
            if (type.equals("client")) {
                action = input.next().toLowerCase();
                if (action.equals("add")) {
                    sql.addClient(input.next(), input.next(), input.next());
                } else if (action.equals("delete")) {
                    sql.deleteClient(input.next());
                } else if (action.equals("get") && input.next().equalsIgnoreCase("all")) {
                    sql.getClients();
                }
            } else if (type.equals("category")) {
                action = input.next().toLowerCase();
                if (action.equals("add")) {
                    sql.addCategory(input.next());
                } else if (action.equals("delete")) {
                    sql.deleteCategory(input.next());
                } else if (action.equals("get") && input.next().equalsIgnoreCase("all")) {
                    sql.getCategories();
                }
            } else if (type.equals("order")) {
                action = input.next().toLowerCase();
                String by;
                if (action.equals("add")) {
                    sql.addOrder(Integer.parseInt(input.next()), Integer.parseInt(input.next()), Integer.parseInt(input.next()));
                } else if (action.equals("deleteby")) {
                    by = input.next().toLowerCase();
                    if (by.equals("client") || by.equals("category")) {
                        sql.deleteOrdersBy(by, Integer.parseInt(input.next()));
                    }
                } else if (action.equals("get") && input.next().equalsIgnoreCase("all")) {
                    sql.getOrders();
                } else if (action.equals("getby")) {
                    by = input.next().toLowerCase();
                    if (by.equals("client") || by.equals("category")) {
                        sql.getOrdersBy(by, Integer.parseInt(input.next()));
                    }
                }
            } else if (type.equals("help")) {
                System.out.println(HELP);
            } else if (type.equals("exit")) {
                break;
            } else {
                System.out.println("Wrong command");
            }
        }
        sql.disconnect();
    }

}
