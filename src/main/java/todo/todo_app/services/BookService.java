package todo.todo_app.services;

import todo.todo_app.models.BookModel;

import java.util.List;

public interface BookService {

    List<BookModel> getAllBook();
    BookModel createBook(BookModel bookmodel);
    BookModel updateBookById(Long id, BookModel bookmodel);
    void deleteBookById(Long id);
}
