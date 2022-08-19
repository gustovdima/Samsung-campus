public class Languages { 
  private String title;
  private String creator;
  private String year;
  private int id;

private static int CURRENT_ID = 1;

public Languages(String title, String creator, String year) {
    this.title = title;
    this.creator = creator;
    this.year = year;
    this.id = CURRENT_ID;
    CURRENT_ID++;
}

public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public String getCreator() {
    return creator;
}

public void setCreator(String creator) {
    this.creator = creator;
}

public String getYear() {
    return year;
}

public void setYear(String year) {
    this.year = year;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}
}
