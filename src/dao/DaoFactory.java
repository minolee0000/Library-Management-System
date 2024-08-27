package dao;

import daoImpl.BookDaoImpl;
import daoImpl.CategoryDaoImpl;
import daoImpl.UserDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    
    private DaoFactory(){}
    
    public static DaoFactory getInstance(){
        if (daoFactory == null){
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }
    
    public SuperDao getDao(DaoTypes type){
        
        switch (type) {
            case USER:
                return new UserDaoImpl();
            case CATEGORY:
                return new  CategoryDaoImpl();
            case BOOK:
                return new BookDaoImpl();
            default: 
                return null;
        }
    
    }
    
    public enum DaoTypes{
        USER, CATEGORY,BOOK
    }
}
