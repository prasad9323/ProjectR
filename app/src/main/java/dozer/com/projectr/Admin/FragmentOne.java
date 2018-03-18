package dozer.com.projectr.Admin;
/**
 * Created by Prasad on 18-Mar-18.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dozer.com.projectr.Member.HorizontalAdapter;
import dozer.com.projectr.Member.RecyclerTouchListener;
import dozer.com.projectr.Models.Project;
import dozer.com.projectr.R;

public class FragmentOne extends Fragment {
    ImageView toggle, bell;
    DrawerLayout drawer;
    Boolean once = true;
    private String title;
    private int image;
    private List<Project> projectList = new ArrayList<>();
    private RecyclerView groceryRecyclerView;
    private HorizontalAdapter horizontalListAdapter;
    private List<Project> projectVerticalList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AdminProjectsAdapter mAdapter;

    public static FragmentOne newInstance(String title, int resImage) {
        FragmentOne fragment = new FragmentOne();
        Bundle args = new Bundle();
        args.putInt("image", resImage);
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        image = getArguments().getInt("image", 0);
        title = getArguments().getString("title");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_vertical);
        mAdapter = new AdminProjectsAdapter(projectVerticalList);
        recyclerView.setHasFixedSize(true);
        // vertical RecyclerView
        //Something
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        // RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        // adding inbuilt divider line
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.HORIZONTAL, 16));
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Project project = projectVerticalList.get(position);
                Toast.makeText(getContext(), project.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));
        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getContext(), resId);
        if (once) {
            recyclerView.setLayoutAnimation(animation);
            prepareVerticalData();
            once = false;
        }
        return view;
    }

    private void prepareVerticalData() {
        Project project = new Project();
        project.setTitle("Project one");
        project.setDescription("Some project that gets things done");
        project.setStartDate("16 Mar 2018");
        project.setDeadLine("24 Dec 2018");
        project.setActivePhase("Planning");
        project.setIssues("Unable to find AR kit");
        project.setPersonnel("Developers, Testers, Marketing guy");
        project.setInstructions("Preferred web app ove android app");
        project.setMandatoryActions("Must maintain repo");
        project.setClient("Reebok");
        project.setAdmin("Mr. WhateverBossesNameIs");
        project.setTeamMembers("Prasad, Sailaja");
        project.setTeamLead("Pallavi");
        project.setMarkettingPersonnel("Ram");
        project.setRepository("Git");
        project.setUrl("http://someproject.somedomain.com");
        project.setThumbnail("Thumbnail url");
        Project project1 = new Project();
        project1.setTitle("Project two");
        project1.setDescription("Some project1 that gets things done");
        project1.setStartDate("16 Mar 2018");
        project1.setDeadLine("24 Dec 2018");
        project1.setActivePhase("Planning");
        project1.setIssues("Unable to find AR kit");
        project1.setPersonnel("Developers, Testers, Marketing guy");
        project1.setInstructions("Preferred web app ove android app");
        project1.setMandatoryActions("Must maintain repo");
        project1.setClient("Reebok");
        project1.setAdmin("Mr. WhateverBossesNameIs");
        project1.setTeamMembers("Prasad, Sailaja");
        project1.setTeamLead("Pallavi");
        project1.setMarkettingPersonnel("Ram");
        project1.setRepository("Git");
        project1.setUrl("http://someproject1.somedomain.com");
        project1.setThumbnail("Thumbnail url");
        Project project2 = new Project();
        project2.setTitle("Project three");
        project2.setDescription("Some project2 that gets things done");
        project2.setStartDate("16 Mar 2018");
        project2.setDeadLine("24 Dec 2018");
        project2.setActivePhase("Planning");
        project2.setIssues("Unable to find AR kit");
        project2.setPersonnel("Developers, Testers, Marketing guy");
        project2.setInstructions("Preferred web app ove android app");
        project2.setMandatoryActions("Must maintain repo");
        project2.setClient("Reebok");
        project2.setAdmin("Mr. WhateverBossesNameIs");
        project2.setTeamMembers("Prasad, Sailaja");
        project2.setTeamLead("Pallavi");
        project2.setMarkettingPersonnel("Ram");
        project2.setRepository("Git");
        project2.setUrl("http://someproject2.somedomain.com");
        project2.setThumbnail("Thumbnail url");
        Project project3 = new Project();
        project3.setTitle("Project four");
        project3.setDescription("Some project3 that gets things done");
        project3.setStartDate("16 Mar 2018");
        project3.setDeadLine("24 Dec 2018");
        project3.setActivePhase("Planning");
        project3.setIssues("Unable to find AR kit");
        project3.setPersonnel("Developers, Testers, Marketing guy");
        project3.setInstructions("Preferred web app ove android app");
        project3.setMandatoryActions("Must maintain repo");
        project3.setClient("Reebok");
        project3.setAdmin("Mr. WhateverBossesNameIs");
        project3.setTeamMembers("Prasad, Sailaja");
        project3.setTeamLead("Pallavi");
        project3.setMarkettingPersonnel("Ram");
        project3.setRepository("Git");
        project3.setUrl("http://someproject3.somedomain.com");
        project3.setThumbnail("Thumbnail url");
        Project project4 = new Project();
        project4.setTitle("Project five");
        project4.setDescription("Some project4 that gets things done");
        project4.setStartDate("16 Mar 2018");
        project4.setDeadLine("24 Dec 2018");
        project4.setActivePhase("Planning");
        project4.setIssues("Unable to find AR kit");
        project4.setPersonnel("Developers, Testers, Marketing guy");
        project4.setInstructions("Preferred web app ove android app");
        project4.setMandatoryActions("Must maintain repo");
        project4.setClient("Reebok");
        project4.setAdmin("Mr. WhateverBossesNameIs");
        project4.setTeamMembers("Prasad, Sailaja");
        project4.setTeamLead("Pallavi");
        project4.setMarkettingPersonnel("Ram");
        project4.setRepository("Git");
        project4.setUrl("http://someproject4.somedomain.com");
        project4.setThumbnail("Thumbnail url");
        projectVerticalList.add(project);
        projectVerticalList.add(project1);
        projectVerticalList.add(project2);
        projectVerticalList.add(project3);
        projectVerticalList.add(project4);
        // notify adapter about data set changes
        // so that it will render the list with new data
        mAdapter.notifyDataSetChanged();
    }
}