package dozer.com.projectr.Member;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dozer.com.projectr.Admin.AdminActivity;
import dozer.com.projectr.Models.Project;
import dozer.com.projectr.Models.VerticalItem;
import dozer.com.projectr.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView toggle, bell;
    DrawerLayout drawer;
    private List<Project> projectList = new ArrayList<>();
    private RecyclerView groceryRecyclerView;
    private HorizontalAdapter horizontalListAdapter;
    private List<VerticalItem> verticalList = new ArrayList<>();
    private RecyclerView recyclerView;
    private VerticalAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initiateViews();
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        /*ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
                */
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initiateViews() {
        drawer = findViewById(R.id.drawer_layout);
        toggle = findViewById(R.id.toggle);
        bell = findViewById(R.id.bell);
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
        groceryRecyclerView = findViewById(R.id.recycler_view_horizontal);
        //groceryRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.HORIZONTAL));
        horizontalListAdapter = new HorizontalAdapter(projectList, getApplicationContext());
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        groceryRecyclerView.setLayoutManager(horizontalLayoutManager);
        groceryRecyclerView.setAdapter(horizontalListAdapter);
        int resId = R.anim.layout_animation_left_to_right;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(), resId);
        groceryRecyclerView.setLayoutAnimation(animation);
        populateHorizontalList();
        recyclerView = findViewById(R.id.recycler_view_vertical);
        mAdapter = new VerticalAdapter(verticalList);
        recyclerView.setHasFixedSize(true);
        // vertical RecyclerView
        //Something
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        // RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        // adding inbuilt divider line
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.HORIZONTAL, 16));
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                VerticalItem verticalItem = verticalList.get(position);
                Toast.makeText(getApplicationContext(), verticalItem.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));
        resId = R.anim.layout_animation_fall_down;
        animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(), resId);
        recyclerView.setLayoutAnimation(animation);
        prepareVerticalData();
        bell = findViewById(R.id.bell);
        bell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AdminActivity.class));
            }
        });
    }

    private void runLayoutAnimation(final RecyclerView recyclerView) {
        final Context context = recyclerView.getContext();
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

    private void populateHorizontalList() {
        Project project1 = new Project();
        project1.setTitle("Project 1");
        project1.setDescription("8 Tasks");
        project1.setProjectColor(getResources().getColor(R.color.tempColor1));
        Project project2 = new Project();
        project2.setTitle("Project 2");
        project2.setDescription("2 Tasks");
        project2.setProjectColor(getResources().getColor(R.color.tempColor2));
        Project project3 = new Project();
        project3.setTitle("Project 3");
        project3.setDescription("5 Tasks");
        project3.setProjectColor(getResources().getColor(R.color.tempColor3));
        Project project4 = new Project();
        project4.setTitle("Project 4");
        project4.setDescription("9 Tasks");
        project4.setProjectColor(getResources().getColor(R.color.tempColor4));
        Project project5 = new Project();
        project5.setTitle("Project 5");
        project5.setDescription("11 Tasks");
        project5.setProjectColor(getResources().getColor(R.color.tempColor5));
        Project project6 = new Project();
        project6.setTitle("Project 6");
        project6.setDescription("4 Tasks");
        project6.setProjectColor(getResources().getColor(R.color.tempColor6));
        Project project7 = new Project();
        project7.setTitle("Project 7");
        project7.setDescription("1 Task");
        project7.setProjectColor(getResources().getColor(R.color.tempColor1));
        projectList.add(project1);
        projectList.add(project2);
        projectList.add(project3);
        projectList.add(project4);
        projectList.add(project5);
        projectList.add(project6);
        projectList.add(project7);
        horizontalListAdapter.notifyDataSetChanged();
    }

    private void prepareVerticalData() {
        VerticalItem verticalItem = new VerticalItem("Mad Max: Fury Road", "Action & Adventure", "2015");
        verticalList.add(verticalItem);
        verticalItem = new VerticalItem("Inside Out", "Animation, Kids & Family", "2015");
        verticalList.add(verticalItem);
        verticalItem = new VerticalItem("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        verticalList.add(verticalItem);
        verticalItem = new VerticalItem("Shaun the Sheep", "Animation", "2015");
        verticalList.add(verticalItem);
        verticalItem = new VerticalItem("The Martian", "Science Fiction & Fantasy", "2015");
        verticalList.add(verticalItem);
        verticalItem = new VerticalItem("Mission: Impossible Rogue Nation", "Action", "2015");
        verticalList.add(verticalItem);
        verticalItem = new VerticalItem("Up", "Animation", "2009");
        verticalList.add(verticalItem);
        verticalItem = new VerticalItem("Star Trek", "Science Fiction", "2009");
        verticalList.add(verticalItem);
        verticalItem = new VerticalItem("The LEGO VerticalItem", "Animation", "2014");
        verticalList.add(verticalItem);
        verticalItem = new VerticalItem("Iron Man", "Action & Adventure", "2008");
        verticalList.add(verticalItem);
        verticalItem = new VerticalItem("Aliens", "Science Fiction", "1986");
        verticalList.add(verticalItem);
        verticalItem = new VerticalItem("Chicken Run", "Animation", "2000");
        verticalList.add(verticalItem);
        verticalItem = new VerticalItem("Back to the Future", "Science Fiction", "1985");
        verticalList.add(verticalItem);
        verticalItem = new VerticalItem("Raiders of the Lost Ark", "Action & Adventure", "1981");
        verticalList.add(verticalItem);
        verticalItem = new VerticalItem("Goldfinger", "Action & Adventure", "1965");
        verticalList.add(verticalItem);
        verticalItem = new VerticalItem("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        verticalList.add(verticalItem);
        // notify adapter about data set changes
        // so that it will render the list with new data
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
        } else if (id == R.id.nav_slideshow) {
        } else if (id == R.id.nav_manage) {
        } else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_send) {
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
