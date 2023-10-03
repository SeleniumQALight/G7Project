package bookStore.respossDto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class AllBooksApiDto {
    List<AboutBooksDto> books;
}
