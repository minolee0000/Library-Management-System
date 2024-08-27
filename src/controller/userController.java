package controller;

import java.util.ArrayList;

import Service.ServiceFactory;
import adminServices.UserService;
import dto.UserDto;

public class userController {
    private static UserService userService = (UserService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.USER);

    public static String save(UserDto dto) throws Exception{
        return userService.save(dto);
    }

    public static String delete(String userID) throws Exception{
        return userService.delete(userID);
    }

    public static String update (UserDto dto) throws Exception{
        System.out.println("Samin");
        return userService.update(dto);
    }

    public static UserDto get (String id) throws Exception{
        return userService.get(id);
    }
    public static ArrayList<UserDto> getAll()throws Exception{
        return userService.getAll();
    }
    
}
