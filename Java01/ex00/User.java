import java.util.UUID;

public class User {
    private static Integer id = 0;
    private Integer identifier;
    private Integer balance;
    private String name;

    public User(String name, Integer balance) {
        id++;
        this.identifier = id;
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
}
