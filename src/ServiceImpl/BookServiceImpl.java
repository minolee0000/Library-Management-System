package ServiceImpl;

import java.util.ArrayList;

import Entity.BookEntity;
import adminServices.BookService;
import dao.DaoFactory;
import daoCustom.BookDao;
import dto.BookDto;

public class BookServiceImpl implements BookService {
        private BookDao bookDao = (BookDao)DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.BOOK);

 
    private BookEntity getBookEntity(BookDto dto){
        return new BookEntity(dto.getBookID(),
                                dto.getBookName(),
                                dto.getAuthor(),dto.getAvailability());

    }

    private BookDto getBookDto(BookEntity entity){
        return new BookDto((entity.getBookID()),
                                entity.getBookName() ,
                                entity.getAuthor(),
                                entity.getAvailability());
    }

    @Override
    public String save(BookDto dto) throws Exception {
        BookEntity entity = getBookEntity(dto);
        return bookDao.create(entity) ? "success": "fail";

    }

    @Override
    public String update(BookDto dto) throws Exception {
        BookEntity entity = getBookEntity(dto);
        return bookDao.update(entity) ? "success" : "fail";
    }

    @Override
    public String delete(String bookID) throws Exception {
        return bookDao.delete(bookID) ? "success" : "fail";
    }

    @Override
    public BookDto get(String bookID) throws Exception {
        BookEntity entity = bookDao.get(bookID);
        if (entity != null ){
            return getBookDto(entity);
        }
        return null;
    }

    @Override
    public ArrayList<BookDto> getAll() throws Exception {
        ArrayList <BookEntity> entities = bookDao.getAll();

        if (entities != null && !entities.isEmpty()){
            ArrayList <BookDto> dtos = new ArrayList<>();
            for (BookEntity entity : entities){
                dtos.add(getBookDto(entity));
            }
            return dtos;
        }
        
        return null;
        }
    }

