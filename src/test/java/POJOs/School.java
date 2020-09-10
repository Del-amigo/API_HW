package POJOs;

public class School {
    private String id;
    private Boolean isBBBServerEnabled;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getBBBServerEnabled() {
        return isBBBServerEnabled;
    }

    public void setBBBServerEnabled(Boolean BBBServerEnabled) {
        isBBBServerEnabled = BBBServerEnabled;
    }

    @Override
    public String toString() {
        return "School{" +
                "id='" + id + '\'' +
                ", isBBBServerEnabled=" + isBBBServerEnabled +
                '}';
    }
}
