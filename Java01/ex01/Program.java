

public class Program {
    public static void main(String[] args) {
        User user1 = new User("Bob", 1000);
        User user2 = new User("Mike", 1000000);
        User user3 = new User("John", -100);

        System.out.println(user1);
        System.out.println(user1.getIdentifier());
        System.out.println(user1.getName());
        System.out.println(user1.getBalance());
        System.out.println("-------------------");
        System.out.println(user2);
        System.out.println(user2.getIdentifier());
        System.out.println(user2.getName());
        System.out.println(user2.getBalance());
        System.out.println("-------------------");
        System.out.println(user3);
        System.out.println(user3.getIdentifier());
        System.out.println(user3.getName());
        System.out.println(user3.getBalance());

        System.out.println();

        System.out.println(user1.getBalance());
        System.out.println(user2.getBalance());
        System.out.println(user3.getBalance());
    }
}
