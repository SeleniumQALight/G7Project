package api.dto.responseDto; //DTO stands for Data Transfer Object. It is an object that transports data between different
// processes in an application. A DTO is specifically designed to reduce the number of method calls between client and server by aggregating data.

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostDto { //describe the object
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

    public PostDto() { // default constructor

    }

    public PostDto(String title, String body, String select, String uniquePost, AuthorDto author, Boolean isVisitorOwner) { // generate constructor
        this.title = title;
        this.body = body;
        this.select = select;
        this.uniquePost = uniquePost;
        this.author = author;
        this.isVisitorOwner = isVisitorOwner;
    }

    public String getId() { //generate getter and setter
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getUniquePost() {
        return uniquePost;
    }

    public void setUniquePost(String uniquePost) {
        this.uniquePost = uniquePost;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public Boolean getIsVisitorOwner() {
        return isVisitorOwner;
    }

    public void setIsVisitorOwner(Boolean visitorOwner) {
        isVisitorOwner = visitorOwner;
    }

    @Override
    public String toString() { //generate to.String()
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
