package com.kp.kpcontroller.player.classes;

import java.util.ArrayList;

/**
 * Created by Usuario on 25/07/13.
 */
public class Author {
    public int Id;
    public String Name;
    public ArrayList<Album> Albums;

    public Author(int id, String name) {
        this.Id = id;
        this.Name = name;
        this.Albums = new ArrayList<Album>();
    }

    public Author(){}

    public void addAlbum(Album album) {
        this.Albums.add(album);
    }

    public Album getAlbum(int id) {
        for (Album album : this.Albums) {
            if (album.Id == id) {
                return album;
            }
        }
        return null;
    }

}
