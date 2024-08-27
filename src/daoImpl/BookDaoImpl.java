package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import Entity.BookEntity;
import dao.CrudUtil;
import daoCustom.BookDao;

public class BookDaoImpl implements BookDao {

    @Override
    public boolean create(BookEntity t) throws Exception {
       return CrudUtil.executeUpdate("INSERT INTO  Book VALUES (?,?,?,?)" ,t.getBookID(),t.getBookName(),t.getAuthor(),t.getAvailability());
    }

    @Override
    public boolean update(BookEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Book set bookName = ?, Author = ?, Availability = ? WHERE bookID = ?", t.getBookName(),t.getAuthor(),t.getAvailability(),t.getBookID());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM Book WHERE BookID = ?", id);
    }

    @Override
    public BookEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Book WHERE bookID = ?", id);
        if (rst.next()){
            BookEntity entity = new BookEntity(rst.getString("bookID"),
                                                rst.getString("bookName"),
                                                rst.getString("Author"),
                                                rst.getBoolean("Availability"));
            return entity; 
        }
        return null;
    }

    @Override
    public ArrayList<BookEntity> getAll() throws Exception {
        ArrayList <BookEntity> bookEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Book");

        while(rst.next()){
            BookEntity entity = new BookEntity(rst.getString("bookID"),
                                                        rst.getString("bookName"),
                                                        (rst.getString("Author")),rst.getBoolean("Availability"));

            bookEntities.add(entity);    
        }
        return bookEntities;
    }
    
}
