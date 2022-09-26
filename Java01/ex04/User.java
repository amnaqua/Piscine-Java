public class User {
    private final Integer identifier;
    private long balance;
    private String name;
    private TransactionsList transactionsList;

    public User(String name, Integer balance) {
        this.identifier = UserIdsGenerator.getInstance().generateId();
        setName(name);
        setBalance(balance);
        this.transactionsList = new TransactionsLinkedList();
    }

    public TransactionsList getTransactionsList() {
        return (transactionsList);
    }

    public Integer getIdentifier() {
        return (identifier);
    }

    public long getBalance() {
        return (balance);
    }

    public void setBalance(long balance) {
        if (balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public String getName() {
        return (name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void increaseBalance(long amount) {
        setBalance(balance + amount);
    }

    public void decreaseBalance(long amount) {
        setBalance(balance - amount);
    }

    @Override
    public String toString() {
        return ( "User: " +
                "ID = " + identifier +
                ", Name = " + name +
                ", Balance = " + balance
                );
    }
}
