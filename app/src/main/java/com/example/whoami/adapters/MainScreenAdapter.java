package com.example.whoami.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.whoami.R;

import org.jetbrains.annotations.NotNull;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainScreenAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    int[] list = {R.drawable.whoami
            , R.drawable.wewilldo
            , R.drawable.start};



    String[] head = {"Who Am I","What will we do?","Let's start"};
    String[] content = {"Welcome to our App, slide to know more."
            ,"In this application, we will ask you 40 questions in order to get to know your personality through these questions."
            ,"But before that you should know the factors affecting all the characters. If you are interested click on more info button."};

    public MainScreenAdapter(Context context) {
        this.context = context;
    }
    public MainScreenAdapter(Context context, int[] list, String[] head, String[] content) {
        this.context = context;
        this.list = list;
        this.head = head;
        this.content = content;
    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view == object;
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
        layoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider,container,false);
        ImageView imageView = view.findViewById(R.id.circle_image_view);
        TextView textViewHeader = view.findViewById(R.id.slider_tv_head);
        TextView textViewContent = view.findViewById(R.id.slider_tv_content);

        imageView.setImageResource(list[position]);
        textViewHeader.setText(head[position]);
        textViewContent.setText(content[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
