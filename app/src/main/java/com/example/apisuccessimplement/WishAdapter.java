package com.example.apisuccessimplement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apisuccessimplement.wishresponse.Datum;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WishAdapter extends RecyclerView.Adapter<WishAdapter.WishViewHolder> {
    private Context context;
    List<Datum> datumList;

    public WishAdapter(Context context, List<Datum> datumList) {
        this.context = context;
        this.datumList = datumList;
    }

    @NonNull
    @Override
    public WishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.caption_row, parent, false);
        return new WishViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WishViewHolder holder, int position) {

        Datum data = datumList.get(position);
        holder.enCaption.setText(data.getCaptionEn());
        holder.bnCaption.setText(data.getCaptionBn());
        Picasso.get().load(data.getLink()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Datum datum= datumList.get(position);
                Intent intent=new Intent(context, WishDetailsActivity.class);
                intent.putExtra("article",datum);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return datumList.size();
    }

    public class WishViewHolder extends RecyclerView.ViewHolder {
        private TextView enCaption, bnCaption;
        private ImageView imageView;

        public WishViewHolder(@NonNull View itemView) {

            super(itemView);
            enCaption = itemView.findViewById(R.id.captionTVen);
            bnCaption = itemView.findViewById(R.id.captionTVbn);
            imageView = itemView.findViewById(R.id.imageViewID);
        }
    }
}
