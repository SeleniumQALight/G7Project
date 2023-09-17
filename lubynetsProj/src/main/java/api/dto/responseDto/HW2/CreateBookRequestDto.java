package api.dto.responseDto.HW2;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CreateBookRequestDto {
    private String userId;
    private String isbn;
}