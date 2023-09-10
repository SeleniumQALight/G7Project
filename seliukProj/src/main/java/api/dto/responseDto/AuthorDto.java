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

//    public AuthorDto(String username) {
//        this.username = username;
//    }

//    public AuthorDto() {
//    }

//    public AuthorDto(String username) {
//        this.username = username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setAvatar(String avatar) {
//        this.avatar = avatar;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getAvatar() {
//        return avatar;
//    }
//
//
//
//
//    public String toString() {
//        return "AuthorDto{" +
//                "username='" + username + '\'' +
//                ", avatar='" + avatar + '\'' +
//                '}';
//    }
}
