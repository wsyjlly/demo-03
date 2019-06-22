package cn.wsyjlly.controller;

import cn.wsyjlly.entity.Book;
import cn.wsyjlly.service.implementation.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wsyjlly
 * @create 2019.06.17 - 19:54
 * mybatis
 **/
@RestController
public class BookController {
    @Autowired
    BookService bookService;

    /*
    * 获取所有图书
    * */
    @RequestMapping("/getAll")
    public List<Book> getAllBook(){
         return bookService.getAllBooks();
    }
}
