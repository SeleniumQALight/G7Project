package bookStore.respossDto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AddBookDTo {
    String UserId;
    CollectionOfIsbnsDto[] collectionOfIsbns;
}
