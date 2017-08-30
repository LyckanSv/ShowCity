package com.app.lyckan.showcity;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.app.lyckan.showcity.pojos.SubscribedNews;
import com.squareup.picasso.Picasso;

import br.tiagohm.markdownview.MarkdownView;
import br.tiagohm.markdownview.css.styles.Github;
//import us.feras.mdv.MarkdownView;


public class ContainerNewsActivity extends AppCompatActivity {

    //MarkdownView markdownView;

    private ProgressBar spinner;
    String url;
    ImageView img;
    SubscribedNews articulo;
    TextView titulo;
    TextView autor;
    RatingBar ratingBar;

    MarkdownView mMarkdownView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        spinner=(ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);
        img = (ImageView) findViewById(R.id.image_sne);

        titulo = (TextView) findViewById(R.id.titleText);
        autor = (TextView) findViewById(R.id.nombreAutor);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar2);

        ReadMd readMd = new ReadMd();
        articulo = getIntent().getParcelableExtra("parametro");

        Picasso.with(getBaseContext()).load(articulo.getImage()).into(img);

        url = articulo.getMarkdown();


        titulo.setText(articulo.getTitule().toString());
        autor.setText(articulo.getAutor().toString());
        ratingBar.setRating((float) articulo.getStars());
        mMarkdownView = (MarkdownView) findViewById(R.id.markdown_view);
        readMd.execute();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_articule_container, menu);
        return true;
    }

    private class ReadMd extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            spinner.setVisibility(View.VISIBLE);
            //markdownView = (MarkdownView) findViewById(R.id.markdownView);


            mMarkdownView.addStyleSheet(new Github());

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            for (int i =0 ; i < 2; i++){
                //markdownView.loadMarkdownFile(url);
                mMarkdownView.loadMarkdownFromUrl(url);
                spinner.setVisibility(View.GONE);

            }

        }

        @Override
        protected String doInBackground(Void... voids) {
            return null;
        }


    }
}

