import java.util.UUID;

public class Transaction {

    public enum Category {
        DEBIT,
        CREDIT
    }
    private UUID id;
    private User recipient;
    private User sender;
    private Category transactionCategory;
    private long amount;
    private Transaction next;
    private Transaction prev;

    public void setAmount(long amount) {
        if (transactionCategory == Category.DEBIT) {
            if (amount < 0) {
                System.err.println("Error: negative credit in debit transaction { " + amount + " }");
            } else {
                this.amount = amount;
            }
        } else if (transactionCategory == Category.CREDIT) {
            if (amount > 0) {
                System.err.println("Error: positive credit in credit transaction { " + amount + " }");
            } else {
                this.amount = amount;
            }
        }
    }

    public Transaction(User recipient, User sender, Category transactionCategory, long amount) {
        this.id = UUID.randomUUID();
        this.recipient = recipient;
        this.sender = sender;
        this.transactionCategory = transactionCategory;
        setAmount(amount);
    }

    public Transaction(Transaction transaction) {
        this.id = transaction.getId();
        this.recipient = transaction.getRecipient();
        this.sender = transaction.getSender();
        setTransactionCategory(transaction.getTransactionCategory());
        setAmount(transaction.getAmount());
        this.prev = transaction.getPrev();
        this.next = transaction.getNext();
    }

    public UUID getId() {
        return (id);
    }

    public User getRecipient() {
        return (recipient);
    }

    public User getSender() {
        return (sender);
    }

    public void setTransactionCategory(Category transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    public Category getTransactionCategory() {
        return (transactionCategory);
    }

    public long getAmount() {
        return (amount);
    }

    public Transaction getNext() {
        return (next);
    }

    public Transaction getPrev() {
        return (prev);
    }

    public void setNext(Transaction next) {
        this.next = next;
    }

    public void setPrev(Transaction prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return ( "Transaction: " +
                "ID = " + id +
                ", Recipient = " + recipient.getName() +
                ", Sender = " + sender.getName() +
                ", TransferCategory = " + transactionCategory +
                ", TransferAmount = " + amount
                );
    }
}
