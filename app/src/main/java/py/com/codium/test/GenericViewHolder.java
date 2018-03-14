package py.com.codium.test;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by eferreira on 14/03/18.
 */

public class GenericViewHolder extends RecyclerView.ViewHolder{

    public GenericViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * Method to retrieve an view from itemView by its ID
     * @param id
     * @param cls
     * @param <T>
     * @return
     */
    public <T extends View> T get(int id, Class<T> cls) {
        View v = itemView.findViewById(id);
        T t = cls.cast(v);
        return t;
    }
}