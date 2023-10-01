package demoqaAPi_hw;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AddBookDTO {
    String userId;
    CollectionOfIsbnsDto[] collectionOfIsbns;
}