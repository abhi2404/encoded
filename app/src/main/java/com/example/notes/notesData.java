package com.example.notes;

import android.util.Log;

public  class notesData {
    private  String mEdit1;
    private String mEdit2;

    public notesData(String edit1,String edit2){
        mEdit1=edit1;
        mEdit2=edit2;
    }
    public String getedit1(){
        return mEdit1;
    }
    public String getedit2(){
        return mEdit2;
    }
    }

