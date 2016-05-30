package y29.schedule.common.util;

import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;



/**
 * Created by krishan on 18/2/16.
 */
public class PicassoImageLoader implements ImageLoader {

    @Override
    public void show(String url, ImageView imageView) {
        if (TextUtils.isEmpty(url)) url = "notavail";
        Picasso.with(AppContextProvider.getContext()).load(url).into(imageView);
    }

    @Override
    public void show(List<String> urls, ImageView imageView) {
        String url = "notavail";
        if (urls != null && urls.size() > 0 && !TextUtils.isEmpty(urls.get(0))) {
            url = urls.get(0);
        }
        show(url, imageView);
    }
}
