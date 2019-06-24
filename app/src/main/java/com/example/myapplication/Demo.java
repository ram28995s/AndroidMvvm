package com.example.myapplication;

public class Demo {



    /*
    *
    * public class FragmentMap extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    MapView mMapView;

    ArrayList<LatLng> points = new ArrayList<LatLng>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map, null);

        mMapView = (MapView) v.findViewById(R.id.map);

        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(this);

        return v;
    }

    public void changeData(ArrayList<UserModel> arr_company) {
        mMap.clear();
        for (int i = 0; i < arr_company.size(); i++) {
            final LatLng l = new LatLng(Double.parseDouble(arr_company.get(i).getLat()), Double.parseDouble(arr_company.get(i).getLog()));
            points.add(l);
            if (!arr_company.get(i).getUser_img().equals("") && arr_company != null) {
                Glide.with(getActivity()).
                        load(URL.IMG_URL + arr_company.get(i).getUser_img())
                        .asBitmap()
                        .fitCenter()
                        .into(new SimpleTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                                // let's find marker for this user
                                View mCustomMarkerView = ((LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.view_custom_marker, null);
                                ImageView mMarkerImageView = (ImageView) mCustomMarkerView.findViewById(R.id.profile_image);
                                mMap.addMarker(new MarkerOptions()
                                        .position(l)
                                        .icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(mCustomMarkerView, bitmap, mMarkerImageView))));
                            }
                        });
            } else {
                mMap.addMarker(new MarkerOptions()
                        .position(l));
            }
        }
        if (arr_company.size() > 0) {
            LatLngBounds.Builder bc = new LatLngBounds.Builder();
            for (LatLng item : points) {
                bc.include(item);
            }
            LatLngBounds bounds = bc.build();
            mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 300));
            //mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bc.build(), 20));
        } else {
            Toast.makeText(getActivity(), "No Company Available", Toast.LENGTH_SHORT).show();
        }
        ((MainActivity) getActivity()).getApiCall().dismisDialg();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                for (int i = 0; i < ((MainActivity) getActivity()).arr_company.size(); i++) {
                    if (marker.getPosition().latitude == Double.parseDouble(((MainActivity) getActivity()).arr_company.get(i).getLat()) && marker.getPosition().longitude == Double.parseDouble(((MainActivity) getActivity()).arr_company.get(i).getLog())) {
                        Intent j = new Intent(getActivity(), CompanyDetailActivity.class);
                        Bundle b = new Bundle();
                        b.putSerializable("data", ((MainActivity) getActivity()).arr_company.get(i));
                        j.putExtras(b);
                        startActivity(j);
                    }
                }
                return false;
            }
        });

        changeData(((MainActivity)getActivity()).arr_company);
    }

    private Bitmap getMarkerBitmapFromView(View view, Bitmap bitmap, ImageView ic) {
        ic.setImageBitmap(bitmap);
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.SRC_IN);
        Drawable drawable = view.getBackground();
        if (drawable != null)
            drawable.draw(canvas);
        view.draw(canvas);
        return returnedBitmap;
    }

}
    *
    *
    * */
}
