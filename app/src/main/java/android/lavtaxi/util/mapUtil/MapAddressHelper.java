package android.lavtaxi.util.mapUtil;

import android.lavtaxi.ui.MapsActivity;
import android.location.Address;
import android.location.Geocoder;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by rob on 6/25/17.
 */

public class MapAddressHelper {
    private MapsActivity mapsActivity;
    private GoogleMap googleMap;

    public MapAddressHelper(MapsActivity mapsActivity, GoogleMap googleMap) {
        this.mapsActivity = mapsActivity;
        this.googleMap = googleMap;
    }

    public String getAddressByLongLat(double longitute, double latitute) {
        return getAddressByLongLat(new LatLng(longitute, latitute));
    }


    public String getAddressByLongLat(LatLng latLng) {
        String returningAddress = "";
        Geocoder geocoder = new Geocoder(mapsActivity, new Locale("am"));
        List<Address> yourAddresses = null;
        try {
            yourAddresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (yourAddresses.size() > 0) {
            String yourAddress = yourAddresses.get(0).getAddressLine(0);
            String yourCity = yourAddresses.get(0).getAddressLine(1);
            String yourCountry = yourAddresses.get(0).getAddressLine(2);
            returningAddress = (yourAddress != null ? yourAddress : "") + (yourCity != null ? yourCity : "") + (yourCountry != null ? yourCountry : "");
        }
        return returningAddress;
    }

    public Marker addmarkerWithTitle(LatLng latLng) {
        return googleMap.addMarker(new MarkerOptions().position(latLng)
                .title(getAddressByLongLat(latLng)));
    }
}
