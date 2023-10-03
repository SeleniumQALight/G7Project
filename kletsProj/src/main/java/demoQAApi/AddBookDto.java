package demoQAApi;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class AddBookDto {
    String userId;
    CollectionOfIsbnsDto[] collectionOfIsbns;
}
