package com.probstatinfolab.map;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.probstatinfolab.cmchguide.MainActivity;
import com.probstatinfolab.cmchguide.R;
import com.qozix.tileview.TileView;

public class MapActivity extends AppCompatActivity {

    String building;
    int x = 0, y = 0;
    String mainBuilding = null;
    LinearLayout linearLayout;
    TileView tileView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        this.context = this;

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            building = bundle.getString("name");
            x = Integer.parseInt(bundle.getString("x"));
            y = Integer.parseInt(bundle.getString("y"));
        }

        String[] buildings = getResources().getStringArray(R.array.buildingsArray);
        mainBuilding = buildings[0];

        linearLayout = (LinearLayout) findViewById(R.id.tileLayout);

        tileView = new TileView(this);

        //create tileview -- Amrit
        tileView.setSize(3000, 2000);

        //Setting the minimum parameters from the documentation -- Amrit
        tileView.addDetailLevel(1f, "tiles/map/1000/%d_%d.gif", "samples/map.jpg");
        tileView.addDetailLevel(0.5f, "tiles/map/500/%d_%d.gif", "samples/map.jpg");
        tileView.addDetailLevel(0.25f, "tiles/map/250/%d_%d.gif", "samples/map.jpg");
        tileView.addDetailLevel(0.125f, "tiles/map/125/%d_%d.gif", "samples/map.jpg");

        tileView.moveToAndCenter(3000, 2000);
        tileView.slideToAndCenter(3000, 2000);
        tileView.setScale(0.25);

        linearLayout.addView(tileView);

        if (building != null) {
            ImageView marker = new ImageView(this);
            marker.setImageResource(R.drawable.marker);
            marker.setTag(building);

            tileView.addMarker(marker, x, y, -0.5f, -1.0f);
            tileView.setScale(1f);
            tileView.slideToAndCenter(x - 200, y - 200);

            marker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (building.equals(mainBuilding)) {
                        /*linearLayout.removeView(tileView);
                        internaltileView = new TileView(context);

                        //create tileview -- Amrit
                        internaltileView.setSize(4000, 3000);

                        //Setting the minimum parameters from the documentation -- Amrit
                        internaltileView.addDetailLevel(1f, "tiles001/IntMap/1000/%d_%d.gif", "samples001/IntMap.jpg");
                        internaltileView.addDetailLevel(0.5f, "tiles001/IntMap/500/%d_%d.gif", "samples001/IntMap.jpg");
                        internaltileView.addDetailLevel(0.25f, "tiles001/IntMap/250/%d_%d.gif", "samples001/IntMap.jpg");
                        internaltileView.addDetailLevel(0.125f, "tiles001/IntMap/125/%d_%d.gif", "samples001/IntMap.jpg");

                        internaltileView.moveToAndCenter(4000, 3000);
                        internaltileView.slideToAndCenter(4000, 3000);
                        internaltileView.setScale(0.25);

                        linearLayout.addView(internaltileView);*/
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setCancelable(true);
                        builder.setTitle("পরিচিতি");
                        builder.setMessage("ভবনের নামঃ " + building);
                        builder.show();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setCancelable(true);
                        builder.setTitle("পরিচিতি");
                        builder.setMessage("ভবনের নামঃ " + building);
                        builder.show();
                    }
                }
            });
        }
    }

    private void toastIt(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {

            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        NavUtils.navigateUpFromSameTask(this);
    }
}
