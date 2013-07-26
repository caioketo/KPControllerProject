package com.kp.kpcontroller.player;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kp.kpcontroller.R;
import com.kp.kpcontroller.player.classes.Author;
import com.kp.kpcontroller.player.classes.AuthorAdapter;

import java.util.ArrayList;

/**
 * Created by Usuario on 25/07/13.
 */
public class MusicsFragment extends Fragment  {
    private ArrayList<Author> authors = new ArrayList<Author>();

    public MusicsFragment() {
        authors.add(new Author(1, "Teste"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_kpplayer_musics, container, false);
        ListView list=(ListView)rootView.findViewById(R.id.lst_musics);
        AuthorAdapter adapter = new AuthorAdapter(authors);
        list.setAdapter(adapter);

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return rootView;
    }
}
