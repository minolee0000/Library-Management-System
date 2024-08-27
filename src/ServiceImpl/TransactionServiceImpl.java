package ServiceImpl;

import java.util.ArrayList;
import Entity.TransactionEntity;
import adminServices.TransactionService;
import dao.DaoFactory;
import daoCustom.TransactionDao;
import dto.TransactionDto;

public class TransactionServiceImpl implements TransactionService{
    private TransactionDao transactionDao = (TransactionDao)DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.TRANSACTION);

    private TransactionEntity getTransactionEntity(TransactionDto dto){
        return new TransactionEntity(dto.getTransactionID(),
                                dto.getBookID(),
                                dto.getUserID(),
                                dto.getReleasedDate());

    }

    private TransactionDto getTransactionDto(TransactionEntity entity){
        return new TransactionDto((entity.getTransactionID()),
                                    entity.getBookID() ,
                                    entity.getUserID(),
                                    entity.getReleasedDate(),
                                    entity.getFine());
    }

    @Override
    public String save(TransactionDto transactionDto) throws Exception {
        TransactionEntity entity = getTransactionEntity(transactionDto);
        return transactionDao.create(entity) ? "success" : "fail";
    }

    @Override
    public String update(TransactionDto transactionDto) throws Exception {
        TransactionEntity entity = getTransactionEntity(transactionDto);
        return transactionDao.update(entity) ? "success" : "fail";
    }

    @Override
    public String delete(String transactionID) throws Exception {
        return transactionDao.delete(transactionID) ? "success" : "fail";
    }

    @Override
    public TransactionDto get(String userID) throws Exception {
         TransactionEntity entity = transactionDao.get(userID);
         if (entity != null){
            return  getTransactionDto(entity);
         }
        return null;
    }

    @Override
    public ArrayList<TransactionDto> getAll() throws Exception {
        ArrayList <TransactionEntity> entities = transactionDao.getAll();
        if (entities != null && !entities.isEmpty()){
            ArrayList <TransactionDto> dtos = new ArrayList<>();
            for (TransactionEntity entity : entities){
                dtos.add(getTransactionDto(entity));
            }
            return dtos;
        }
        return null;
    }
}
