package controller;

import java.util.ArrayList;
import Service.ServiceFactory;
import adminServices.TransactionService;
import dto.TransactionDto;

public class TransactionController {
        private static TransactionService transactionService= (TransactionService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.TRANSACTION);

    public static String save(TransactionDto dto) throws Exception{
        return transactionService.save(dto);
    }

    public static String delete(String transactionID) throws Exception{
        return transactionService.delete(transactionID);
    }

    public static String update (TransactionDto dto) throws Exception{
        return transactionService.update(dto);
    }

    public static TransactionDto get (String id) throws Exception{
        return transactionService.get(id);
    }
    public static ArrayList<TransactionDto> getAll()throws Exception{
        return transactionService.getAll();
    }
}
