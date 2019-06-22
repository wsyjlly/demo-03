package cn.wsyjlly.mapper;

import cn.wsyjlly.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wsyjlly
 * @create 2019.06.17 - 19:23
 **/
@Mapper
public interface BookMapper {
    int addBook(Book book);
    int deleteBookById(Integer id);
    int updateBookById(Book book);
    Book getBookById(Integer id);
    List<Book> getAllBooks();

}
