package com.example.forsub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private RecyclerView rvHeroes;
    private ArrayList<Note> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeroes = findViewById(R.id.rv_hero);
        rvHeroes.setHasFixedSize(true);
        list.addAll(NoteData.getListData());
        showRecyclerCardList();
    }

    private void showRecyclerCardList() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        CardNoteAdapter cardViewHeroAdapter = new CardNoteAdapter(list);
        rvHeroes.setAdapter(cardViewHeroAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_cardview:
                showRecyclerCardList();
                break;
            case R.id.action_about:
                Intent moveIntent = new Intent(MainActivity.this, About.class);
                startActivity(moveIntent);
                break;
        }
    }

}
