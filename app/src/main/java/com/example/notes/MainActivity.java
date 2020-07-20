package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private static final String TAG ="find" ;
    ArrayList<notesData>mExampleList;
    private RecyclerView recyclerView;
    private NotesAdapter notesAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    FloatingActionButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadData();
        buildRecyclerView();
        Button save=findViewById(R.id.Save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savedata();
            }

            private void savedata() {
                SharedPreferences sharedPreferences=getSharedPreferences("pref",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                Gson gson=new Gson();
                String json=gson.toJson(mExampleList);
                Log.d(TAG, json);
                editor.putString("tasklist",json);
                editor.apply();

            }
        });



        button=(FloatingActionButton) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewActivity();

            }

        });

    }

    private void buildRecyclerView() {

        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
        notesAdapter=new NotesAdapter(mExampleList);
        insertItem();
    }

    private void insertItem() {
        Intent i=getIntent();
        String edit1=i.getStringExtra("title");
        String edit2=i.getStringExtra("body");
        mExampleList.add(new notesData(edit1,edit2));
        notesAdapter.notifyItemInserted(mExampleList.size());
    }

    private void loadData() {
        SharedPreferences sharedPreferences=getSharedPreferences("pref",MODE_PRIVATE);
        Gson gson=new Gson();
        String json= sharedPreferences.getString("tasklist",null);
        Type type = new TypeToken<ArrayList<notesData>>(){}.getType();
        mExampleList=gson.fromJson(json,type);

        if (mExampleList==null){
            mExampleList=new ArrayList<>();
        }
    }

    public void openNewActivity(){
        Intent i;
        i = new Intent(this,NewActivity.class);
        startActivity(i);
    }

}