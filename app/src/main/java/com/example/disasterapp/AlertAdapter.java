package com.example.disasterapp;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class AlertAdapter extends RecyclerView.Adapter<AlertAdapter.ViewHolder> {
    private ArrayList<Alert> alerts = new ArrayList<>();

    @NonNull
    @Override
    public AlertAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alert_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AlertAdapter.ViewHolder holder, int position) {
        Alert currentAlert = alerts.get(position);

        holder.title.setText(alerts.get(position).getTitle());
        holder.txtView.setText(alerts.get(position).getDescription());

        if (currentAlert.isExpanded()) {
            holder.txtView.setVisibility(View.VISIBLE);
            holder.btnResolve.setVisibility(View.VISIBLE);
        }
        else {
            holder.txtView.setVisibility(View.GONE);
            holder.btnResolve.setVisibility(View.GONE);
        }

        if (currentAlert.getUrgency().equals("Kritik"))
            holder.title.setTextColor(Color.RED);
        else if (currentAlert.getUrgency().equals("Uyarı"))
            holder.title.setTextColor(Color.parseColor("#F57C00"));
        else if (currentAlert.getUrgency().equals("Bilgi"))
            holder.title.setTextColor(Color.BLUE);
        else if(currentAlert.getUrgency().equals("Yardım"))
            holder.title.setTextColor(Color.parseColor("#2E7D32"));
        else
            holder.title.setTextColor(Color.BLACK);


        holder.btnResolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPos = holder.getBindingAdapterPosition();
                if (currentPos != RecyclerView.NO_POSITION){
                    alerts.remove(currentPos);
                    notifyItemRemoved(currentPos);
                }
            }
        });

        holder.parentCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = holder.getBindingAdapterPosition();
                if (currentPosition != RecyclerView.NO_POSITION) {
                    Alert clickedAlert = alerts.get(currentPosition);
                    clickedAlert.setExpanded(!clickedAlert.isExpanded());
                    notifyItemChanged(currentPosition);
                }
            }
        });
    }

    private Context context;
    public AlertAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return alerts.size();
    }

    public void setAlerts(ArrayList<Alert> alerts) {
        this.alerts = alerts;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView txtView;
        private MaterialCardView parentCard;
        private Button btnResolve;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            txtView = itemView.findViewById(R.id.detailsLayout);
            parentCard = itemView.findViewById(R.id.parentCard);
            btnResolve = itemView.findViewById(R.id.btnResolve);
        }
    }
}
