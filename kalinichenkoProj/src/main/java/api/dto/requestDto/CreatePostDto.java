package api.dto.requestDto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CreatePostDto {
    private String title;
    private String body;
    private String select1;
    private String uniquePost;
    private String token;

}
