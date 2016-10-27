package com.probstatinfolab.cmchguide.complain;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.probstatinfolab.cmchguide.MainActivity;
import com.probstatinfolab.cmchguide.R;
import com.probstatinfolab.cmchguide.contact.ContactActivity;

public class ComplainActivity extends AppCompatActivity {

    String number, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void call(View view) {
        String number = getString(R.string.amritnumber);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel: " + number));
        startActivity(intent);
    }

    public void email(View view) {
        String email = getString(R.string.lolitemail);
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{email});
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ComplainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            Intent intent = new Intent(ComplainActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ComplainActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
