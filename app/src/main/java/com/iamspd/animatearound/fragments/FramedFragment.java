package com.iamspd.animatearound.fragments;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.iamspd.animatearound.R;

public class FramedFragment extends Fragment {

    // widgets
    private ImageView fAnimImage;
    private Button fAnimStart, fAnimStop;

    // drawable graphic
    private AnimationDrawable fAnimationDrawable = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_framed, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View rootView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(rootView, savedInstanceState);

        final View view = rootView;

        fAnimImage = view.findViewById(R.id.ivFrameImages);

        fAnimStart = view.findViewById(R.id.btnAnimStart);
        fAnimStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFrameAnimation();
            }
        });

        fAnimStop = view.findViewById(R.id.btnAnimStop);
        fAnimStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopFrameAnimation();
            }
        });
    }

    public void startFrameAnimation() {
        BitmapDrawable img1 = (BitmapDrawable) getResources().getDrawable(R.drawable.img1);
        BitmapDrawable img2 = (BitmapDrawable) getResources().getDrawable(R.drawable.img2);
        BitmapDrawable img3 = (BitmapDrawable) getResources().getDrawable(R.drawable.img3);
        BitmapDrawable img4 = (BitmapDrawable) getResources().getDrawable(R.drawable.img4);
        BitmapDrawable img5 = (BitmapDrawable) getResources().getDrawable(R.drawable.img5);
        BitmapDrawable img6 = (BitmapDrawable) getResources().getDrawable(R.drawable.img6);
        BitmapDrawable img7 = (BitmapDrawable) getResources().getDrawable(R.drawable.img7);

        int reasonableDuration = 550;
        fAnimationDrawable = new AnimationDrawable();
        fAnimationDrawable.setOneShot(false);
        fAnimationDrawable.addFrame(img1, reasonableDuration);
        fAnimationDrawable.addFrame(img2, reasonableDuration);
        fAnimationDrawable.addFrame(img3, reasonableDuration);
        fAnimationDrawable.addFrame(img4, reasonableDuration);
        fAnimationDrawable.addFrame(img5, reasonableDuration);
        fAnimationDrawable.addFrame(img6, reasonableDuration);
        fAnimationDrawable.addFrame(img7, reasonableDuration);

        fAnimImage.setBackground(fAnimationDrawable);


        fAnimationDrawable.setVisible(true, true);
        fAnimationDrawable.start();
    }

    public void stopFrameAnimation() {
        fAnimationDrawable.stop();
        fAnimationDrawable.setVisible(false, false);
    }


}
