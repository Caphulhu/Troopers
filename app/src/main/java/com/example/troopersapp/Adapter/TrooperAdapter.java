package com.example.troopersapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.troopersapp.R;
import com.example.troopersapp.model.Trooper;
import com.example.troopersapp.util.ResourceUtil;

import java.util.ArrayList;

/**
 * Created by lslopes on 18/11/2017.
 */

public class TrooperAdapter extends RecyclerView.Adapter<TrooperAdapter.ViewHolder> implements View.OnClickListener {

    private ArrayList<Trooper> troopers;
    private OnItemClickListener onItemClickListener;
    private View.OnLongClickListener onLongClickListener;

    public TrooperAdapter(ArrayList<Trooper> troopers, OnItemClickListener onItemClickListener, View.OnLongClickListener onLongClickListener) {
        this.troopers = troopers;
        this.onItemClickListener = onItemClickListener;
        this.onLongClickListener = onLongClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_trooper, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Trooper trooper = troopers.get(position);
        holder.tvTrooperName.setText(trooper.getName());
        holder.imvTrooperAffiliation.setImageResource(ResourceUtil.getResourceBasedOnAffiliation(trooper.getAffiliation()));
        holder.separator.setVisibility(position == troopers.size() -1 ? View.INVISIBLE : View.VISIBLE);
        holder.itemView.setTag(trooper);
        holder.itemView.setOnClickListener(this);
        holder.itemView.setOnLongClickListener(onLongClickListener);
    }

    @Override
    public int getItemCount() {
        return troopers.size();
    }

    @Override
    public void onClick(View v) {
        onItemClickListener.onItemClick((Trooper) v.getTag());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTrooperName;
        ImageView imvTrooperAffiliation;
        View separator;

        public ViewHolder(View itemView) {
            super(itemView);

            tvTrooperName = itemView.findViewById(R.id.textView_item_trooper);
            imvTrooperAffiliation = itemView.findViewById(R.id.imageView_item_trooper);
            separator = itemView.findViewById(R.id.separador_item_trooper);

        }
    }


    public interface OnItemClickListener {
        public void onItemClick(Trooper trooper);
    }
}
