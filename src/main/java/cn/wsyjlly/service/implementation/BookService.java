package cn.wsyjlly.service.implementation;

import cn.wsyjlly.entity.Book;
import cn.wsyjlly.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wsyjlly
 * @create 2019.06.17 - 19:44
 **/
@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;
    public int  addBook(Book book){
        return bookMapper.addBook(book);
    }
    public int updateBook(Book book){
        return bookMapper.updateBookById(book);
    }
    public int deleteBook(Integer id){
        return bookMapper.deleteBookById(id);
    }
    public Book getBookById(Integer id){
        return bookMapper.getBookById(id);
    }
    public List<Book> getAllBooks(){
        return bookMapper.getAllBooks();
    };
}
