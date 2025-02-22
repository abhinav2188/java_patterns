import java.util.List;

public interface Observable {
    
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyAllObservers();
    List<Observer> getObserversList();
    void updateData(Object data);
    Object getData();    

}
