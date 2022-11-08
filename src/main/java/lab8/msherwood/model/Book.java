package lab8.msherwood.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
// table name
@Table(name="BOOK")
@NoArgsConstructor
public class Book {

    public Book( String title, String year) {
        this.bookId = 0;
        this.bookTitle = title;
        this.year = year;
    }
// this is where the table column get's its data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BOOK_ID")
    private Integer bookId;

    @Column(name="BOOK_TITLE")
    private String bookTitle;

    @Column(name="BOOK_YEAR")
    private String year;

    

    
}
