package bdd.helpers.privatbank;


public class CourseType {

    private final String name;
    private final int courseId;
    private final String xpath;

    public CourseType(String name, int courseId, String xpath) {
        this.name = name;
        this.courseId = courseId;
        this.xpath = xpath;
    }

    public String getName() {
        return name;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getXpath() {
        return xpath;
    }

}
