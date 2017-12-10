package com.example.troopersapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.troopersapp.model.Trooper;
import com.example.troopersapp.util.Constants;
import com.example.troopersapp.util.ResourceUtil;
import com.squareup.picasso.Picasso;

public class Trooper_Detail_Activity extends AppCompatActivity {

    public Trooper trooper;
    private TextView tvTroperTextView;
    private ImageView imvTrooperImage, imvTrooperAffiliation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trooper_detail_);

        initializeComponents();
        bindTrooper();
    }

    private void bindTrooper() {
        Intent intent = getIntent();
        trooper = (Trooper) intent.getSerializableExtra(Constants.TROOPER_EXTRA);
        setTitle(trooper.getName());

        tvTroperTextView.setText(trooper.getDescription());
        imvTrooperAffiliation.setImageResource(ResourceUtil.getResourceBasedOnAffiliation(trooper.getAffiliation()));
        Picasso.with(this).load(trooper.getImageUrl()).into(imvTrooperImage);
    }

    private void initializeComponents() {

        tvTroperTextView = findViewById(R.id.textView_detail_trooper);
        imvTrooperAffiliation = findViewById(R.id.imageView_detail_iconAffiliation);
        imvTrooperImage = findViewById(R.id.imageView_detail_fullImage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.trooper_detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.star_item:
                Toast.makeText(this, "FAVORITAR TROOPER", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
