package com.example.troopersapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.troopersapp.Adapter.TrooperAdapter;
import com.example.troopersapp.model.Trooper;
import com.example.troopersapp.repository.TrooperRepository;
import com.example.troopersapp.util.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TrooperAdapter.OnItemClickListener, View.OnLongClickListener {

    private RecyclerView rvTroopers;
    private ArrayList<Trooper> troopers;
    private TrooperAdapter trooperAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTroopers = findViewById(R.id.troopers_rv);
        populateRecyclerView();


    }

    private void populateRecyclerView() {
        troopers = TrooperRepository.tryGettingFromSharedPreferences(getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE));

        rvTroopers.setLayoutManager(new LinearLayoutManager(this));
        trooperAdapter = new TrooperAdapter(troopers, this, this);
        rvTroopers.setAdapter(trooperAdapter);
    }

    @Override
    public void onItemClick(Trooper trooper) {
        Intent intent = new Intent(this, Trooper_Detail_Activity.class);
        intent.putExtra(Constants.TROOPER_EXTRA, trooper);
        startActivity(intent);
    }

    @Override
    public boolean onLongClick(final View v) {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
//                        int position = rvTroopers.getChildLayoutPosition(v);
//                        troopers.remove(position);
//                        trooperAdapter.notifyDataSetChanged();
//                        Toast.makeText(MainActivity.this, "Trooper excluído.", Toast.LENGTH_SHORT).show();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };
\
        [']
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder .setTitle("Excluir Trooper")
                .setMessage("Tem certeza que deseja excluir este trooper?")
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        troopers.remove(v);
                        trooperAdapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Trooper excluído.", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("NÃO", dialogClickListener).show();

        return true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        TrooperRepository.saveToSharedPreferences(troopers,getSharedPreferences(Constants.PREFS_NAME,MODE_PRIVATE));
    }
}
