package com.example.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String games[]={"BGMI","PUBG PC","Valorant","GTA"};
    EditText input;
    Button addbutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> gamelist= new ArrayList<String>(Arrays.asList(games));
        listView=findViewById(R.id.listview);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,R.layout.list_item,R.id.listitemtv,gamelist);
        listView.setAdapter(arrayAdapter);
        input=findViewById(R.id.item_add_text);
        addbutton=findViewById(R.id.addbutton);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gamename=input.getText().toString();
                gamelist.add(gamename);
                arrayAdapter.notifyDataSetChanged();


            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            gamelist.remove(position);
            arrayAdapter.notifyDataSetChanged();
        });


    }
}