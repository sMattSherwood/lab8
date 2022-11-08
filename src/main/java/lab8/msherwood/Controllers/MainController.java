package lab8.msherwood.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lab8.msherwood.model.Author;
import lab8.msherwood.model.Book;
import lab8.msherwood.repos.AuthorRepo;
import lab8.msherwood.repos.BookRepo;

@Controller

public class MainController {
    
    AuthorRepo authorRepo;
    BookRepo bookRepo;

    @Autowired
    public MainController(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    
// declaring an object of Author and passing the values of thier first and last name thorugh the constructor
    Author fred = authorRepo.save(new Author("Fred", "Flintstone"));
    Author wilma = authorRepo.save(new Author("Wilma", "FlintStone"));
    Author barney = authorRepo.save(new Author("Barney", "Rubble"));

// this will suppress any errors that it is un used data
    @SuppressWarnings("unused")
    Author betty = authorRepo.save(new Author("Betty", "Rubble"));
// this will add data to our objects of author and allow them to have a title and date attibuted to thier works
    wilma.getBookList().add(bookRepo.save(new Book("how to trian your dino", "1999 bc")));
    fred.getBookList().add(bookRepo.save(new Book("Sticks and Stones", "1998 bc")));
    barney.getBookList().add(bookRepo.save(new Book("How to find the dino", "1996 bc")));
    wilma.getBookList().add(bookRepo.save(new Book("cave repair details", "1991 bc")));
// this will save the data to the objects of author
    authorRepo.save(wilma);
    authorRepo.save(fred);
    authorRepo.save(barney);



}
// this will allow index.html to display the authors and thier books
    @GetMapping("/data")
    public String getData(Model model)
    {
// this creates a list of all of the authors and their books
        List<Author> authorList = (List<Author>)authorRepo.findAll();
        List<Book> bookList = (List<Book>)bookRepo.findAll();

        model.addAttribute("bookList", bookList);
        model.addAttribute("authorList", authorList);

        return "authorPage";
    }
    
}
