package dozer.com.projectr.Member;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dozer.com.projectr.R;

/**
 * Created by Admin on 17-Mar-18.
 */
public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.GroceryViewHolder> {
    Context context;
    private List<HorizontalItem> horizontalList;

    public HorizontalAdapter(List<HorizontalItem> horizontalGrocderyList, Context context) {
        this.horizontalList = horizontalGrocderyList;
        this.context = context;
    }

    @Override
    public GroceryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal_recycler, parent, false);
        GroceryViewHolder gvh = new GroceryViewHolder(groceryProductView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(GroceryViewHolder holder, final int position) {
        holder.Title.setText(horizontalList.get(position).getTitle());
        holder.Subtitle.setText(horizontalList.get(position).getSubtitle());
    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }

    public class GroceryViewHolder extends RecyclerView.ViewHolder {
        TextView Title, Subtitle;

        public GroceryViewHolder(View view) {
            super(view);
            Title = view.findViewById(R.id.title);
            Subtitle = view.findViewById(R.id.subtitle);
        }
    }
}