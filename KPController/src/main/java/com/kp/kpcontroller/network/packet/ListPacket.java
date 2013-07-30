package com.kp.kpcontroller.network.packet;

import com.kp.kpcontroller.player.classes.Album;
import com.kp.kpcontroller.player.classes.Author;
import com.kp.kpcontroller.player.classes.Music;

import java.util.ArrayList;

/**
 * Created by Usuario on 30/07/13.
 */
public class ListPacket {
    public ArrayList<Author> Authors = new ArrayList<Author>();
    public ArrayList<Album> Albums = new ArrayList<Album>();
    public ArrayList<Music> Musics = new ArrayList<Music>();

    public void Parse(String data) {
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == 'A') {
                i++;
                Author author = new Author();
                int end = data.substring(i).indexOf(';');
                author.Id = Integer.parseInt(data.substring(i, end));
                String temp = data.substring(end);
            }
            else if (data.charAt(i) == 'B') {

            }
            else if (data.charAt(i) == 'M') {

            }
        }
    }
}
