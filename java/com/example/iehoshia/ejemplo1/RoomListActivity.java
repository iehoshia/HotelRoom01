package com.example.iehoshia.ejemplo1;

import java.util.ArrayList;

import com.example.iehoshia.ejemplo1.data.CustomAdapter;
import com.example.iehoshia.ejemplo1.models.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.app.ListActivity;
import android.content.Intent;

public class RoomListActivity extends ListActivity {
	/*
	private final static String STANDARD_ROOM = "standard";
	private final static String LUXURY_ROOM = "luxury";
	private final static String ROOM_NUMBER = "number";
	private final static String ROOM_TYPE = "type";
	 */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);

        ArrayList<Room> rooms = new ArrayList<Room>();

        for (String room : getResources().getStringArray(R.array.array_rooms_standard)) {
            Room one_room = new Room(room, Room.STANDARD_ROOM);
            rooms.add(one_room);
        }

        for (String room : getResources().getStringArray(R.array.array_rooms_luxury)) {
            Room one_room = new Room(room, Room.LUXURY_ROOM);
            rooms.add(one_room);
        }

        CustomAdapter adapter = new CustomAdapter(this, rooms);
        setListAdapter(adapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Room clicked_room = (Room) l.getItemAtPosition(position);
        Intent intent = new Intent(this, RoomDetailActivity.class);
        intent.putExtra(RoomDetailActivity.ROOM_TYPE, clicked_room.getRoomType());
        intent.putExtra(RoomDetailActivity.ROOM_NUMBER, clicked_room.getRoomNumber());
        startActivity(intent);
    }
}