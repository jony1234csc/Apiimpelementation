package com.example.apisuccessimplement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apisuccessimplement.wishresponse.Datum;
import com.squareup.picasso.Picasso;

public class WishDetailsActivity extends AppCompatActivity {
    private ImageView detailsImage;
    private TextView detailsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_details);

        detailsImage=findViewById(R.id.detailsIV);
        detailsText=findViewById(R.id.detailsTV);

        Datum datum= (Datum) getIntent().getSerializableExtra("article");
      Picasso.get().load(datum.getLink()).into(detailsImage);
      detailsText.setText(datum.getCaptionEn());
    }
}