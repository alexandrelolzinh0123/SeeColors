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




            /*int g = (color & 0xFF000000) >>> 24;
            int b = (color & 0x00FF0000) >>> 16;
            int r = (color & 0x0000FF00) >>> 8;*/


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
                {0,0,0},
                //{125,125,125}
        };
        String[] nomeColors = {
                "vermelho",
                "cyano",
                "amarelo",
                "verde",
                "magenta",
                "azul",
                "branco",
                "preto",
                //"cinza"
        };
        int []contCor ={0,0,0,0,0,0,0,0,0};
            for (int i = 0; i<imageBitmap.getWidth(); i++){
                for (int j = 0; imageBitmap.getHeight() > j; j++){
                    int color = imageBitmap.getPixel(i,j);
                    int r = Color.red(color);
                    int g = Color.green(color);
                    int b = Color.blue(color);
//                    this.compare(colors, r, g, b);
//                    this.text.setText("r :"+r+" g :"+g+"b :"+b);
//                    int cont = this.compare(colors, r, g, b);
                    int cont = this.compare(colors, r, g, b);
                    //if (cont == i){
                        contCor[cont]++;
                    //}


                }
            }
            //this.finc(contCor,nomeColors);
//
//            this.text.setText("indice 0:"+"=>"+contCor[0]+"indice 1 :"+contCor[1]+"indice 2 :"+contCor[2]+"indice 3 :"+contCor[3]+"indice 4 :"+contCor[4]+"indice 5:"+contCor[5]+"indice 6 :"+contCor[6]+"indice 7 :"+contCor[7]+"indice 8 :"+contCor[8]);
        this.finc(contCor,nomeColors);
        }

    }
       public double dist(int r1, int g1, int b1, int r2, int g2, int b2){
          int rF = r1 - r2;
          int gF = g1 - g2;
          int bF = b1 - b2;
           return Math.sqrt(Math.pow(rF, 2)+ Math.pow(gF, 2) + Math.pow(bF, 2));
    }
        public int compare(int[][]cor,int r, int g ,int b){
            Double min = Double.MAX_VALUE;
            double minnew = 0 ;
            int indice = -1;
            for (int i=0; i<cor.length; i++){
                minnew =this.dist(cor[i][0],cor[i][1],cor[i][2],r,g,b);
                if (minnew < min) {
                  min = minnew;
                    indice = i;
                }

            }
            return indice;
        }
    public void finc(int[] cor, String[] cores){
        int indice = -1 ;
        int max = 0 ;
        for (int i = 1; i < cor.length; i++) {
            if (cor[i] > max) {
                max = cor[i];
                indice = i;
            }
        }

        this.text.setText("cor"+cores[indice]);

    }

}
