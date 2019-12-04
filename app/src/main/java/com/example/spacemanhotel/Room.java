package com.example.spacemanhotel;

import java.util.HashMap;

public class Room {
    public static HashMap<Integer, String> ROOM_TYPE = new HashMap<Integer, String>();
    {
        ROOM_TYPE.put(1, "单人间");
        ROOM_TYPE.put(2, "双人间");
        ROOM_TYPE.put(3, "豪华间");
    }
    private int room_img_src_id;
    private int room_type;
    private String room_message;
    private String room_id;
    private int RMB_img_src_id;
    private int room_price;

    public Room(){
        room_img_src_id = R.drawable.single_room_1;
        room_type = 1;
        room_message = "25平米  无餐食  大床  单人入住  有窗";
        room_id = "编号  0001";
        RMB_img_src_id = R.drawable.rmb;
        room_price = 4399;
    }
    public int getRoom_img_src_id() {
        return room_img_src_id;
    }

    public void setRoom_img_src_id(int room_img_src_id) {
        this.room_img_src_id = room_img_src_id;
    }

    public int getRoom_type() {
        return room_type;
    }

    public void setRoom_type(int room_type) {
        this.room_type = room_type;
    }

    public String getRoom_message() {
        return room_message;
    }

    public void setRoom_message(String room_message) {
        this.room_message = room_message;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public int getRMB_src_id() {
        return RMB_img_src_id;
    }

    public void setRMB_src_id(int RMB_src_id) {
        this.RMB_img_src_id = RMB_src_id;
    }

    public int getRoom_price() {
        return room_price;
    }

    public void setRoom_price(int room_price) {
        this.room_price = room_price;
    }


}
