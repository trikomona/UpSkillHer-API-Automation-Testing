package org.upskillher.models;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class BookingData {
    public static Map<String, Object> getBookingMap(){

        int roomId = ThreadLocalRandom.current().nextInt(1, 1001); // la habitacion cambia para hacer varias pruebas
        // Map anidado para bookingdates
        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2025-10-20"); //revisar las fechas nos dan hasta octubre 2025
        bookingDates.put("checkout", "2025-11-30"); //año, mes, dia

        // Map principal
        Map<String, Object> bookingMap = new HashMap<>();  //Se crea un objeto del mapa para su manipulacion
        bookingMap.put("roomid", roomId);
        bookingMap.put("firstname", "John");
        bookingMap.put("lastname", "Doe");
        bookingMap.put("depositpaid", false);
        bookingMap.put("bookingdates", bookingDates); // Map anidado
        bookingMap.put("email", "john.doe@example.com");
        bookingMap.put("phone", "345234234566");
        return bookingMap;
    }//getBookingMap

    public static Map<String, Object> getBookingMapWrongDates(){

        int roomId = ThreadLocalRandom.current().nextInt(1, 1001); // la habitacion cambia para hacer varias pruebas
        // Map anidado para bookingdates
        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2025-05-20"); //fechas pasadas, Mayp 2025
        bookingDates.put("checkout", "2025-05-30"); //año, mes, dia

        // Map principal
        Map<String, Object> wrogBookingMap = new HashMap<>();  //Se crea un objeto del mapa para su manipulacion
        wrogBookingMap.put("roomid", roomId);
        wrogBookingMap.put("firstname", "Jaimie");
        wrogBookingMap.put("lastname", "Lanister");
        wrogBookingMap.put("depositpaid", true);
        wrogBookingMap.put("bookingdates", bookingDates); // Map anidado de dias
        wrogBookingMap.put("email", "jaimielanister@gmail.com");
        wrogBookingMap.put("phone", "345234234566");
        return wrogBookingMap;
    }//getBoookingMapWrongDates

    public static Map<String, Object> getBookingWithEmptyDetails(){

        int roomId = ThreadLocalRandom.current().nextInt(1, 1001); // la habitacion cambia para hacer varias pruebas
        // Map anidado para bookingdates
        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2025-10-20"); //fechas correctas
        bookingDates.put("checkout", "2025-10-30"); //año, mes, dia

        // Map principal
        Map<String, Object> emptyDetails = new HashMap<>();  //Se crea un objeto del mapa para su manipulacion
        emptyDetails.put("roomid", "");
        emptyDetails.put("firstname", "");
        emptyDetails.put("lastname", "");
        emptyDetails.put("depositpaid", true);
        emptyDetails.put("bookingdates", bookingDates); // Map anidado de dias
        emptyDetails.put("email", "");
        emptyDetails.put("phone", "");
        return emptyDetails;
    }//getBookingWithEmptyDetails

    public static Map<String, Object> getBookingWithoutBookingDates(){

        int roomId = ThreadLocalRandom.current().nextInt(1, 1001); // la habitacion cambia para hacer varias pruebas
        // Map anidado para bookingdates
        Map<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2025-10-20"); //fechas correctas
        bookingDates.put("checkout", "2025-10-30"); //año, mes, dia

        // Map principal
        Map<String, Object> emptyDates = new HashMap<>();  //Se crea un objeto del mapa para su manipulacion
        emptyDates.put("roomid", roomId);
        emptyDates.put("firstname", "Nicolas");
        emptyDates.put("lastname", "Tesla");
        emptyDates.put("depositpaid", false);
        emptyDates.put("email", "");
        emptyDates.put("phone", "");
        return emptyDates;
    }//getBookingWithEmptyDetails



}//BoookingData
