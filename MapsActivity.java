package com.example.program8;
import androidx.fragment.app.FragmentActivity;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.program8.databinding.ActivityMapsBinding;
import java.io.IOException;
import java.util.List;
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
private GoogleMap mMap;
 private TextView tv;
 private ActivityMapsBinding binding;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 binding = ActivityMapsBinding.inflate(getLayoutInflater());
 setContentView(binding.getRoot());
 SupportMapFragment mapFragment = (SupportMapFragment)
    getSupportFragmentManager().findFragmentById(R.id.map);
 mapFragment.getMapAsync(this);
 }
 @Override
 public void onMapReady(GoogleMap googleMap) {
 mMap = googleMap;
 LatLng Bengaluru = new LatLng(13, 78);
 mMap.addMarker(new MarkerOptions().position(Bengaluru).title("Marker in Bengaluru"));
 mMap.moveCamera(CameraUpdateFactory.newLatLng(Bengaluru));
 }
 public void setmMap(GoogleMap mMap) {
 this.mMap = mMap;
 }
 public void onSearch(View view) {
 List<Address> addressList = null;
 EditText et_location = (EditText) findViewById(R.id.et1);
 String location = et_location.getText().toString();
if (location != null || location.equals("")) {
 Geocoder geocoder = new Geocoder(this);
 try {
 addressList = geocoder.getFromLocationName(location, 1);
 } catch (IOException e) {
 e.printStackTrace();
 }
 Address address = addressList.get(0);
 LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
 mMap.addMarker(new MarkerOptions().position(latLng).title(location));
 mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
 }
 }
 public void onType(View view) {
 if (mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL) {
 mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
 } else {
 mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
 }
 }
 public void onZoom(View view) {
 if (view.getId() == R.id.zoomin) {
 mMap.animateCamera(CameraUpdateFactory.zoomIn());
 }
 if (view.getId() == R.id.zoomout) {
 mMap.animateCamera(CameraUpdateFactory.zoomOut());
 }
 }
}
