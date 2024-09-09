package exercise.controller;

import java.util.List;

import exercise.dto.*;
import exercise.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BookService bookService;

    // BEGIN
    @GetMapping(path = "")
    public List<BookDTO> index() {
        return bookService.getAll();
    }

    @GetMapping(path = "/{id}")
    public BookDTO show(@PathVariable("id") Long id) {
        return bookService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "")
    public BookDTO create(@RequestBody @Valid BookCreateDTO bookCreateDTO) {
        return bookService.create(bookCreateDTO);
    }

    @PutMapping(path = "/{id}")
    public BookDTO update(@PathVariable("id") Long id, @RequestBody @Valid BookUpdateDTO bookUpdateDTO) {
        return bookService.update(id, bookUpdateDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        bookService.delete(id);
    }
    // END
}
