public class AppNotificationObserver implements Observer{

    StockObservable observable;
    String user;

    public AppNotificationObserver(StockObservable observable, String user){
        this.observable = observable;
        this.user = user;
    }

    @Override
    public void update() {
       int stock = observable.getStock();
       sendNotification(stock);
    }

    private void sendNotification(int stock){
        System.out.printf("Update: stock changed to %s. App Notificaton sent to %s \n",stock,user);
    }

    
}
