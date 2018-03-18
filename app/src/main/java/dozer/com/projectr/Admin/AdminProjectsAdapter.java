package dozer.com.projectr.Admin;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import dozer.com.projectr.Models.Project;
import dozer.com.projectr.R;

/**
 * Created by Prasad on 18-Mar-18.
 */
public class AdminProjectsAdapter extends RecyclerView.Adapter<AdminProjectsAdapter.MyViewHolder> {
    private List<Project> projectList;

    public AdminProjectsAdapter(List<Project> projectList) {
        this.projectList = projectList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_project_vertical, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Project project = projectList.get(position);
        holder.title.setText(project.getTitle());
        holder.desc.setText(project.getDescription());
        holder.layout.setBackgroundColor(project.getProjectColor());
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, desc;
        RelativeLayout layout;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            desc = view.findViewById(R.id.description);
            layout = view.findViewById(R.id.layout);
        }
    }
}
