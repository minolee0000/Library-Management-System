package adminServices;

import java.util.ArrayList;

import Service.SuperService;
import dto.CategoryDto;


public interface CategoryService extends SuperService {
    String save(CategoryDto categoryDto) throws Exception ;
    String update(CategoryDto categoryDto) throws Exception;
    String delete(String categoryID ) throws Exception;
    CategoryDto get(String categoryID) throws Exception;
    ArrayList<CategoryDto> getAll() throws Exception;
}
