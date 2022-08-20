package com.example.listtest;

        import android.content.Context;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import android.widget.ArrayAdapter;import android.widget.TextView;

        import androidx.annotation.NonNull;import androidx.annotation.Nullable;

        import java.util.ArrayList;

        import Classes.Languages;

public class LanguageListAdapter extends ArrayAdapter<Languages> {
    Context context;
    ArrayList<Languages> languages;

    public LanguageListAdapter(Context context, ArrayList<Languages> languages) {
        super(context, R.layout.item_language, languages);
        this.context = context;
        this.languages = languages;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Languages l = this.languages.get(position);

        LayoutInflater inflater = LayoutInflater.from(this.context);
        View v = inflater.inflate(R.layout.item_language, null, false);

        TextView tvTitle = v.findViewById(R.id.tvProgTitle);
        TextView tvId = v.findViewById(R.id.tvProgId);
        TextView tvYear = v.findViewById(R.id.tvProgYear);
        TextView tvCreator = v.findViewById(R.id.tvProgCreater);

        tvCreator.setText(l.getCreator());
        tvId.setText(l.getId() + "");
        tvTitle.setText(l.getTitle());
        tvYear.setText(l.getYear());
        v.setTag(l.getId());

        return v;

    }
}
