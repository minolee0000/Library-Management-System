package controller;

import java.util.ArrayList;

import Service.ServiceFactory;
import adminServices.CategoryService;
import dto.CategoryDto;

public class CategoryController {
    private static CategoryService categoryService = (CategoryService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CATEGORY);

    public static String save(CategoryDto dto) throws Exception{
        return categoryService.save(dto);
    }

    public static String delete(String categoryID) throws Exception{
        return categoryService.delete(categoryID);
    }

    public static String update (CategoryDto dto) throws Exception{
        return categoryService.update(dto);
    }

    public static CategoryDto get (String id) throws Exception{
        return categoryService.get(id);
    }
    public static ArrayList<CategoryDto> getAll()throws Exception{
        return categoryService.getAll();
    }
}
