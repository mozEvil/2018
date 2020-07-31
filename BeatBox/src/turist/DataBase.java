package turist;

import java.io.*;
import java.util.*;

/**
 * Created by Женя on 28.07.2017.
 */

public class DataBase implements Serializable {

    static final long serialVersionUID = -8691480648869885025L;

    private static DataBase instance;

    private int nextId_tourist;
    private int nextId_tour;
    private int nextId_tourney;
//    private int nextId_user;

    private Map<Integer, Tourist> tourists;
    private Map<Integer, Tour> tours;
    private Map<Integer, Tourney> tourneys;
//    private Map<Integer, User> users;
    private Map<String, User> users;

    private DataBase() {
        nextId_tourist = 1;
        nextId_tour = 1;
        nextId_tourney = 1;
//        nextId_user = 1;
        tourists = new HashMap<>();
        tours = new HashMap<>();
        tourneys = new HashMap<>();
        users = new HashMap<>();
//        users.put(nextId_user++, new User("admin", "admin"));
        users.put("", new User("", "".toCharArray()));
        users.put("admin", new User("admin", "admin".toCharArray()));
    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = load();
        }
        return instance;
    }

    private static DataBase load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("DB.ser")))) {
            instance = (DataBase) ois.readObject();
            ois.close();
            return instance;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new DataBase();
        }
    }

    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("DB.ser")))) {
            oos.writeObject(instance);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTourist(Tourist tourist) {
        tourist.setId(nextId_tourist);
        tourists.put(nextId_tourist++, tourist);
    }

    public void addTour(Tour tour) {
        tour.setId(nextId_tour);
        tours.put(nextId_tour++, tour);
    }

    public void addTourney(Tourney tourney) {
        tourney.setId(nextId_tourney);
        tourneys.put(nextId_tourney++, tourney);
    }

    public Tourist getTourist(int id) {
        return tourists.get(id);
    }

    public Tour getTour(int id) {
        return tours.get(id);
    }

    public Tourney getTourney(int id) {
        return tourneys.get(id);
    }

    public void deleteTourist(int id) {
        tourists.get(id).delete();
    }

    public void deleteTour(int id) {
        tours.get(id).delete();
    }

    public void deleteTourney(int id) {
        tourneys.get(id).delete();
    }

    public Collection<Tourist> getAllTourists() {
        return (List<Tourist>) tourists.values();
    }

    public Collection<Tour> getAllTours() {
        return (List<Tour>) tours.values();
    }

    public Collection<Tourney> getAllTourneys() {
        return (List<Tourney>) tourneys.values();
    }

    public ArrayList<Tourist> getActiveTourists() {
        ArrayList<Tourist> result = new ArrayList<>();
        for (Tourist t : tourists.values()) {
            if (t.isActive()) result.add(t);
        }
        return result;
    }

    public ArrayList<Tour> getActiveTours() {
        ArrayList<Tour> result = new ArrayList<>();
        for (Tour t : tours.values()) {
            if (t.isActive()) result.add(t);
        }
        return result;
    }

    public ArrayList<Tourney> getActiveTourneys() {
        ArrayList<Tourney> result = new ArrayList<>();
        for (Tourney t : tourneys.values()) {
            if (t.isActive()) result.add(t);
        }
        return result;
    }

    public Collection<User> getUsers() {
        return users.values();
    }

    public void addUser(User user) {
//        users.put(nextId_user++, user);
        users.put(user.getLogin(), user);
    }

    public User getUser(String login) {
        return users.get(login);
    }






}
