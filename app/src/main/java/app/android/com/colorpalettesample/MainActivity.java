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
        ivImage2.setImageResource(R.drawable.tiger4);
        ivImage3.setImageResource(R.drawable.tiger3);

        Palette.from(BitmapFactory.decodeResource(getResources(),R.drawable.tiger1)).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                rlView1.setBackground(getGradientDrawable(getTopColor(palette),getCenterLightColor(palette),getBottomDarkColor(palette)));
            }
        });
        Palette.from(BitmapFactory.decodeResource(getResources(),R.drawable.tiger4)).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                rlView2.setBackground(getGradientDrawable(getTopColor(palette),getCenterLightColor(palette),getBottomDarkColor(palette)));
            }
        });
        Palette.from(BitmapFactory.decodeResource(getResources(),R.drawable.tiger3)).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                rlView3.setBackground(getGradientDrawable(getTopColor(palette),getCenterLightColor(palette),getBottomDarkColor(palette)));
            }
        });
    }


    /*
    Creating gradient drawable to be used as a background using three colors - top color ,center light color and bottom dark color
     */
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

    /**
     *
     * @param palette generated palette from image
     * @return return top color for gradient either muted or vibrant whatever is available
     */
    private int getTopColor(Palette palette)
    {
        return palette.getMutedSwatch()!=null?palette.getMutedSwatch().getRgb():palette.getVibrantSwatch().getRgb();
    }

    /**
     *
     * @param palette generated palette from image
     * @return return center light color for gradient either muted or vibrant whatever is available
     */
    private int getCenterLightColor(Palette palette)
    {
        return palette.getLightMutedSwatch()!=null?palette.getLightMutedSwatch().getRgb():palette.getLightVibrantSwatch().getRgb();
    }

    /**
     *
     * @param palette generated palette from image
     * @return return bottom dark color for gradient either muted or vibrant whatever is available
     */
    private int getBottomDarkColor(Palette palette)
    {
        return palette.getDarkMutedSwatch()!=null?palette.getDarkMutedSwatch().getRgb():palette.getDarkVibrantSwatch().getRgb();
    }
}
