package y29.schedule.common.util;

import android.widget.ImageView;

import java.util.List;

/**
 * Created by krishan on 18/2/16.
 */
public interface ImageLoader {
    void show(String url, ImageView imageView);

    void show(List<String> urls, ImageView imageView);

}
