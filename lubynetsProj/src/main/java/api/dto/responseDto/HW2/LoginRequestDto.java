package api.dto.responseDto.HW2;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class LoginRequestDto {
    private String userName;
    private String password;
}