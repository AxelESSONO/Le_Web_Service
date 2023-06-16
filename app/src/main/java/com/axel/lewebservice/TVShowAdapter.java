package com.axel.lewebservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TVShowAdapter extends RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder> {

    private Context context;
    private List<TVShow> tvShowList;

    public TVShowAdapter( Context context,List<TVShow> tvShowList) {
        this.context = context;
        this.tvShowList = tvShowList;
    }

    @NonNull
    @Override
    public TVShowAdapter.TVShowViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.tv_show_item,
                parent,
                false
        );

        TVShowViewHolder tvShowViewHolder = new TVShowViewHolder(view);

        return tvShowViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TVShowAdapter.TVShowViewHolder holder, int position) {

        TVShow tvShow = tvShowList.get(position);
        holder.nameText.setText(tvShow.getName());
        holder.networkText.setText(tvShow.getNetWork());

        Glide.with(context)
                .load(tvShow.getImageUrl())
                .placeholder(R.drawable.placeholder)
                .centerCrop()
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return tvShowList.size();
    }

    public class TVShowViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView nameText, networkText;

        public TVShowViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_thumbnail_path);
            nameText = itemView.findViewById(R.id.name);
            networkText = itemView.findViewById(R.id.network);

        }
    }
}
