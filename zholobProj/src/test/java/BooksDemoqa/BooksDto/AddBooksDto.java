package BooksDemoqa.BooksDto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder


public class AddBooksDto {
     String userId;
    CollectionOfIsbnsDto[] collectionOfIsbns;

}

// POST https://demoqa.com/BookStore/v1/Books
// addBook
//      { "userId": "077b1a12-9196-4ef9-a35b-f14c6dcb0057",
//        "collectionOfIsbns":
//        [ { "isbn": "9781449325862" } ] }
// RESPONSE:
//        {{
//    "books": [
//        {
//            "isbn": "9781449325862"
//        }
//             ]
//        }