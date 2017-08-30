package com.app.lyckan.showcity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.app.lyckan.showcity.adapters.SubscribedNewsAdapter;
import com.app.lyckan.showcity.pojos.SubscribedNews;
import com.app.lyckan.showcity.web.service.ApiUtils;
import com.app.lyckan.showcity.web.service.Article;
import com.app.lyckan.showcity.web.service.SOService;
import com.app.lyckan.showcity.web.service.SOSubscribedResponse;
import com.app.lyckan.showcity.web.service.Subscribed;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private SOService mService;
    ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mService = ApiUtils.getSOService();
        spinner=(ProgressBar)findViewById(R.id.progressRecicler);
        spinner.setVisibility(View.VISIBLE);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        loadAnswers();
    }

    private void initRecicler(List items){



        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        adapter = new SubscribedNewsAdapter(items, MainActivity.this);
        recycler.setAdapter(adapter);
        spinner.setVisibility(View.GONE);

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
        getMenuInflater().inflate(R.menu.main, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        //permite modificar el hint que el EditText muestra por defecto
        searchView.setQueryHint("Buscar");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                //se oculta el EditText
                searchView.setQuery("", false);
                searchView.setIconified(true);

                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {

                return true;
            }
        });


        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
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
        } else if (id == R.id.nav_exit) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void loadAnswers() {
        spinner.setVisibility(View.VISIBLE);
        mService.getAnswers().enqueue(new Callback<SOSubscribedResponse>() {
            @Override
            public void onResponse(Call<SOSubscribedResponse> call, Response<SOSubscribedResponse> response) {

                if(response.isSuccessful()) {
                    //mAdapter.updateAnswers(response.body().getItems());
                    Log.d("MainActivity", response.body().getSubscribed().get(0).getUserName());

                    List items = new ArrayList();

                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.autor1);
                    Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.autor2);
                    Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.autor3);

                    for (Subscribed subscribed: response.body().getSubscribed()){
                        String id = subscribed.getIdUser();
                        String name = subscribed.getUserName();
                        String img = subscribed.getPicture();
                        for (Article article: subscribed.getArticles()){

                            float stars = Float.parseFloat(String.valueOf(article.getStars()));

                            items.add(new SubscribedNews(
                                    article.getIdArticles(),
                                    article.getTitule(),
                                    article.getDescription(),
                                    img,
                                    name,
                                    stars,
                                    article.getMdDoc()
                            ));

                        }
                    }

                    initRecicler(items);

                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<SOSubscribedResponse> call, Throwable t) {
                //showErrorMessage();
                Log.d("MainActivity", t.getMessage().toString());

            }
        });


    }


}
