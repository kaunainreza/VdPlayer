package com.example.vdplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<VdViewHolder> {
    private Context context;
    private List<File>files;

    public CustomAdapter(Context context, List<File> files) {
        this.context = context;
        this.files = files;
    }

    @NonNull
    @Override
    public VdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VdViewHolder(LayoutInflater.from(context).inflate(R.layout.list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VdViewHolder holder, int position) {
        holder.txtName.setText(files.get(position).getName());
        holder.txtName.setSelected(true);

        Bitmap thumb = ThumbnailUtils.createVideoThumbnail(files.get(position).getAbsolutePath(), MediaStore.Images.Thumbnails.MINI_KIND);
        holder.imgThumbnail.setImageBitmap(thumb);

    }

    @Override
    public int getItemCount() {
        return files.size();
    }
}
