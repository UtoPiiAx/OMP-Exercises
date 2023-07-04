package Aufgabe2;

public class Test {
    public static void main (String [] args) {
        Bill bill = new Bill();
        bill.setItems(new Bill.BillItem[6]);
        bill.getItems()[0] = bill.new BillItem();
        bill.getItems()[0].setPrice(100000D);
        Car car = new Car("Rolls Royce");

        car.setComponents(new CarComponent[] { new CarPart.Motor() });
        bill.getItems()[0].setItem(car);
        bill.getItems()[1] = bill.new BillItem();
        bill.getItems()[1].setPrice(2000D);

        bill.getItems()[1].setItem(new CarPart.Seat());
        for (int i = 0; i < 4; i++){
            bill.getItems()[2 + i] = bill.new BillItem();
            bill.getItems()[2 + i].setPrice(1000D);
            bill.getItems()[2 + i].setItem(new CarPart.Wheel());
        }
        System.out.println(bill);
    }
}
