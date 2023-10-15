package BooksDemoqa.BooksDto;

import lombok.*;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Setter

@ToString
@Builder


public class AllBooksDto {
        List <BooksDto> books;

        public List<BooksDto> getBooks() {
                return books;
        }
}

// GET https://demoqa.com/BookStore/v1/Books

//"books": [
//        {
//        "isbn": "9781449325862",
//        "title": "Git Pocket Guide",
//        "subTitle": "A Working Introduction",
//        "author": "Richard E. Silverman",
//        "publish_date": "2020-06-04T08:48:39.000Z",
//        "publisher": "O'Reilly Media",
//        "pages": 234,
//        "description": "This pocket guide is the perfect on-the-job companion to Git, the distributed version control system. It provides a compact, readable introduction to Git for new users, as well as a reference to common commands and procedures for those of you with Git exp",
//        "website": "http://chimera.labs.oreilly.com/books/1230000000561/index.html"
//        },
//        {
//        "isbn": "9781449331818",