package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.LimitExceeded;

public class Controller {
    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save(Transaction transaction) throws Exception {
        return transactionDAO.save(transaction);
    }

    Transaction[] transactionList()throws Exception{
        return transactionDAO.transactionList();
    }

    Transaction[] transactionList(String city) throws Exception{
        return transactionDAO.transactionList(city);
    }

    Transaction[] transactionList(int amount) throws Exception{
        return transactionDAO.transactionList(amount);
    }
}
