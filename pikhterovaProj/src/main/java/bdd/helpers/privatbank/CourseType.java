package bdd.helpers.privatbank;


public class CourseType {

    private final String name;
    private final int courseId;
    private final String menuItemXpath;
    private final String widgetXpath;

    public CourseType(String name, int courseId, String menuItemXpath, String widgetXpath) {
        this.name = name;
        this.courseId = courseId;
        this.menuItemXpath = menuItemXpath;
        this.widgetXpath = widgetXpath;
    }

    public String getName() {
        return name;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getMenuItemXpath() {
        return menuItemXpath;
    }

    public String getWidgetXpath() {
        return widgetXpath;
    }

}
