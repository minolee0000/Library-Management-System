package Service;

import ServiceImpl.UserServiceImpl;
import ServiceImpl.CategoryServiceImpl;
import ServiceImpl.BookServiceImpl;

public class ServiceFactory {
   
    private static ServiceFactory serviceFactory;
    
    private ServiceFactory() {
    }
        
    public static ServiceFactory getInstance(){
        if(serviceFactory == null){
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public SuperService getService (ServiceType serviceType){
        switch (serviceType){
            case USER:
                return new UserServiceImpl();
            case CATEGORY:
                return new CategoryServiceImpl();
            case BOOK:
                return new BookServiceImpl();
            default :
                return null;
        }
    }

    public enum ServiceType {
        USER,CATEGORY,BOOK
    }
}
