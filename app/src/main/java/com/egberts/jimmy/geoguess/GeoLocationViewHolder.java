package com.egberts.jimmy.geoguess;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class GeoLocationViewHolder extends RecyclerView.ViewHolder {
    public ImageView geoLocationImage;
    public View view;

    public GeoLocationViewHolder(View itemView) {
        super(itemView);

        geoLocationImage = itemView.findViewById(R.id.imageView_location);
        view = itemView;
    }
}
