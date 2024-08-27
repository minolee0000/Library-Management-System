package adminServices;

import java.util.ArrayList;

import Service.SuperService;
import dto.TransactionDto;

public interface TransactionService extends SuperService{
    String save(TransactionDto transactionDto) throws Exception ;
    String update(TransactionDto transactionDto) throws Exception;
    String delete(String transactionID ) throws Exception;
    TransactionDto get(String userID) throws Exception;
    ArrayList<TransactionDto> getAll() throws Exception;
}
