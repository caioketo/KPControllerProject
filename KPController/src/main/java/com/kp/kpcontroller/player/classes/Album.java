package com.kp.kpcontroller.player.classes;

import java.util.ArrayList;

/**
 * Created by Usuario on 25/07/13.
 */
public class Album {
    public int Id;
    public String Name;
    public Author Author;
    public ArrayList<Music> Musics;

    public Album(int id, String name, Author author) {
        this.Id = id;
        this.Name = name;
        this.Author = author;
        this.Musics = new ArrayList<Music>();
    }

    public Album(){}

    public void addMusic(Music music) {
        this.Musics.add(music);
    }

    public Music getMusic(int id) {
        for (Music music : this.Musics) {
            if (music.Id == id) {
                return music;
            }
        }
        return null;
    }
}
