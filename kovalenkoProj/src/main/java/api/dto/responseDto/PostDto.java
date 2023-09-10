package api.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PostDto {
    @JsonProperty("_id")
    String id;
    String title;
    String body;
    @JsonProperty("select1")
    String select1;
    String uniquePost;
    String createdDate;
    AuthorDto author;
    Boolean isVisitorOwner;

    public PostDto(String title, String body, String select1, String uniquePost, AuthorDto author, Boolean isVisitorOwner) {
        this.title = title;
        this.body = body;
        this.select1 = select1;
        this.uniquePost = uniquePost;
        this.author = author;
        this.isVisitorOwner = isVisitorOwner;
    }

    public String getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public AuthorDto getAuthor() {
        return author;
    }


}
