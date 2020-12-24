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

    /**
     * method to provide a fragment view on the screen
     * @param inflater inflates the layout to the fragment
     * @param container the view where the layout is going to be inflated
     * @param savedInstanceState state of the layout at which it is inflated
     * @return view on the screen
     */

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_framed, container, false);
    }

    /**
     * method to handle operations on view
     * @param rootView is where the actual view is created
     * @param savedInstanceState state of the view at a time
     */
    @Override
    public void onViewCreated(@NonNull View rootView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(rootView, savedInstanceState);

        final View view = rootView;

        fAnimImage = view.findViewById(R.id.ivFrameImages);

        fAnimStart = view.findViewById(R.id.btnAnimStart);
        fAnimStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // on a click of a start button, method is called
                //  to start the animation
                startFrameAnimation();
            }
        });

        fAnimStop = view.findViewById(R.id.btnAnimStop);
        fAnimStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // on a click of a button, a method is called
                //  to stop the animation
                stopFrameAnimation();
            }
        });
    }

    /**
     * method to handle animation of framed images
     *  to animate them in given time duration
     */
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

    /**
     * method to clear or stop the animation from the state
     */
    public void stopFrameAnimation() {
        fAnimationDrawable.stop();
        fAnimationDrawable.setVisible(false, false);
    }


}
