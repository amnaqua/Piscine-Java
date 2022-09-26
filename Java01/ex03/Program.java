

public class Program {
    public static void main(String[] args) {
        int max_usrs = (int)(Math.random() * 10 + 15);
        System.out.println("Users: " + max_usrs);
        TransactionsLinkedList transactions = new TransactionsLinkedList();
        User sender = new User("Pupa", 123);
        User recipient = new User("Lupa", 0);

        for (int i = 0; i < max_usrs; i++) {
            Transaction tmp;
            if (i % 2 == 0) {
                tmp = new Transaction(sender, recipient, 123);
            }	else {
                tmp = new Transaction(recipient, sender, 123);
            }
            transactions.addTransaction(tmp);
        }

        for (Transaction t : transactions.toArray()) {
            System.out.println(t.toString());
        }
    }
}
