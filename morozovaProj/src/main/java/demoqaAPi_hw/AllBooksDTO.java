package demoqaAPi_hw;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AllBooksDTO {
    List<BookDTO> books;
}
