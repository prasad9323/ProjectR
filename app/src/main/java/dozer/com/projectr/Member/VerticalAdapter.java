package dozer.com.projectr.Member;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dozer.com.projectr.Models.VerticalItem;
import dozer.com.projectr.R;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.MyViewHolder> {
    private List<VerticalItem> moviesList;

    public VerticalAdapter(List<VerticalItem> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_vertical_recycler, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        VerticalItem verticalItem = moviesList.get(position);
        holder.title.setText(verticalItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
        }
    }
}
