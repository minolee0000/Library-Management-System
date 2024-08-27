package adminServices;

import java.util.ArrayList;

import Service.SuperService;
import dto.BookDto;


public interface BookService extends SuperService  {
    String save(BookDto dto) throws Exception ;
    String update(BookDto dto) throws Exception;
    String delete(String bookID ) throws Exception;
    BookDto get(String bookID) throws Exception;
    ArrayList<BookDto> getAll() throws Exception;
}
