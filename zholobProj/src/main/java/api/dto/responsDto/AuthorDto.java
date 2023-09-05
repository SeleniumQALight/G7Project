package api.dto.responsDto;

public class AuthorDto {

    String username;
    String avatar;

    public AuthorDto() { // пустий конструктор
    }

    public AuthorDto(String username) { // конструктор тільки по юзернейму
        this.username = username;
    }

    // гетери і сетери для всіх полів описаних вище
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() { // перевизначаємо метод toString для виводу в консоль
        return "AuthorDto{" +
                "username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
