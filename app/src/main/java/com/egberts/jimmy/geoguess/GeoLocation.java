package com.egberts.jimmy.geoguess;

public class GeoLocation {
    public static final int[] PRE_DEFINED_IMAGE_IDS = {
            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand
    };

    public static final boolean[] PRE_DEFINED_IMAGE_IN_EUROPE_VALUES = {
            true,
            false,
            false,
            true,
            false,
            true,
            true,
            false
    };

    int mGeoLocationImageID;
    boolean mIsInEurope;

    /**
     * The constructor, getters and setters
     */
    public GeoLocation(int mGeoLocationImageID, boolean mIsInEurope) {
        this.mGeoLocationImageID = mGeoLocationImageID;
        this.mIsInEurope = mIsInEurope;
    }

    public int getmGeoLocationImageID() {
        return mGeoLocationImageID;
    }

    public boolean ismIsInEurope() {
        return mIsInEurope;
    }
}
