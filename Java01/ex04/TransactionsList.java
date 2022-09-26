import java.util.UUID;

public interface TransactionsList {
    public void addTransaction(Transaction transaction);
    public void deleteTransactionById(UUID id);
    public Transaction[] toArray();
}
