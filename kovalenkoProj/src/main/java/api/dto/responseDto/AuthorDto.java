package api.dto.responseDto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class AuthorDto {
    String username;
    String avatar;

    public String getUsername() {
        return username;
    }



    public AuthorDto(String username) {
        this.username = username;
    }


}
