package api.dto.responseDto;

import lombok.*;

@NoArgsConstructor //generate constructor
@AllArgsConstructor //generate constructor with parameter
@Getter //generate getter and setter
@Setter //generate getter and setter
@ToString //generate toString
@Builder //generate builder
public class AuthorDto {
    String username;
    String avatar;

//    public AuthorDto() { // default constructor
//    }

//    public AuthorDto(String username) { // constructor with parameter
//        this.username = username;
//    }

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getAvatar() {
//        return avatar;
//    }
//
//    public void setAvatar(String avatar) {
//        this.avatar = avatar;
//    }

//    @Override
//    public String toString() {
//        return "AuthorDto{" +
//                "username='" + username + '\'' +
//                ", avatar='" + avatar + '\'' +
//                '}';
//    }
}
