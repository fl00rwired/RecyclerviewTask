package com.example.recyclertask;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

public class UserAdaptor extends RecyclerView.Adapter<UserAdaptor.UserViewHolder> {

    private List<Result> mlist = Collections.emptyList();

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(mlist.get(position));
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public void setData(List<Result> mlist) {
        this.mlist = mlist;
        notifyDataSetChanged();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        private ImageView Picture;
        private TextView Fname;

        public UserViewHolder(View itemView) {
            super(itemView);
            Fname = itemView.findViewById(R.id.firstname);
            Picture = itemView.findViewById(R.id.picture);
        }

        public void bind(Result result) {
            Fname.setText(result.getName().getFirst());
            Picasso.get().load(result.getPicture().getMedium()).fit().into(Picture);
        }
    }
}