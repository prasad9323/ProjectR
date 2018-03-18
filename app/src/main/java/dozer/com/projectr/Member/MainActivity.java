package dozer.com.projectr.Member;

import android.content.Context;
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

import dozer.com.projectr.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private List<HorizontalItem> horizontalItemList = new ArrayList<>();
    private RecyclerView groceryRecyclerView;
    private HorizontalAdapter horizontalListAdapter;
    private List<Movie> verticalList = new ArrayList<>();
    private RecyclerView recyclerView;
    private VerticalAdapter mAdapter;
    ImageView toggle, bell;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initiateViews();
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
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
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initiateViews() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
        horizontalListAdapter = new HorizontalAdapter(horizontalItemList, getApplicationContext());
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        groceryRecyclerView.setLayoutManager(horizontalLayoutManager);
        groceryRecyclerView.setAdapter(horizontalListAdapter);
        int resId = R.anim.layout_animation_left_to_right;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(), resId);
        groceryRecyclerView.setLayoutAnimation(animation);
        populateHorizontalList();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_vertical);
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
                Movie movie = verticalList.get(position);
                Toast.makeText(getApplicationContext(), movie.getTitle() + " is selected!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));
        resId = R.anim.layout_animation_fall_down;
        animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(), resId);
        recyclerView.setLayoutAnimation(animation);
        prepareVerticalData();
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
        HorizontalItem horizontalItem1 = new HorizontalItem();
        horizontalItem1.setTitle("Project 1");
        horizontalItem1.setSubtitle("8 Tasks");
        HorizontalItem horizontalItem2 = new HorizontalItem();
        horizontalItem2.setTitle("Project 2");
        horizontalItem2.setSubtitle("2 Tasks");
        HorizontalItem horizontalItem3 = new HorizontalItem();
        horizontalItem3.setTitle("Project 3");
        horizontalItem3.setSubtitle("5 Tasks");
        HorizontalItem horizontalItem4 = new HorizontalItem();
        horizontalItem4.setTitle("Project 4");
        horizontalItem4.setSubtitle("9 Tasks");
        HorizontalItem horizontalItem5 = new HorizontalItem();
        horizontalItem5.setTitle("Project 5");
        horizontalItem5.setSubtitle("11 Tasks");
        HorizontalItem horizontalItem6 = new HorizontalItem();
        horizontalItem6.setTitle("Project 6");
        horizontalItem6.setSubtitle("4 Tasks");
        HorizontalItem horizontalItem7 = new HorizontalItem();
        horizontalItem7.setTitle("Project 7");
        horizontalItem7.setSubtitle("1 Task");
        horizontalItemList.add(horizontalItem1);
        horizontalItemList.add(horizontalItem2);
        horizontalItemList.add(horizontalItem3);
        horizontalItemList.add(horizontalItem4);
        horizontalItemList.add(horizontalItem5);
        horizontalItemList.add(horizontalItem6);
        horizontalItemList.add(horizontalItem7);
        horizontalListAdapter.notifyDataSetChanged();
    }

    private void prepareVerticalData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        verticalList.add(movie);
        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        verticalList.add(movie);
        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        verticalList.add(movie);
        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        verticalList.add(movie);
        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        verticalList.add(movie);
        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        verticalList.add(movie);
        movie = new Movie("Up", "Animation", "2009");
        verticalList.add(movie);
        movie = new Movie("Star Trek", "Science Fiction", "2009");
        verticalList.add(movie);
        movie = new Movie("The LEGO Movie", "Animation", "2014");
        verticalList.add(movie);
        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        verticalList.add(movie);
        movie = new Movie("Aliens", "Science Fiction", "1986");
        verticalList.add(movie);
        movie = new Movie("Chicken Run", "Animation", "2000");
        verticalList.add(movie);
        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        verticalList.add(movie);
        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        verticalList.add(movie);
        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        verticalList.add(movie);
        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        verticalList.add(movie);
        // notify adapter about data set changes
        // so that it will render the list with new data
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
