package demoQA;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BookDTO {
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
