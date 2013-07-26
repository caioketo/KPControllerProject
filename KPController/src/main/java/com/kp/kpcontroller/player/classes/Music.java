package com.kp.kpcontroller.player.classes;

/**
 * Created by Usuario on 25/07/13.
 */
public class Music {
    public int Id;
    public String Name;
    public Album Album;

    public Music(int id, String name, Album album) {
        this.Id = id;
        this.Name = name;
        this.Album = album;
    }

    public Music(){}
}
