package lab8.msherwood.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
// this will declare what the table name is
@Table(name="AUTHOR")
@NoArgsConstructor
public class Author {
// default constructor that will take in a authors first and last name
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        bookList = new ArrayList<>();
    }

    
// this is where the table coloumn has it's values
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="AUTHOR_ID")
    private Integer authorId;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @OneToMany
    @JoinColumn(name="AUTHOR_ID")
    List<Book> bookList;

    


    
}
