package com.example.forsub;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

public class CardNoteAdapter extends RecyclerView.Adapter<CardNoteAdapter.CardViewViewHolder> {
    private ArrayList<Note> listNote;
    public CardNoteAdapter(ArrayList<Note> list) {
        this.listNote = list;
    }
    @NonNull
    @Override
    public CardNoteAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardNoteAdapter.CardViewViewHolder holder, int position) {
        final Note note = listNote.get(position);
        Glide.with(holder.itemView.getContext())
                .load(note.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.tvName.setText(note.getNote_name());
        holder.tvFrom.setText(note.getPlace());

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Kamu memilih " + listNote.get(holder.getAdapterPosition()).getNote_name(), Toast.LENGTH_LONG).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveWithData = new Intent(holder.itemView.getContext(), Moveit.class);
                moveWithData.putExtra(Moveit.EXTRA_URL, note.getPhoto());
                moveWithData.putExtra(Moveit.EXTRA_NOTE, note.getNote_name());
                moveWithData.putExtra(Moveit.EXTRA_PLACE, note.getPlace());
                moveWithData.putExtra(Moveit.EXTRA_TIME, note.getTime());
                holder.itemView.getContext().startActivity(moveWithData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listNote.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvFrom;
        Button btnShare;
        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvFrom = itemView.findViewById(R.id.tv_item_from);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }
}
