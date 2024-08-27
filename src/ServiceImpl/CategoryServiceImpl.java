package ServiceImpl;

import java.util.ArrayList;

import Entity.CategoryEntity;
import adminServices.CategoryService;
import dao.DaoFactory;
import daoCustom.CategoryDao;
import dto.CategoryDto;

public class CategoryServiceImpl implements CategoryService{

    private CategoryDao categoryDao = (CategoryDao)DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CATEGORY);

    @Override
    public String save(CategoryDto categoryDto) throws Exception {
        CategoryEntity entity = getCategoryEntity(categoryDto);
        System.out.println("Success");
        return categoryDao.create(entity) ? "success" : "Fail"; 
    }

    @Override
    public String update(CategoryDto categoryDto) throws Exception {
        CategoryEntity entity = getCategoryEntity(categoryDto);
        return categoryDao.update(entity) ? "success" : "Fail";
    }

    @Override
    public String delete(String categoryID) throws Exception {
       return categoryDao.delete(categoryID) ? "success" : "Fail";
    }

    @Override
    public CategoryDto get(String userID) throws Exception {
        CategoryEntity entity = categoryDao.get(userID);
        if (entity != null){
            return getCategoryDto(entity);
        }
        return null;
    }

    @Override
    public ArrayList<CategoryDto> getAll() throws Exception {
        ArrayList <CategoryEntity> entities = categoryDao.getAll();

        if (entities != null && !entities.isEmpty() ){
            ArrayList <CategoryDto> dtos = new ArrayList<>();
            for (CategoryEntity entity : entities){
                dtos.add(getCategoryDto(entity));
            }
            return dtos;
        }
        return null;
    }

    private CategoryEntity getCategoryEntity(CategoryDto dto){
        return new CategoryEntity(dto.getCategoryID(),
                                dto.getCategoryName(),
                                dto.getQtyOfBooks());

    }

    private CategoryDto getCategoryDto(CategoryEntity entity){
        return new CategoryDto((entity.getCategoryID()),entity.getCategoryName() ,entity.getQtyOfBooks());
    }
    
}
