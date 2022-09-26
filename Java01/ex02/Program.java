

public class Program {
    public static void main(String[] args) {
        UsersArrayList users = new UsersArrayList();

        int max_users = (int)(Math.random() * 30);
        System.out.println("Max users = " + max_users);

        for (int i = 0; i < max_users; i++) {
            User temp;
            if (i % 2 == 0) {
                temp = new User("User " + i, i);
            } else {
                temp = new User("Not user " + i, i);
            }
            users.addUser(temp);
        }

        System.out.println("User from middle of the list by index: " + users.getUserByIndex((max_users / 2) - 1).toString());
        System.out.println("User from middle of the list by ID: " + users.getUserById(users.getSize() / 2).toString());
        System.out.println("User from start of the list by index: " + users.getUserByIndex(0).toString());
        System.out.println("User from start of the list by ID: " + users.getUserById(1).toString());
        System.out.println("User from end of the list by index: " + users.getUserByIndex(max_users - 1).toString());
        System.out.println("User from end of the list by ID: " + users.getUserById(users.getSize()).toString());
        System.out.println("Number of users: " + users.getSize());

        /*
        System.out.println("Exception test" + users.getUserById(users.getSize() + 1).toString());
        System.out.println("Exception test" + users.getUserByIndex(max_users).toString());
        System.out.println("Exception test" + users.getUserById(0).toString());
        System.out.println("Exception test" + users.getUserByIndex(-1).toString());
        */
    }
}
