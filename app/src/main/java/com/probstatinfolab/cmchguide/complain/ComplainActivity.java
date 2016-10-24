package com.probstatinfolab.cmchguide.complain;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.probstatinfolab.cmchguide.R;

public class ComplainActivity extends AppCompatActivity {

    String number, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);
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
}
