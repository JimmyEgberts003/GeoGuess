package com.egberts.jimmy.geoguess;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class GeoLocationAdapter extends RecyclerView.Adapter<GeoLocationViewHolder> {
    public List<GeoLocation> listGeoLocations;

    public GeoLocationAdapter(List<GeoLocation> listGeoLocations) {
        this.listGeoLocations = listGeoLocations;
    }

    @Override
    public GeoLocationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.geo_location_imageviews, viewGroup, false);

        return new GeoLocationViewHolder(view);
    }

    public void onBindViewHolder(GeoLocationViewHolder geoLocationViewHolder, int i) {
        final GeoLocation geoLocation = listGeoLocations.get(i);

        geoLocationViewHolder.geoLocationImage.setImageResource(
                geoLocation.getmGeoLocationImageID());
    }

    public int getItemCount() {
        return listGeoLocations.size();
    }
}
