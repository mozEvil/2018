package turist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Женя on 28.07.2017.
 */
public class Tourney implements Serializable {

    private int id;
    private boolean status;
    private Tour tour;
    private List<Tourist> tourists;
    private Date startDate;
    private Date endDate;
    private double price;

    public Tourney() {
        status = true;
    }

    public Tourney(Tour tour, List<Tourist> tourists, Date startDate, Date endDate, double price) {
        this.tour = tour;
        this.tourists = tourists;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        status = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void delete() {
        status = false;
    }

    public boolean isActive() {
        return status;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

//    public void setTourById(int id) {
//        tour = DataBase.getTour(id);
//    }

    public void addTourist(Tourist tourist) {
        if (tourists == null) tourists = new ArrayList<>();
        tourists.add(tourist);
    }

//    public void addTouristById(int id) {
//        if (this.tourists == null) tourists = new ArrayList<>();
//        this.tourists.add(DataBase.getTourist(id));
//    }

    public List<Tourist> getTourists() {
        return tourists;
    }

    public void setTourists(List<Tourist> tourists) {
        this.tourists = tourists;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
