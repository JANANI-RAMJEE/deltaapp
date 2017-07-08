package com.example.janani.gallery;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Integer RESULT_LOAD_IMG=1;
    String imgDecodableStr;
    String cap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new Imageadapter(this));

    }
    public void loadImagefromGallery (View view) {
        Intent galleryIntent = new Intent (Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);

    }
    @Override
    protected void onActivityResult (int requestCode , int resultCode, Intent data){
       super.onActivityResult( requestCode, resultCode, data);
        try {
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK && null != data) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn ,null ,null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableStr = cursor.getString(columnIndex);
                cursor.close();
                GridView gridView = (GridView) findViewById(R.id.gridview);
                gridView.setAdapter(new Imageadapter(this));


            }
            else {
                Toast.makeText(this, "you haven't picked an image",Toast.LENGTH_LONG).show();}}
        catch ( Exception e){
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
            }
        }
    public class Imageadapter extends BaseAdapter {
        private Context context;

        public Integer [] images = {
                R.drawable.beary,
                R.drawable.teddy
        }
                ;

        public Imageadapter (Context c){
            context = c;
        }
        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return images[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setImageBitmap(BitmapFactory.decodeFile(imgDecodableStr));
            imageView.setImageResource(images[position]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setLayoutParams(new GridView.LayoutParams(240,240));
            return imageView;
        }
    }

        }
