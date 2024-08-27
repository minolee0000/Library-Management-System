package daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import Entity.CategoryEntity;
import dao.CrudUtil;
import daoCustom.CategoryDao;

public class CategoryDaoImpl implements CategoryDao {

    @Override
    public boolean create(CategoryEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO  bookcategory VALUES (?,?,?)" ,t.getCategoryID(),t.getCategoryName(),t.getQtyOfBooks()) ;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM bookcategory WHERE categoryID = ?", id);
    }

    @Override
    public CategoryEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM bookcategory WHERE categoryID = ?",id);
        while (rst.next()){
            CategoryEntity entity = new CategoryEntity(rst.getString("categoryID"),
                                                rst.getString("categoryName"),
                                                rst.getInt("quantityOfBooks"));
            return entity;
        }
        return null;
    }

    @Override
    public ArrayList<CategoryEntity> getAll() throws Exception{
        ArrayList <CategoryEntity> categoryEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM bookcategory");

        while(rst.next()){
            CategoryEntity entity = new CategoryEntity(rst.getString("categoryID"),
                                                        rst.getString("categoryName"),
                                                        (rst.getInt("quantityOfBooks")));

            categoryEntities.add(entity);
            
        }
        return categoryEntities;
    }

    @Override
    public boolean update(CategoryEntity t) throws Exception {
       return CrudUtil.executeUpdate("UPDATE bookcategory SET categoryName = ? , quantityOfBooks = ? WHERE categoryID = ?", t.getCategoryName(),t.getQtyOfBooks(),t.getCategoryID());
    }
    
}


