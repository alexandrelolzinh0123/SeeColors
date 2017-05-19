package seecolors.seecolors;

import android.content.Intent;
import android.graphics.Bitmap;
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

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);

            }
        });
    }

    Palette.PaletteAsyncListener paletteListener = new Palette.PaletteAsyncListener() {
        public void onGenerated(Palette palette) {
            // access palette colors here
        }
    };


    String[][] colors = new String[][]{
            {"Água", "#00ffff"},
            {"Água-marinha média", "#66cdaa"},
            {"Alizarina", "#e32636"},
            {"Amarelo esverdeado", "#adff2f"},
            {"Amarelo queimado", "#eead2d"},
            {"Âmbar", "#ffbf00"},
            {"Ameixa", "#dda0dd"},
            {"Ametista", "#9966cc"},
            {"Aspargo", "#7ba05b"},
            {"Azul", "#0000ff"},
            {"Azul ardósia", "#6a5acd"},
            {"Azul ardósia claro", "#8470ff"},
            {"Azul ardósia escuro", "#483d8b"},
            {"Azul ardósia médio", "#7b68ee"},
            {"Azul areado", "#b8cad4"},
            {"Azul aço", "#4682b4"},
            {"Azul aço claro", "#b0c4de"},
            {"Azul cadete", "#5f9ea0"},
            {"Azul camarada", "#054f77"},
            {"Azul celeste brilhante", "#007fff"},
            {"Azul claro", "#add8e6"},
            {"Azul cobalto", "#0047ab"},
            {"Azul céu", "#87ceeb"},
            {"Azul céu claro", "#87cefa"},
            {"Azul céu profundo", "#00bfff"},
            {"Azul escuro", "#00008b"},
            {"Azul flor de milho", "#6495ed"},
            {"Azul força aérea", "#5d8aa8"},
            {"Azul furtivo", "#1e90ff"},
            {"Azul manteiga", "#a6aa3e"},
            {"Azul marinho", "#120a8f"},
            {"Azul meia-noite", "#191970"},
            {"Azul médio", "#0000cd"},
            {"Azul petróleo", "#084d6e"},
            {"Azul real", "#4169e1"},
            {"Azul taparuere", "#248eff"},
            {"Azul violeta", "#8a2be2"},
            {"Açafrão", "#f4c430"},
            {"Bordô", "#800000"},
            {"Borgonha", "#900020"},
            {"Bronze", "#cd7f32"},
            {"Caramelo", "#8b5742"},
            {"Cardo", "#d8bfd8"},
            {"Carmesim", "#dc143c"},
            {"Carmim", "#712f26"},
            {"Castanho avermelhado", "#8b0000"},
            {"Castanho claro", "#d2b48c"},
            {"Cenoura", "#ed9121"},
            {"Cereja", "#de3163"},
            {"Cereja Hollywood", "#f400a1"},
            {"Chocolate", "#d2691e"},
            {"Ciano", "#00ffff"},
            {"Ciano escuro", "#008b8b"},
            {"Cinza", "#808080"},
            {"Cinza ardósia", "#708090"},
            {"Cinza ardósia claro", "#778899"},
            {"Cinza ardósia escuro", "#2f4f4f"},
            {"Cinza escuro", "#a9a9a9"},
            {"Cinza fosco", "#696969"},
            {"Cobre", "#b87333"},
            {"Coral", "#ff7f50"},
            {"Coral claro", "#f08080"},
            {"Couro", "#f0dc82"},
            {"Caqui escuro", "#bdb76b"},
            {"Dainise", "#778899"},
            {"Dourado", "#daa520"},
            {"Dourado escuro", "#b8860b"},
            {"Escarlate", "#ff2400"},
            {"Esmeralda", "#50c878"},
            {"Feldspato", "#d19275"},
            {"Ferrugem", "#b7410e"},
            {"Fuligem", "#3d2b1f"},
            {"Fúchsia", "#ff00ff"},
            {"Grená", "#831d1c"},
            {"Herbal", "#2e8b57"},
            {"Índigo", "#4b0082"},
            {"Jade", "#00a86b"},
            {"Jambo", "#ff4500"},
            {"Jabuti preto", "#000000"},
            {"Laranja", "#ffa500"},
            {"Laranja escuro", "#ff8c00"},
            {"Lilás", "#c8a2c8"},
            {"Limão (cor)", "#00ff00"},
            {"Madeira", "#deb887"},
            {"Magenta", "#ff00ff"},
            {"Magenta escuro", "#8b008b"},
            {"Malva", "#e0b0ff"},
            {"Marrom", "#964b00"},
            {"Marrom amarelado", "#f4a460"},
            {"Marrom claro", "#a52a2a"},
            {"Marrom rosado", "#bc8f8f"},
            {"Marrom sela", "#8b4513"},
            {"Naval", "#000080"},
            {"Ocre", "#cc7722"},
            {"Oliva", "#808000"},
            {"Oliva escura", "#556b2f"},
            {"Oliva parda", "#6b8e23"},
            {"Orquídea", "#da70d6"},
            {"Orquídea escura", "#9932cc"},
            {"Orquídea média", "#ba55d3"},
            {"Ouro", "#ffd700"},
            {"Pele", "#cd853f"},
            {"Prata", "#c0c0c0"},
            {"Preto", "#000000"},
            {"Púrpura", "#800080"},
            {"Púrpura média", "#9370db"},
            {"Quantum", "#111111"},
            {"Rosa", "#ffcbdb"},
            {"Rosa brilhante", "#ff007f"},
            {"Rosa chocante", "#fc0fc0"},
            {"Rosa claro", "#ffb6c1"},
            {"Rosa forte", "#ff69b4"},
            {"Rosa profundo", "#ff1493"},
            {"Roxo", "#993399"},
            {"Rútilo", "#6d351a"},
            {"Salmão", "#fa7f72"},
            {"Salmão claro", "#ffa07a"},
            {"Salmão escuro", "#e9967a"},
            {"Siena", "#ff8247"},
            {"Sépia", "#705714"},
            {"Terracota", "#e2725b"},
            {"Tijolo refratário", "#b22222"},
            {"Tomate", "#ff6347"},
            {"Triássico", "#ff2401"},
            {"Turquesa", "#40e0d0"},
            {"Turquesa escura", "#00ced1"},
            {"Turquesa média", "#48d1cc"},
            {"Urucum", "#ec2300"},
            {"Verde", "#008000"},
            {"Verde espectro", "#00ff00"},
            {"Verde amarelado", "#9acd32"},
            {"Verde claro", "#90ee90"},
            {"Verde escuro", "#006400"},
            {"Verde floresta", "#228b22"},
            {"Verde lima", "#32cd32"},
            {"Verde grama", "#7cfc00"},
            {"Verde mar claro", "#20b2aa"},
            {"Verde mar escuro", "#8fbc8f"},
            {"Verde mar médio", "#3cb371"},
            {"Verde militar", "#78866b"},
            {"Verde Paris", "#7fff00"},
            {"Verde primavera", "#00ff7f"},
            {"Verde primavera médio", "#00fa9a"},
            {"Verde pálido", "#98fb98"},
            {"Verde-azulado", "#008080"},
            {"Vermelho", "#ff0000"},
            {"Vermelho escuro", "#8b0000"},
            {"Vermelho indiano", "#cd5c5c"},
            {"Vermelho violeta", "#d02090"},
            {"Vermelho violeta médio", "#c71585"},
            {"Vermelho violeta pálido", "#db7093"},
            {"Violeta", "#ee82ee"},
            {"Violeta escuro", "#9400d3"},


    };

    public void Pallete(Palette.Swatch color) {
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                Log.e("color==>", "color: "+ String.format("#%X", color.getBodyTextColor()));
                if (colors[i][j].equals(String.format("#%X", color.getBodyTextColor()))) {
                    text.setText(colors[i][j]);
                    Log.e("color==>", "color: "+ String.format("#%X", color.getBodyTextColor()));
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        text = (TextView) findViewById(R.id.textView);
        Bitmap imagemAtual = (Bitmap) data.getExtras().get("data");

        final Palette.Builder pallete = new Palette.Builder(imagemAtual);
        pallete.generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
                Palette.Swatch vibrantSwatchDark = palette.getDarkVibrantSwatch();
                Palette.Swatch vibrantSwatchLight = palette.getLightVibrantSwatch();
                Palette.Swatch mutedSwatch = palette.getMutedSwatch();
                Palette.Swatch mutedSwatchDark = palette.getDarkMutedSwatch();
                Palette.Swatch mutedSwatchLight = palette.getLightMutedSwatch();

                if (vibrantSwatch != null) {
                    imageView.setBackgroundColor(vibrantSwatch.getRgb());
                    Pallete(vibrantSwatch);
                }

//                if (vibrantSwatchDark != null) {
//                    imageView.setBackgroundColor(vibrantSwatchDark.getRgb());
//                    Pallete(vibrantSwatchDark);
//                }
//
//                if (vibrantSwatchLight != null) {
//                    imageView.setBackgroundColor(vibrantSwatchLight.getRgb());
//                    Pallete(vibrantSwatchLight);
//                }
//
//                if (mutedSwatch != null) {
//                    imageView.setBackgroundColor(mutedSwatch.getRgb());
//                    Pallete(mutedSwatch);
//                }
//
//                if (mutedSwatchLight != null) {
//                    imageView.setBackgroundColor(mutedSwatchLight.getRgb());
//                    Pallete(mutedSwatchLight);
//                }
//
//                if (mutedSwatchDark != null) {
//                    imageView.setBackgroundColor(mutedSwatchDark.getRgb());
//                    Pallete(mutedSwatchDark);
//                }
            }
        });

    }
}
