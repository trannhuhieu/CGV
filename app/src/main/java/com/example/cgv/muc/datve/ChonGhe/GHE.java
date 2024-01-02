package com.example.cgv.muc.datve.ChonGhe;

public class GHE {
    String seat_id, seat_type, number;

    public GHE(String seat_id, String seat_type, String number) {
        this.seat_id = seat_id;
        this.seat_type = seat_type;
        this.number = number;
    }

    public String getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(String seat_id) {
        this.seat_id = seat_id;
    }

    public String getSeat_type() {
        return seat_type;
    }

    public void setSeat_type(String seat_type) {
        this.seat_type = seat_type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
