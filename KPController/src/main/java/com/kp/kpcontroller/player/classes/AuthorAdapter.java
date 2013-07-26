package com.kp.kpcontroller.player.classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kp.kpcontroller.MainActivity;
import com.kp.kpcontroller.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Usuario on 25/07/13.
 */
public class AuthorAdapter extends BaseAdapter {
    private ArrayList<Author> Authors = new ArrayList<Author>();
    private static LayoutInflater inflater=null;

    public AuthorAdapter(ArrayList<Author> data) {
        this.Authors = data;
        inflater = (LayoutInflater)MainActivity.getInstance().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return Authors.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);

        TextView title = (TextView)vi.findViewById(R.id.title);
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image);

        Author author = this.Authors.get(position);
        title.setText(author.Name);
        //imageLoader.DisplayImage(song.get(CustomizedListView.KEY_THUMB_URL), thumb_image);
        return vi;
    }
}
