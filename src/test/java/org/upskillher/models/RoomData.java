package org.upskillher.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomData {

    public static Map<String, Object> createNewRoomUsingRoomData(
            String roomName, String type, boolean accessible,
            String description, String image, String roomPrice, List<String> features) {

        Map<String, Object> roomBody = new HashMap<>();
        roomBody.put("roomName", roomName);
        roomBody.put("type", type);
        roomBody.put("accessible", accessible);
        roomBody.put("description", description);
        roomBody.put("image", image);
        roomBody.put("roomPrice", roomPrice);
        roomBody.put("features", features);

        return roomBody;
    }//map
}//RoomData
