public class EmailNoticationObserver implements Observer{
    
    StockObservable observable;
    String email;

    public EmailNoticationObserver(StockObservable observable, String email){
        this.observable = observable;
        this.email = email;
    }

    @Override
    public void update() {
       int stock = observable.getStock();
       sendEmail(stock);
    }

    private void sendEmail(int stock){
        System.out.printf("Update: stock changed to %s. Email sent to %s \n",stock,email);
    }


}
