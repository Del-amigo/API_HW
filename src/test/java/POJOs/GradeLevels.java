package POJOs;

import java.util.List;

public class GradeLevels {
    private String id;
    private String name;
    private int order;
    private String shortName;
    private List<Object> nextGradeLevel;
    private boolean active;
    private List<Object> translateName;
    private List<Object> translateShortName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<Object> getNextGradeLevel() {
        return nextGradeLevel;
    }

    public void setNextGradeLevel(List<Object> nextGradeLevel) {
        this.nextGradeLevel = nextGradeLevel;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Object> getTranslateName() {
        return translateName;
    }

    public void setTranslateName(List<Object> translateName) {
        this.translateName = translateName;
    }

    public List<Object> getTranslateShortName() {
        return translateShortName;
    }

    public void setTranslateShortName(List<Object> translateShortName) {
        this.translateShortName = translateShortName;
    }

    @Override
    public String toString() {
        return "GradeLevels{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", shortName='" + shortName + '\'' +
                ", nextGradeLevel=" + nextGradeLevel +
                ", active=" + active +
                ", translateName=" + translateName +
                ", translateShortName=" + translateShortName +
                '}';
    }
}