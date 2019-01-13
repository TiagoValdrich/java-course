package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date date;
    private Double value;

    public Installment(Date date, Double value) {
        this.date = date;
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return sdf.format(this.getDate()) + " - " + this.getValue();
    }

}
