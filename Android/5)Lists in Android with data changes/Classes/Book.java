import java.io.Serializable; import java.util.Currency;

public class Books implements Serializable { 
  private String author;
  private String title;
  private int id;
  private String year;

 private static int CURRENT_ID = 1;

public Books(String title, String year,String author) {
    this.author = author;
    this.title = title;
    this.id = CURRENT_ID;
    CURRENT_ID++;
    this.year = year;
}

public String getAuthor() {
    return author;
}

public void setAuthor(String author) {
    this.author = author;
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
}
