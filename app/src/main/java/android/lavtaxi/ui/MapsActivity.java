package android.lavtaxi.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.lavtaxi.R;
import android.lavtaxi.util.mapUtil.DrawingRouteHelper;
import android.lavtaxi.util.mapUtil.MapAddressHelper;
import android.location.Location;
import android.location.LocationListener;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener, GoogleMap.OnMyLocationChangeListener {

    private GoogleMap mMap;
    private MapAddressHelper mapAddressHelper;
    private DrawingRouteHelper drawRouteHelper;
    private LatLng destintaion;
    private LatLng currentLocationLatLng;
    private List<LatLng> destinationsList;
    private LatLng lastDrawnDestination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
//        destinationsList = new ArrayList<>();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mapAddressHelper = new MapAddressHelper(this, mMap);
        drawRouteHelper = new DrawingRouteHelper(mMap);
        mMap.setOnMyLocationChangeListener(this);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            // Show rationale and request permission.
        }
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
//                destinationsList.add(latLng);
                mapAddressHelper.addmarkerWithTitle(latLng);
                drawRouteHelper.drawRoute(lastDrawnDestination, latLng);
                lastDrawnDestination = latLng;
            }
        });
    }


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public void onMyLocationChange(Location location) {
        currentLocationLatLng = new LatLng(location.getLatitude(), location.getLongitude());
        if(lastDrawnDestination == null){
            lastDrawnDestination = currentLocationLatLng;
        }
    }
}
