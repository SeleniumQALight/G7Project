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
    String select;
    String uniquePost;
    String createdDate;
    AuthorDto author;
    Boolean isVisitorOwner;

//    public PostDto() {
//    }

//    public PostDto(String title, String body, String select1, String uniquePost, AuthorDto author, Boolean isVisitorOwner) {
//        this.title = title;
//        this.body = body;
//        this.select1 = select1;
//        this.uniquePost = uniquePost;
//        this.author = author;
//        this.isVisitorOwner = isVisitorOwner;
//    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String _id) {
//        this.id = _id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public String getSelect1() {
//        return select1;
//    }
//
//    public void setSelect1(String select1) {
//        this.select1 = select1;
//    }
//
//    public String getUniquePost() {
//        return uniquePost;
//    }
//
//    public void setUniquePost(String uniquePost) {
//        this.uniquePost = uniquePost;
//    }
//
//    public String getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(String createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public AuthorDto getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(AuthorDto author) {
//        this.author = author;
//    }
//
//    public Boolean getIsVisitorOwner() {
//        return isVisitorOwner;
//    }
//
//    public void setIsVisitorOwner(Boolean visitorOwner) {
//        isVisitorOwner = visitorOwner;
//    }
//
//    @Override
//    public String toString() {
//        return "PostDto{" +
//                "_id='" + id + '\'' +
//                ", title='" + title + '\'' +
//                ", body='" + body + '\'' +
//                ", select1='" + select1 + '\'' +
//                ", uniquePost='" + uniquePost + '\'' +
//                ", createdDate='" + createdDate + '\'' +
//                ", author=" + author +
//                ", isVisitorOwner=" + isVisitorOwner +
//                '}';
//    }
}
