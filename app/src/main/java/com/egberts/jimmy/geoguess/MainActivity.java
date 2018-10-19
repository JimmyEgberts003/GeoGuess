package com.egberts.jimmy.geoguess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<GeoLocation> mGeoLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGeoLocations = new ArrayList<>();
        for (int i = 0; i < GeoLocation.PRE_DEFINED_IMAGE_IDS.length; i++) {
            mGeoLocations.add(new GeoLocation(GeoLocation.PRE_DEFINED_IMAGE_IDS[i],
                    GeoLocation.PRE_DEFINED_IMAGE_IN_EUROPE_VALUES[i]));
        }

        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        final GeoLocationAdapter mAdapter = new GeoLocationAdapter(mGeoLocations);
        mRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallBack = new ItemTouchHelper.SimpleCallback(
                0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int position = (viewHolder.getAdapterPosition());

                GeoLocation geoLocation = mGeoLocations.get(position);

                if ((swipeDir == ItemTouchHelper.LEFT && geoLocation.ismIsInEurope()) || (swipeDir == ItemTouchHelper.RIGHT && !geoLocation.ismIsInEurope())) {
                    mAdapter.notifyItemRemoved(position);
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                } else {
                    mAdapter.notifyItemRemoved(position);
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                }
                mGeoLocations.remove(position);
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallBack);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }
}
