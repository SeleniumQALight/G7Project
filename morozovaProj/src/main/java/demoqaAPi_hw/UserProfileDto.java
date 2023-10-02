package demoqaAPi_hw;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserProfileDto {
    String userId;
    String username;
    List<BookDTO> books;
}
