package py.com.codium.test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by eferreira on 14/03/18.
 */

public class PersonAdapter extends RecyclerView.Adapter<GenericViewHolder> {

    Person[] mDataSet;

    //TODO constructor


    public PersonAdapter(Person[] mDataSet) {
        this.mDataSet = mDataSet;
    }

    @Override
    public GenericViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new GenericViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GenericViewHolder holder, int position) {
        Person person = mDataSet[position];
        holder.get(R.id.txt_name, TextView.class).setText(person.fname + " " + person.lname);
        holder.get(R.id.txt_city, TextView.class).setText("From " + person.city);
    }

    @Override
    public int getItemCount() {
        return this.mDataSet.length;
    }
}
