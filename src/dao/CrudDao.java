package dao;

import java.util.ArrayList;

public interface CrudDao <T, ID> extends SuperDao {
    boolean create (T t) throws Exception;
    boolean update (T t) throws Exception;
    boolean delete (String id) throws Exception;
    T get (String id) throws Exception;
    ArrayList <T> getAll() throws Exception;
}
