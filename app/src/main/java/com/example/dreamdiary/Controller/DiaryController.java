package com.example.dreamdiary.Controller;

import com.example.dreamdiary.Data.Diary;

import java.util.ArrayList;

//이거 singleton 으로 해야
public class DiaryController {
    private static DiaryController instance = new DiaryController();

    private DiaryController(){
    }

    public static DiaryController getInstance() {
        return instance;
    }

    ArrayList<Diary> diaries;

    ArrayList<Diary> getAllDiaris() {

        return null;
    }

}
