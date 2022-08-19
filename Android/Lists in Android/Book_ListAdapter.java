android.view.View; import android.view.ViewGroup; import android.widget.ArrayAdapter; import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import Classes.Books;

public class myBookListAdapter extends ArrayAdapter<Books> {
  Context context;
  ArrayList<Books> books;
  public myBookListAdapter(Context context, ArrayList<Books> books) {
    super(context, R.layout.item_books,books);
    this.context = context; 
    this.books = books; 
  }

@Override
public View getView(int position, @Nullable View convertView, ViewGroup parent) {
    Books b = this.books.get(position);

    LayoutInflater inflater = LayoutInflater.from(this.context);
    View v = inflater.inflate(R.layout.item_books, null, false);

    TextView tvTitle = v.findViewById(R.id.tvBookTitle);
    TextView tvId = v.findViewById(R.id.tvBookId);
    TextView tvYear = v.findViewById(R.id.tvBookYear);
    TextView tvAuthor = v.findViewById(R.id.tvBookAuthor);

    tvTitle.setText(b.getTitle());
    tvYear.setText(b.getYear());
    tvId.setText(b.getId() + "");
    tvAuthor.setText(b.getAuthor());

    return v;
}
