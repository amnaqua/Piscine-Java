import java.util.UUID;

public class TransactionsService {
    private UsersList usersList;

    public TransactionsService() {
        usersList = new UsersArrayList();
    }

    public void addUser(User user) {
        usersList.addUser(user);
    }

    public long getUserBalanceById(int id) {
        return (usersList.getUserById(id).getBalance());
    }

    public long getUserBalanceByIndex(int index) {
        return (usersList.getUserByIndex(index).getBalance());
    }

    public void serviceExecute(int recipientId, int senderId, long amount) {
        if (getUserBalanceById(senderId) >= amount && amount > 0) {
            Transaction transaction1 = new Transaction(usersList.getUserById(recipientId), usersList.getUserById(senderId),
                    Transaction.Category.DEBIT, amount);
            Transaction transaction2 = new Transaction(transaction1);
            transaction2.setTransactionCategory(Transaction.Category.CREDIT);
            transaction2.setAmount(-transaction1.getAmount());
            usersList.getUserById(recipientId).getTransactionsList().addTransaction(transaction1);
            usersList.getUserById(senderId).getTransactionsList().addTransaction(transaction2);
            usersList.getUserById(recipientId).increaseBalance(amount);
            usersList.getUserById(senderId).decreaseBalance(amount);
        } else {
            throw new IllegalTransactionException();
        }
    }

    public Transaction[] getTransactionArray(int id) {
        return (usersList.getUserById(id).getTransactionsList().toArray());
    }

    public void deleteTransactionById(int userId, UUID id) {
        usersList.getUserById(userId).getTransactionsList().deleteTransactionById(id);
    }

    public Transaction[] allTransactions() {
        if (usersList.getSize() > 0) {
            TransactionsList list = new TransactionsLinkedList();
            User user = usersList.getUserByIndex(0);
            Transaction[] temp = user.getTransactionsList().toArray();
            for (Transaction transaction : temp) {
                list.addTransaction(transaction);
            }
            for (int i = 1; i < usersList.getSize(); i++){
                User u = usersList.getUserByIndex(i);
                Transaction[] inner = u.getTransactionsList().toArray();
                Transaction[] result = list.toArray();
                for (int k = 0; k < inner.length; k++){
                    boolean flag = false;
                    for (int j = 0; j < result.length; j++){
                        if (inner[k].getId().equals(result[j].getId())){
                            list.deleteTransactionById(result[j].getId());
                            flag = true;
                        }
                    }
                    if (!flag) {
                        list.addTransaction(inner[k]);
                    }

                }
            }
            return list.toArray();
        }
        return null;
    }
}
