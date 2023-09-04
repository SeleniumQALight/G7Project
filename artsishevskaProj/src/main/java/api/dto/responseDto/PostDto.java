package api.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostDto {//описати структуру поста
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
    public PostDto() {
    }

    public PostDto(String title, String body, String select, String uniquePost, AuthorDto author, Boolean isVisitorOwner) {
        this.title = title;
        this.body = body;
        this.select = select;
        this.uniquePost = uniquePost;
        this.author = author;
        this.isVisitorOwner = isVisitorOwner;
    }

    public String getid() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getSelect() {
        return select;
    }

    public String getUniquePost() {
        return uniquePost;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public Boolean getIsVisitorOwner() {
        return isVisitorOwner;
    }

    public void setid(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public void setUniquePost(String uniquePost) {
        this.uniquePost = uniquePost;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public void setIsVisitorOwner(Boolean visitorOwner) {
        isVisitorOwner = visitorOwner;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", select='" + select + '\'' +
                ", uniquePost='" + uniquePost + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", author=" + author +
                ", isVisitorOwner=" + isVisitorOwner +
                '}';
    }
}
