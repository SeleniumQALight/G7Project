package demoQAApi;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class AllBooksDto {
    List<BooksDetailsDto> books;

}
