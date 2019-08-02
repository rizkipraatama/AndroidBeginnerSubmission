package com.example.forsub;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Moveit extends AppCompatActivity {
    public static final String EXTRA_NOTE = "note_name";
    public static final String EXTRA_PLACE = "place";
    public static final String EXTRA_URL = "url";
    public static final String EXTRA_TIME = "time";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_details);

        TextView tvDataReceived = findViewById(R.id.tv_data_received);
        String imageUrl = getIntent().getStringExtra(EXTRA_URL);
        new DownloadImageTask((ImageView) findViewById(R.id.img_item_photo2))
                .execute(imageUrl);
        String name = getIntent().getStringExtra(EXTRA_NOTE);
        String place = getIntent().getStringExtra(EXTRA_PLACE);
        String time = getIntent().getStringExtra(EXTRA_TIME);
        String text = "Note : " + name + "\nPlace : " + place + "\nTime : " + time;
        tvDataReceived.setText(text);
    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
