package com.app.lyckan.showcity.adapters;


import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.app.lyckan.showcity.ContainerNewsActivity;
import com.app.lyckan.showcity.MainActivity;
import com.app.lyckan.showcity.R;
import com.app.lyckan.showcity.pojos.SubscribedNews;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SubscribedNewsAdapter extends RecyclerView.Adapter<SubscribedNewsAdapter.SubscribedNewViewHolder>{

    private List<SubscribedNews> items;
    private Context context;
    private int lastPosition = -1;

    public class SubscribedNewViewHolder extends RecyclerView.ViewHolder {
        public TextView titule;
        public TextView description;
        public ImageView image;
        public TextView autor;
        public RatingBar stars;
        public Button read;


        public SubscribedNewViewHolder(View itemView) {
            super(itemView);

            titule = itemView.findViewById(R.id.title_subscribed_news_element);
            description = itemView.findViewById(R.id.description_subscribed_news_element);
            image = itemView.findViewById(R.id.image_sne);
            autor = itemView.findViewById(R.id.autor_sne);
            stars = itemView.findViewById(R.id.ratingBar);
            read = itemView.findViewById(R.id.read_btn_sne);
        }
    }

    public SubscribedNewsAdapter( List<SubscribedNews> items, Context context){
        this.context= context;
        this.items = items;
    }

    @Override
    public SubscribedNewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subscribed_news_element, parent, false);
        return new SubscribedNewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SubscribedNewViewHolder holder, final int position) {
        holder.titule.setText(items.get(position).getTitule());
        holder.autor.setText(items.get(position).getAutor());
        holder.stars.setRating(items.get(position).getStars());
        holder.description.setText(items.get(position).getDescription());
        Picasso.with(context).load(items.get(position).getImage()).into(holder.image);
        holder.titule.setEllipsize(TextUtils.TruncateAt.END);
        holder.description.setEllipsize(TextUtils.TruncateAt.END);
        holder.read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ContainerNewsActivity.class);
                intent.putExtra("parametro", items.get(position));

                Pair<View, String> p1 = Pair.create((View)holder.image, "profile");
                Pair<View, String> p2 = Pair.create((View)holder.titule, "title");

//                ActivityOptionsCompat options = ActivityOptionsCompat.
//                        makeSceneTransitionAnimation((Activity) context, (View)holder.image, "profile");

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation((Activity) context, p1, p2);
                context.startActivity(intent, options.toBundle());
            }
        });

        //setAnimation(holder.itemView, position);
        //setFadeAnimation(holder.itemView);
        setScaleAnimation(holder.itemView);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(2000);
        view.startAnimation(anim);
    }

    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(2000);
        view.startAnimation(anim);
    }
}
