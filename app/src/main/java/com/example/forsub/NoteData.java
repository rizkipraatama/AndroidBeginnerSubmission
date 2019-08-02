package com.example.forsub;

import java.util.ArrayList;

public class NoteData {
    public static String[][] data = new String[][]{
            {"Meeting Mingguan Kerja PT.Kerja", "UPNORMAL Jln. Sudirman","Senin 10.00-12.00","https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Harlem_Micky_Dz.jpg/800px-Harlem_Micky_Dz.jpg"},
            {"Tour Sepeda sama Temen SMA", "Depan SMA 01","Selasa 06.00-14.00","https://d279m997dpfwgl.cloudfront.net/wp/2018/10/1002_cycling-1000x667.jpg"},
            {"Nikahan Mantan SMP", "Gedung Serbaguna","Sabtu 11.00-12.00","https://cdn1-production-images-kly.akamaized.net/3nyKIeOxwGNNuU-duMDoDET0Vcg=/640x640/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/1698534/original/4976aa5b7cdb1c50e3120d3c8726ad91ernikahan-raisa-dan-hamish-album-foto-seremoni-akad-nikah-dan-resepsi-siang-8.jpg"},
            {"Jogging", "Kambang Iwak","Senin 16.00-17.00","https://gatra.online/foldershared/images/2019/erry/05-May/taman.jpg"},
            {"Hit The Gym", "Gym","Senin 20.00-11.00","https://everybody.org.uk/wp-content/uploads/2018/07/alsager-gym-everybody-sport-recreation2-1200x700.jpg"},
            {"Meeting with client", "Kantor","Rabu 13.00-14.00","https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Fglennllopis%2Ffiles%2F2018%2F02%2Fshutterstock_1253381451-300x200.jpg"},
            {"Dinas Luar","Jakarta","Kamis 08.00-17.00","https://images2.minutemediacdn.com/image/upload/c_crop,h_1189,w_2119,x_0,y_13/f_auto,q_auto,w_1100/v1554929260/shape/mentalfloss/538764-istock-898619710.jpg"},
            {"Jogging", "Kambang Iwak","Jumat 16.00-17.00","https://asset-a.grid.id/crop/0x0:0x0/700x465/photo/2019/06/16/1568273111.jpg"},
            {"Hit The Gym", "Gym","Jumat 20.00-11.00","https://www.theclubatmapledurham.com/wp-content/uploads/sites/19/2018/11/Personal-Training.jpg"},
            {"Meeting with Boss", "Kantor","Sabtu 13.00-14.00","https://www.1life.co.uk/app/uploads/sites/47/2018/06/Meeting-room-800x400.jpg"},
    };
    public static ArrayList<Note> getListData(){
        ArrayList<Note> list = new ArrayList<>();
        for (String[] aData : data) {
            Note note = new Note();
            note.setNote_name(aData[0]);
            note.setPlace(aData[1]);
            note.setTime(aData[2]);
            note.setPhoto(aData[3]);
            list.add(note);
        }
        return list;
    }
}
