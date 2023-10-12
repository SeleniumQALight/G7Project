package BooksDemoqa.BooksDto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class UserBooksDto {
    String userId;
    String username;
    List<BooksDto> books;


}

// GET https://demoqa.com/Account/v1/User/{userId}
// RESPONSE:
//{
//        "userId": "077b1a12-9196-4ef9-a35b-f14c6dcb0057",
//        "username": "inna",
//        "books": [
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
//        }
//        ]
//        }