package com.example.spacemanhotel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter <RoomAdapter.ViewHolder>{

    private List<Room> RoomList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView room_img;
        TextView room_type;
        TextView room_message;
        TextView room_id;
        ImageView RMB_img;
        TextView room_price;
        Button reserve_button;

        public ViewHolder(View view){
            super(view);
            room_img = (ImageView)view.findViewById(R.id.room_img);
            room_type = (TextView)view.findViewById(R.id.room_type);
            room_message = (TextView)view.findViewById(R.id.room_message);
            room_id = (TextView)view.findViewById(R.id.room_id);
            RMB_img = (ImageView)view.findViewById(R.id.RMB_img);
            room_price = (TextView)view.findViewById(R.id.room_price);
            reserve_button = (Button)view.findViewById(R.id.reserve_button);
        }
    }

    public RoomAdapter(List<Room> RoomList){
        this.RoomList = RoomList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.room_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        Room room = RoomList.get(position);
        holder.room_img.setImageResource(room.getRoom_img_src_id());
        holder.room_type.setText(Room.ROOM_TYPE.get(room.getRoom_type()));
        holder.room_message.setText(room.getRoom_message());
        holder.room_id.setText(room.getRoom_id());
        holder.RMB_img.setImageResource(room.getRMB_src_id());
        holder.room_price.setText(room.getRoom_price()+"");
    }

    public int getItemCount(){
        return RoomList.size();
    }
}
