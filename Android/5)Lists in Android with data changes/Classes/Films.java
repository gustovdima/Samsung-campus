import java.io.Serializable;

public class Films implements Serializable {
    private String title;
    private int id;
    private String year;
    private String director;

    private static int CURRENT_ID = 1;

    public Films(String title, String year, String director) {
        this.director = director;
        this.title = title;
        this.id = CURRENT_ID;
        CURRENT_ID++;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
