package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entity.TransactionEntity;
import dao.CrudUtil;
import daoCustom.TransactionDao;
import db.DBConnection;

public class TransactionDaoImpl implements TransactionDao{

    @Override
    public boolean create(TransactionEntity t) throws Exception {
        CrudUtil.executeUpdate("UPDATE Book SET Availability = false WHERE bookID = ?", t.getBookID());
        return CrudUtil.executeUpdate("INSERT INTO transaction VALUES (?,?,?,?,?)", t.getTransactionID(),t.getUserID(),t.getBookID(), t.getReleasedDate(),null);   
    }

    @Override
    public boolean update(TransactionEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE transaction SET  transactionID = ? , bookID = ? , userID = ? , released_date WHERE transactionID = ? " , t.getBookID(), t.getUserID(), t.getReleasedDate(), t.getTransactionID());
    }

    @Override
    public boolean delete(String id) throws Exception {
        CrudUtil.executeUpdate("UPDATE Book SET Availability = true WHERE bookID = ?", id);
        return CrudUtil.executeUpdate("DELETE FROM transaction WHERE transactionID = ?", id);
    }

    @Override
    public TransactionEntity get(String id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public ArrayList<TransactionEntity> getAll() throws Exception {
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM transaction");
        ResultSet rst = statement.executeQuery();
        ArrayList <TransactionEntity> entities = new ArrayList<>();

        while (rst.next()){
           TransactionEntity entity = new TransactionEntity(rst.getString(1),rst.getString(2),
                                                        rst.getString(3),
                                                        rst.getString(4),rst.getDouble(5));
            entities.add(entity);
        }
        return entities;
    }
    
}
