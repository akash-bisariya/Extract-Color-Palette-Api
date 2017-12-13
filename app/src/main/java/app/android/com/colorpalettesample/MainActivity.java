package app.android.com.colorpalettesample;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout rlView1;
    private RelativeLayout rlView2;
    private RelativeLayout rlView3;
    private ImageView ivImage1;
    private ImageView ivImage2;
    private ImageView ivImage3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivImage1=findViewById(R.id.iv_image_1);
        ivImage2=findViewById(R.id.iv_image_2);
        ivImage3=findViewById(R.id.iv_image_3);
        rlView1=findViewById(R.id.rl_layout_1);
        rlView2=findViewById(R.id.rl_layout_2);
        rlView3=findViewById(R.id.rl_layout_3);
        ivImage1.setImageResource(R.drawable.tiger1);
        ivImage2.setImageResource(R.drawable.tiger2);
        ivImage3.setImageResource(R.drawable.tiger3);


        Palette.from(BitmapFactory.decodeResource(getResources(),R.drawable.tiger1)).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                rlView1.setBackground(getGradientDrawable(palette.getMutedSwatch().getRgb(),palette.getLightMutedSwatch().getRgb(),palette.getDarkMutedSwatch().getRgb()));
            }
        });
        Palette.from(BitmapFactory.decodeResource(getResources(),R.drawable.tiger2)).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                rlView2.setBackground(getGradientDrawable(palette.getMutedSwatch().getRgb(),palette.getLightVibrantSwatch().getRgb(),palette.getDarkMutedSwatch().getRgb()));
            }
        });
        Palette.from(BitmapFactory.decodeResource(getResources(),R.drawable.tiger3)).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                rlView3.setBackground(getGradientDrawable(palette.getMutedSwatch().getRgb(),palette.getLightMutedSwatch().getRgb(),palette.getDarkMutedSwatch().getRgb()));
            }
        });




    }

    private GradientDrawable getGradientDrawable(int topColor,int centerColor,int bottomColor)
    {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setColors(new int[]{
                topColor,
                centerColor,
                bottomColor
        });
        return gradientDrawable;
    }
}
