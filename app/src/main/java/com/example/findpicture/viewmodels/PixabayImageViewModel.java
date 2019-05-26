package com.example.findpicture.viewmodels;

import android.os.Build;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.findpicture.Models.PixabayModel;
import com.example.findpicture.R;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;

public class PixabayImageViewModel extends BaseObservable {
    private PixabayModel pixabayImage;

    public PixabayImageViewModel(PixabayModel pixabayImage) {
        this.pixabayImage = pixabayImage;
    }

    public String getTags() {
        return pixabayImage.getTags();
    }

    public String getImageUrl() {
        return pixabayImage.getPreviewURL();
    }

    public String getHighResImageUrl() {
        return pixabayImage.getWebformatURL();
    }

    public String getLikes() {
        return pixabayImage.getLikes();
    }

    public String getComments() {
        return pixabayImage.getComments();
    }

    public String getFavorites() {
        return pixabayImage.getFavorites();
    }

    public String getUserName() {
        return pixabayImage.getUser();
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.ic_image_placeholder)

                .into(view);
    }

    public View.OnClickListener openDetails() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if we're running on Android 5.0 or higher
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    // Apply activity transition
                } else {
                    // Swap without transition
                }
            }
        };
    }
}