class Test{
    public static void main(String[] args) {
        System.out.println("obersver design pattern");

        StockObservable stockObservable = new StockObservable();
        AppNotificationObserver appNotificationObserver1 = new AppNotificationObserver(stockObservable, "helios23");
        AppNotificationObserver appNotificationObserver2 = new AppNotificationObserver(stockObservable, "Urka12");
        EmailNoticationObserver emailNoticationObserver1 = new EmailNoticationObserver(stockObservable, "abhc@ga.cm");
        stockObservable.addObserver(emailNoticationObserver1);
        stockObservable.addObserver(appNotificationObserver1);
        stockObservable.addObserver(appNotificationObserver2);

        stockObservable.updateData("12");

    }
}