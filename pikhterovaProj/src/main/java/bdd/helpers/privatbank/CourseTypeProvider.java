package bdd.helpers.privatbank;

public class CourseTypeProvider {

    private final CourseType[] courseTypes = {
            new CourseType("branch", 5, "//*[@id=\"gads-t-27288\"]", "//*[@id=\"widget-branches\"]"),
            new CourseType("card", 11, "//*[@id=\"rates-card\"]", "//*[@id=\"widget-cards\"]")
    };

    public CourseType getCourseTypeByName(String name) {

        for (CourseType courseType : courseTypes) {
            if (courseType.getName().equals(name)) {
                return courseType;
            }
        }

        return null;

    }

}
