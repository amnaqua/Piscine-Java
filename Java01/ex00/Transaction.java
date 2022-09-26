import java.util.UUID;

public class Transaction {
    private UUID identifier;
    private User recipient;
    private User sender;
    private Integer amount;
    private enum Category {
        DEBIT,
        CREDIT
    }
    private enum Status {
        FAIL,
        SUCCESS
    }
    private Category transferCategory;
    private Status transferStatus;

    public Transaction(User sender, User recipient, Integer amount) {
        this.recipient = recipient;
        this.sender = sender;
        this.identifier = UUID.randomUUID();

        if (amount < 0) {
            setTransferCategory(Category.CREDIT);
        } else {
            setTransferCategory(Category.DEBIT);
        }
        this.amount = amount;
        if (sender.getBalance() < 0 || sender.getBalance() < amount) {
            setTransferStatus(Status.FAIL);
        } else {
            sender.setBalance(sender.getBalance() - amount);
            recipient.setBalance(recipient.getBalance() + amount);
            setTransferStatus(Status.SUCCESS);
        }
    }

    public Category getTransferCategory() {
        return (transferCategory);
    }

    public void setTransferCategory (Category category) {
        this.transferCategory = category;
    }

    public UUID getIdentifier() {
        return (identifier);
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public User getRecipient() {
        return (recipient);
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getSender() {
        return (sender);
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Integer getAmount() {
        return (amount);
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Status getTransferStatus() {
        return (transferStatus);
    }

    public void setTransferStatus(Status transferStatus) {
        this.transferStatus = transferStatus;
    }

    @Override
    public String toString() {
        return ( "Transaction: " +
                "ID = " + identifier +
                ", Recipient = " + recipient +
                ", Sender = " + sender +
                ", Amount = " + amount +
                ", Category = " + transferCategory +
                ", Transfer Status = " + transferStatus
                );
    }
}
