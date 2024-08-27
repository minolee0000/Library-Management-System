package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.UserEntity;
import dao.CrudUtil;
import daoCustom.UserDao;
import db.DBConnection;

public class UserDaoImpl implements UserDao{

    @Override
    public boolean create(UserEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO User VALUES(?,?,?,?,?)", t.getId(), t.getName(), t.getAddress(),t.getContact_number() ,
                t.getJoinedDate());
    }

    @Override
    public boolean update(UserEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE User SET userName = ?, address = ?, contactNumber = ?, joinedDate = ? WHERE userID = ? ", t.getName(), t.getAddress(),t.getContact_number() ,
                t.getJoinedDate(),t.getId()) ;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM user WHERE userID =?", id);
    }

    @Override
    public UserEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM User WHERE UserID = ?", id);
        if(rst.next()){
            UserEntity entity = new UserEntity (rst.getString("userID"), 
                    rst.getString("userName"), rst.getString("address"), 
                    rst.getString("contactNumber"), 
                    rst.getString("joinedDate"));
            return entity;
        }
        return null;
    }

    @Override
    public ArrayList<UserEntity> getAll() throws Exception {
        ArrayList <UserEntity> userEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM User");
        while(rst.next()){
            UserEntity entity = new UserEntity(rst.getString("userID"), 
                    rst.getString("userName"), rst.getString("address"), 
                    rst.getString("contactNumber"), 
                    rst.getString("joinedDate"));
                    
        
            userEntities.add(entity);
        }
        return userEntities;
    }
   
    public ArrayList<UserEntity> getAllUsers() throws ClassNotFoundException,SQLException{
        PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM user");
        ResultSet userSet = statement.executeQuery();

        ArrayList  <UserEntity> userList = new ArrayList<UserEntity>();

        while ( userSet.next()){
            UserEntity entities = new UserEntity (userSet.getString(1),userSet.getString(2),
            userSet.getString(3),userSet.getString(4),userSet.getString(5));

            userList.add(entities);
        }
        return userList;

    }
}
