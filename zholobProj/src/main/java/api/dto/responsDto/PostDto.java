package api.dto.responsDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class PostDto {  //тут описуємо поля які повертає респонс для рест апі
    @JsonProperty("_id")
    String id;
    String title;
    String body;
    @JsonProperty("select1")

    String select;
    String uniquePost;
    String createdDate;
    AuthorDto author; // обєкт автора він має свої поля, які описані в класі AuthorDto
    Boolean isVisitorOwner;

//    public PostDto() { // пустий конструктор
//    }
//   //констуктор по обраним полям ( права кнопка миші -> Generate -> Constructor -> вибираємо поля які хочемо включити в конструктор)
//    public PostDto(String title, String body, String select, String uniquePost, AuthorDto author, Boolean isVisitorOwner) {
//        this.title = title;
//        this.body = body;
//        this.select = select;
////        this.uniquePost = uniquePost;
////        this.author = author;
////        this.isVisitorOwner = isVisitorOwner;
////    }
//// гетери і сетери для всіх полів описаних вище
////    public String getId() {
////        return id;
////    }
////
////    public void setId(String id) {
////        this.id = id;
////    }
////
////    public String getTitle() {
////        return title;
////    }
////
////    public void setTitle(String title) {
////        this.title = title;
////    }
////
////    public String getBody() {
////        return body;
////    }
////
////    public void setBody(String body) {
////        this.body = body;
////    }
////    public PostDto() { // пустий конструктор
// //   }
//
////    public PostDto(String title, String body, String select, String uniquePost, AuthorDto author, Boolean isVisitorOwner) {
////        this.title = title;
////        this.body = body;
////        this.select = select;
////        this.uniquePost = uniquePost;
////        this.author = author;
////        this.isVisitorOwner = isVisitorOwner;
////    }
//
////    public String getId() {
////        return id;
////    }
////
////    public void setId(String id) {
////        this.id = id;
////    }
////
////    public String getTitle() {
////        return title;
////    }
////
////    public void setTitle(String title) {
////        this.title = title;
////    }
////
////    public String getBody() {
////        return body;
////    }
////
////    public void setBody(String body) {
////        this.body = body;
////    }
////
////    public String getSelect1() {
////        return select;
////    }
////
////    public void setSelect1(String select1) {
////        this.select = select1;
////    }
////
////    public String getUniquePost() {
////        return uniquePost;
////    }
////
////    public void setUniquePost(String uniquePost) {
////        this.uniquePost = uniquePost;
////    }
////
////    public String getCreatedDate() {
////        return createdDate;
////    }
////
////    public void setCreatedDate(String createdDate) {
////        this.createdDate = createdDate;
////    }
////
////    public AuthorDto getAuthor() {
////        return author;
////    }
////
////    public void setAuthor(AuthorDto author) {
////        this.author = author;
////    }
////
////    public Boolean getIsVisitorOwner() {
////        return isVisitorOwner;
////    }
////
////    public void setIsVisitorOwner(Boolean visitorOwner) {
////        isVisitorOwner = visitorOwner;
////    }
//
//    @Override
//    public String toString() {
//        return "PostDto{" +
//                "id='" + id + '\'' +
//                ", title='" + title + '\'' +
//                ", body='" + body + '\'' +
//                ", select='" + select + '\'' +
//                ", uniquePost='" + uniquePost + '\'' +
//                ", createdDate='" + createdDate + '\'' +
//                ", author=" + author +
//                ", isVisitorOwner=" + isVisitorOwner +
//                '}';
//    }

}
