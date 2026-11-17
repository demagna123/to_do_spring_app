package todo.todo_app.controllers;

import org.springframework.web.bind.annotation.*;
import todo.todo_app.models.BookModel;
import todo.todo_app.services.implementions.BookServiceImplementation;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("books/")
public class BookController {

    private final BookServiceImplementation bookServiceImplementation;

    public BookController (BookServiceImplementation bookServiceImplementation){
        this.bookServiceImplementation = bookServiceImplementation;
    }
    @GetMapping("/list")
    public List<BookModel> getAllBook(){

        return  bookServiceImplementation.getAllBook();
    }
    @PostMapping("/create")
    public  BookModel createBook( @RequestBody  BookModel bookModel){

        return bookServiceImplementation.createBook(bookModel);
    }

    @PutMapping("/update/{id}")
    public BookModel updateBookById(@PathVariable Long id, @RequestBody BookModel bookModel){

        return  bookServiceImplementation.updateBookById(id, bookModel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBookById(@PathVariable Long id){

         bookServiceImplementation.deleteBookById(id);
    }
}
