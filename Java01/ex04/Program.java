public class Program {
    public static void main(String[] args) {
        User usr1 = new User("Biba", 500);
        User usr2 = new User("Boba", 200);
        User usr3 = new User("Lupa", 2000);
        TransactionsService service = new TransactionsService();
        service.addUser(usr1);
        service.addUser(usr2);
        service.addUser(usr3);
        service.serviceExecute(usr1.getIdentifier(), usr2.getIdentifier(), 100);
        service.serviceExecute(usr2.getIdentifier(), usr1.getIdentifier(), 100);
        service.serviceExecute(usr1.getIdentifier(), usr2.getIdentifier(), 1);
        service.serviceExecute(usr1.getIdentifier(), usr2.getIdentifier(), 1);

        service.serviceExecute(usr2.getIdentifier(), usr3.getIdentifier(), 100);
        service.serviceExecute(usr2.getIdentifier(), usr3.getIdentifier(), 100);
        service.serviceExecute(usr2.getIdentifier(), usr3.getIdentifier(), 100);
        service.serviceExecute(usr2.getIdentifier(), usr3.getIdentifier(), 100);
        service.serviceExecute(usr1.getIdentifier(), usr3.getIdentifier(), 100);
        service.serviceExecute(usr1.getIdentifier(), usr3.getIdentifier(), 100);

        System.out.println(usr1);
        System.out.println(usr2);
        System.out.println(usr3);

        Transaction[] arr = service.getTransactionArray(usr1.getIdentifier());
        for (Transaction t : arr){
            System.out.println(t);
        }

        System.out.println();

        arr = service.getTransactionArray(usr3.getIdentifier());
        for (Transaction t : arr){
            System.out.println(t);
        }

        System.out.println();
        System.out.println();

        service.deleteTransactionById(usr3.getIdentifier(), arr[1].getId());
        service.deleteTransactionById(usr3.getIdentifier(), arr[2].getId());

        Transaction[] test = service.allTransactions();
        for (Transaction t : test){
            System.out.println(t);
        }
    }
}
