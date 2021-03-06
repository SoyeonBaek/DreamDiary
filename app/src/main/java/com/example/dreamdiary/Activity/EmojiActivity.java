package com.example.dreamdiary.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.dreamdiary.Data.Diary;
import com.example.dreamdiary.R;

import java.lang.reflect.TypeVariable;
import java.text.Format;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmojiActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("created");
        int unicode = 0x1F60A;
        setContentView(R.layout.activity_emoji);
        String emoji;
        GridLayout grid = (GridLayout)findViewById(R.id.gridLayout);
        Intent intent = getIntent();
        String date = intent.getStringExtra("date");
        System.out.println("test" + date);

        for(int i = 0; i < 56; i++ ) {
            Button emoji_button = new Button(this);
            emoji = getEmojiByUnicode(unicode+i);
            emoji_button.setText(emoji);
            emoji_button.setId(unicode+i);
            emoji_button.setBackgroundColor(Color.parseColor("#00000000"));
            emoji_button.setTextSize((int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 15, getResources().getDisplayMetrics()));
            emoji_button.setGravity(Gravity.CENTER);
            emoji_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(EmojiActivity.this, KeywordActivity.class);
                    Diary diary = new Diary();
                    diary.setEmoji(view.getId());
                    if(diary != null){
                        intent.putExtra("diary", diary);
                    }
                    intent.putExtra("date", date);
                    startActivity(intent);
                }
            });
            grid.addView(emoji_button);
        }

    }

    public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }
}