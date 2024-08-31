import java.util.ArrayList;
import java.util.List;

public class StockObservable implements Observable{


    List<Observer> observers;
    int stock;

    public StockObservable(){
        observers = new ArrayList<>();
        stock = 0;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for(Observer observer : observers){
            observer.update();
        }
    }

    @Override
    public List<Observer> getObserversList() {
        return observers;
    }

    @Override
    public void updateData(Object data) {
        int newStock = Integer.parseInt((String) data);
        if(stock != newStock){
            stock = newStock;
            notifyAllObservers();
        }
    }

    @Override
    public Object getData() {
        return getStock();
    }

    
    
}
