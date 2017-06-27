package seecolors.seecolors;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCamera = (Button) findViewById(R.id.btnCamera);
        imageView = (ImageView) findViewById(R.id.imageView);

        text = (TextView) findViewById(R.id.textView);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, 1);
                }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
            int color = imageBitmap.getPixel(0,0);



            /*int g = (color & 0xFF000000) >>> 24;
            int b = (color & 0x00FF0000) >>> 16;
            int r = (color & 0x0000FF00) >>> 8;*/

            int r = Color.red(color);
            int g = Color.green(color);
            int b = Color.blue(color);
//            Log.d("", "&*" + dist(r,g,b,255,255,255));
//            this.text.setText("g = " + g + " | b = " + b + " | r = " + r);
//
//  this.text.setText("oi" + dist(r,g,b,255,255,255));
        int[][] colors = {
                {255,0,0},
                {0,255,255},
                {255,255,0},
                {0,255,0},
                {255,0,255},
                {0,0,255},
                {255,255,255},
                {0,0,0}
        };
        String[] nomeColors = {
                "vermelho",
                "cyano",
                "amarelo",
                "verde",
                "magenta",
                "azul",
                "branco",
                "preto"
        };


        }

    }
       public double dist(int r1, int g1, int b1, int r2, int g2, int b2){
          int rF = r1 - r2;
          int gF = g1 - g2;
          int bF = b1 - b2;
           return Math.sqrt(Math.pow(rF, 2)+ Math.pow(gF, 2) + Math.pow(bF, 2));
    }
        public double compareColors(){

        }

}
