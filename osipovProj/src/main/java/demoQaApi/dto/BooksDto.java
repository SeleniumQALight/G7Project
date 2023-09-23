package demoQaApi.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BooksDto {
    BooksDetailsDto[] books;
}
