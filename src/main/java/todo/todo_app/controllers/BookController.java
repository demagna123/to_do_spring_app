package todo.todo_app.controllers;

import org.springframework.web.bind.annotation.*;
import todo.todo_app.models.BookModel;
import todo.todo_app.services.implementions.BookService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("books/")
public class BookController {

    private final BookService bookService;

    public BookController (BookService bookService){
        this.bookService = bookService;
    }
    @GetMapping("/list")
    public List<BookModel> getAllBook(){

        return  bookService.getAllBook();
    }
    @PostMapping("/create")
    public  BookModel createBook( @RequestBody  BookModel bookModel){

        return bookService.createBook(bookModel);
    }

    @PutMapping("/update/{id}")
    public BookModel updateBookById(@PathVariable Long id, @RequestBody BookModel bookModel){

        return  bookService.updateBookById(id, bookModel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBookById(@PathVariable Long id){

         bookService.deleteBookById(id);
    }
}
