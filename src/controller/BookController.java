package controller;

import java.util.ArrayList;

import Service.ServiceFactory;
import adminServices.BookService;
import dto.BookDto;

public class BookController {
    private static BookService bookService= (BookService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.BOOK);

    public static String save(BookDto dto) throws Exception{
        return bookService.save(dto);
    }

    public static String delete(String bookID) throws Exception{
        return bookService.delete(bookID);
    }

    public static String update (BookDto dto) throws Exception{
        return bookService.update(dto);
    }

    public static BookDto get (String id) throws Exception{
        return bookService.get(id);
    }
    public static ArrayList<BookDto> getAll()throws Exception{
        return bookService.getAll();
    }
}
