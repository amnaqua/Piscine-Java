import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    private Transaction begin;
    private Transaction end;
    private int listSize = 0;


    @Override
    public void addTransaction(Transaction transaction) {
        if (begin == null && end == null) {
            begin = transaction;
            end = transaction;
            listSize++;
            return;
        }
        end.setNext(transaction);
        transaction.setPrev(end);
        end = transaction;
        listSize++;
    }

    @Override
    public void deleteTransactionById(UUID id) {
        Transaction tmp = begin;
        while (tmp != null) {
            if (tmp.getId() == id) {
                if (tmp.getNext() == null && tmp.getPrev() == null) {
                    begin = null;
                    end = null;
                } else {
                    if (tmp.getPrev() != null) {
                        tmp.getPrev().setNext(tmp.getNext());
                    } else {
                        begin = tmp.getNext();
                        begin.setPrev(null);
                    }
                    if (tmp.getNext() != null) {
                        tmp.getNext().setPrev(tmp.getPrev());
                    } else {
                        end = tmp.getPrev();
                        end.setNext(null);
                    }
                }
                listSize--;
                return;
            }
            tmp = tmp.getNext();
        }
        throw new TransactionNotFoundException();
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] transactions = new Transaction[listSize];
        Transaction tmp = begin;
        int i = 0;

        while (tmp != null) {
            transactions[i] = tmp;
            tmp = tmp.getNext();
            i++;
        }
        return (transactions);
    }
}
