import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import Classes.Films;

public class myFilmListAdapter extends ArrayAdapter<Films> { 
  Context context;
  ArrayList<Films> films; 
  public myFilmListAdapter(Context context, ArrayList<Films> films) {
    super(context, R.layout.item_film, films);
    this.context = context;
    this.films = films;
  }

@Override
public View getView(int position, @Nullable View convertView, ViewGroup parent) {
    Films f = this.films.get(position);

    LayoutInflater inflater = LayoutInflater.from(this.context);
    View v = inflater.inflate(R.layout.item_film, null, false);

    TextView tvTitle = v.findViewById(R.id.tvTitle);
    TextView tvId = v.findViewById(R.id.tvId);
    TextView tvYear = v.findViewById(R.id.tvYear);
    TextView tvDirector = v.findViewById(R.id.tvDirector);


    tvTitle.setText(f.getTitle());
    tvYear.setText(f.getYear());
    tvId.setText(f.getId() + "");
    tvDirector.setText(f.getDirector());
    v.setTag(f.getId());

    return v;
}
