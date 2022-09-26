public class User {
    private final Integer identifier;
    private Integer balance;
    private String name;

    public User(String name, Integer balance) {
        this.identifier = UserIdsGenerator.getInstance().generateId();
        setName(name);
        setBalance(balance);
    }

    public Integer getIdentifier() {
        return (identifier);
    }

    public Integer getBalance() {
        return (balance);
    }

    public void setBalance(Integer balance) {
        if (balance <= 0) {
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

    @Override
    public String toString() {
        return ( "User: " +
                "ID = " + identifier +
                ", Name = " + name +
                ", Balance = " + balance
                );
    }
}
