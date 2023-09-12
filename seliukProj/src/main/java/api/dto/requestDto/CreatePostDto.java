package api.dto.requestDto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class CreatePostDto {
    String title;
    String body;
    String select1;
    String uniquePost;
    String token;

}
