package ServiceImpl;

import java.util.ArrayList;

import Entity.UserEntity;
import adminServices.UserService;
import dao.DaoFactory;
import daoCustom.UserDao;
import dto.UserDto;

public class UserServiceImpl implements UserService {
    private UserDao userDao = (UserDao)DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.USER);

    @Override
    public String save(UserDto userDto) throws Exception {
        UserEntity entity = getUserEntity(userDto);
        return userDao.create(entity) ? "success":"Fail";
    }

    @Override
    public String update(UserDto userDto) throws Exception {
        UserEntity entity = getUserEntity(userDto);
        return userDao.update(entity) ? "success":"Fail";
    }

    @Override
    public String delete(String userID) throws Exception {
        return userDao.delete(userID) ? "success" : "Fail";
    }

    @Override
    public UserDto get(String userID) throws Exception {
        UserEntity entity = userDao.get(userID);
    if (entity !=null){
        return getUserDto(entity);
    }
    return null;
    }

    @Override
    public ArrayList<UserDto> getAll() throws Exception {
        ArrayList <UserEntity> userEntities = userDao.getAll();
        if (userEntities != null && !userEntities.isEmpty()){
            ArrayList <UserDto> userDtos = new ArrayList<>();
            for (UserEntity userEntity : userEntities ){
                userDtos.add(getUserDto(userEntity));
            }
            return userDtos;
        }
        return null;
    }

    private UserEntity getUserEntity(UserDto userDto){
        return new UserEntity(
            userDto.getId(),
            userDto.getName(),
            userDto.getAddress(),
            userDto.getContact_number(),
            userDto.getJoinedDate() );
    }

    private UserDto getUserDto(UserEntity userEntity){
        return new UserDto(
            userEntity.getId(),
            userEntity.getName(),
            userEntity.getAddress(),
            userEntity.getContact_number(),
            userEntity.getJoinedDate());
    }
}
