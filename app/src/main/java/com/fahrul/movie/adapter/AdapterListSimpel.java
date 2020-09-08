package com.fahrul.movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fahrul.movie.R;
import com.fahrul.movie.model.MovieModel;
import com.fahrul.movie.model.Search;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterListSimpel extends RecyclerView.Adapter<AdapterListSimpel.ViewHolder> {

    java.util.List<Search> data;
    String image= "";
    Context context;
    String lokasi;


    public AdapterListSimpel(Context context,java.util.List<Search>data){
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_list, parent, false);


        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.txtJudul.setText(data.get(position).getTitle());
        holder.txtGenre.setText(data.get(position).getType());
        holder.txtDirect.setText(data.get(position).getImdbID());
        holder.txtRating.setText(data.get(position).getYear());
//        holder.txtRilis.setText(data.get(position).getReleased());

        image = data.get(position).getPoster();
        Picasso.get().load(image).into(holder.gambar);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtJudul,txtRating,txtGenre,txtDirect,txtRilis;
        public ImageView gambar;
        public LinearLayout parentLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            txtRilis = (TextView) itemView.findViewById(R.id.txtRilis);
            txtJudul = (TextView) itemView.findViewById(R.id.txtJudul);
            txtDirect = (TextView) itemView.findViewById(R.id.txtDiirect);
            txtGenre = (TextView) itemView.findViewById(R.id.txtGenre);
            txtRating = (TextView) itemView.findViewById(R.id.txtRating);
            gambar = (ImageView) itemView.findViewById(R.id.gambar);
            parentLayout = (LinearLayout) itemView.findViewById(R.id.parentLayout);
        }
    }
}
