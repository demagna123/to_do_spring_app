package todo.todo_app.services.implementions;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import todo.todo_app.models.BookModel;
import todo.todo_app.repositories.BookRepository;

import java.util.List;

@Transactional
@Service
public class BookServiceImplementation {
    private final BookRepository bookRepository;

    public BookServiceImplementation (BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<BookModel> getAllBook(){
        return  bookRepository.findAll();
    }

    public  BookModel createBook(BookModel bookModel){
        return bookRepository.save(bookModel);
    }

    public  BookModel updateBookById(Long id,  BookModel bookModel){
        BookModel book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Livre non trouvé") );

        book.setName(bookModel.getName());
        book.setDescription(bookModel.getDescription());
      return   bookRepository.save(book);
    }

    public  void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }
}

