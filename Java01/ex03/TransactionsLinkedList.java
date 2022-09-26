import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    private int listSize = 0;
    private TransactionNode begin = new TransactionNode(null, null, null);
    private TransactionNode end = new TransactionNode(null, null, null);

    public TransactionsLinkedList() {
        begin.setNext(end);
        end.setPrev(begin);
    }

    @Override
    public void addTransaction(Transaction transaction) {
        begin.setNext(new TransactionNode(begin.getNext(), begin, transaction));
        listSize++;
    }

    @Override
    public void deleteTransactionById(UUID id) {
        TransactionNode tmp = begin.getNext();
        while (tmp != end) {
            if (tmp.getData().getIdentifier() == id) {
                tmp.getPrev().setNext(tmp.getNext());
                tmp.getNext().setPrev(tmp.getPrev());
                tmp.setNext(null);
                tmp.setPrev(null);
                tmp.setData(null);
                listSize--;
                return;
            }
            tmp = tmp.getNext();
        }
        throw new TransactionNotFoundException();
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] tmp = new Transaction[listSize];
        TransactionNode tmpNode = begin.getNext();

        if (tmpNode.getData() != null) {
            for (int i = 0; i < listSize; i++) {
                tmp[i] = tmpNode.getData();
                tmpNode = tmpNode.getNext();
            }
        }
        return (tmp);
    }

    private static class TransactionNode {
        private TransactionNode next;
        private TransactionNode prev;
        private Transaction data;

        public TransactionNode(TransactionNode next, TransactionNode prev, Transaction data) {
            this.next = next;
            this.prev = prev;
            this.data = data;
        }

        public TransactionNode getNext() {
            return (next);
        }

        public void setNext(TransactionNode next) {
            this.next = next;
        }

        public TransactionNode getPrev() {
            return (prev);
        }

        public void setPrev(TransactionNode prev) {
            this.prev = prev;
        }

        public Transaction getData() {
            return (data);
        }

        public void setData(Transaction data) {
            this.data = data;
        }
    }
}
