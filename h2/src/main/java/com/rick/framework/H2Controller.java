/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: H2Controller
 * Author:   ywang7
 * Date:     2018/6/26 13:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.rick.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ywang7
 * @create 2018/6/26
 * @since 1.0.0
 */
@RestController
public class H2Controller {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/books")
    @CrossOrigin
    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    @RequestMapping("/book/{bookId}")
    @CrossOrigin
    public Optional<Book> getOne(@PathVariable Long bookId){
        return bookRepository.findById(bookId);
    }
}
