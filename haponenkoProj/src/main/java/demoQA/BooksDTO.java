package demoQA;

import lombok.*;

import java.awt.print.Book;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BooksDTO {
    String isbn;
    String title;
    String subTitle;
    String author;
    String publish_date;
    String publisher;
    Integer pages;
    String description;
    String website;
}
