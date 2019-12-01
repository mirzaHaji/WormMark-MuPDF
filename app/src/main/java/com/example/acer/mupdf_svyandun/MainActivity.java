package com.example.acer.mupdf_svyandun;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.artifex.mupdfdemo.FilePicker;
import com.artifex.mupdfdemo.MuPDFActivity;
import com.artifex.mupdfdemo.MuPDFCore;
import com.artifex.mupdfdemo.MuPDFPageAdapter;
import com.artifex.mupdfdemo.MuPDFReaderView;

import java.io.File;

import static com.example.acer.mupdf_svyandun.R.id;
import static com.example.acer.mupdf_svyandun.R.layout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
    }

    public void MuPDF(View view) {
        Uri uri= null;

        uri = Uri.parse("/mnt/sdcard/download/vc3.pdf");
        Intent intent = new Intent(MainActivity.this, MuPDFActivity.class);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(uri);
       // intent.putExtra("startingPage",40);
      intent.putExtra("start",615);
      intent.putExtra("end",615);

        //  Bundle extras = intent.getExtras();
      //  extras.putInt("index", 10);

        this.startActivity(intent);

/*

        MuPDFCore core = null;
       try {
            core = new MuPDFCore(this, "/mnt/sdcard/download/vc3.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
        android.support.constraint.ConstraintLayout layout = (android.support.constraint.ConstraintLayout) findViewById(id.main_layout);
       MuPDFReaderView reader = new MuPDFReaderView(this);
       View mButtonsView = new View(this);
          reader.setAdapter(new MuPDFPageAdapter(this, new FilePicker.FilePickerSupport() {
            @Override
            public void performPickFor(FilePicker filePicker) {

            }
        },core));
        reader.setDisplayedViewIndex(616);
        layout.addView(reader);
        layout.addView(mButtonsView);
*/
    }

    public void PageCount(View view) {
        MuPDFCore core = null;
        try {
            core = new MuPDFCore(this, "/mnt/sdcard/download/vc3.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
        int count = 0;
        if (core != null) {
            count = core.countPages();
        }
        String countString = Integer.toString(count);
        Toast.makeText(MainActivity.this,
                countString,
                Toast.LENGTH_SHORT).show();
    }
}
