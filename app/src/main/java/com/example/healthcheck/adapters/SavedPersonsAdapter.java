package com.example.healthcheck.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthcheck.ChoiceNextActivity;
import com.example.healthcheck.R;
import com.example.healthcheck.data.Person;
import com.example.healthcheck.utils.Serializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class SavedPersonsAdapter extends BaseAdapter {

    Context context;
    private List<Person> persons;

    public SavedPersonsAdapter(Context context, Set<String> savedPersons) {
        this.context = context;
        this.persons = new ArrayList();
        for (String name: savedPersons) {
            persons.add(Serializer.deSerialize(name, context));
        }
    }

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View view1 = inflater.inflate(R.layout.customlayout, null);
        ImageView mImageView = view1.findViewById(R.id.imgAvatar);
        TextView textView = view1.findViewById(R.id.txtListViewPersonName);
        mImageView.setImageResource(persons.get(i).getAvatar());
        textView.setText(persons.get(i).getName());

        return view1;
    }

    public void next(String extra, int i) {
        Intent intent = new Intent(context, ChoiceNextActivity.class);
        intent.putExtra(extra, (Parcelable) persons.get(i));
        context.startActivity(intent);
    }
}
