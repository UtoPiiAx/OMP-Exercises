package Aufgabe2;

public final class Bill {
    private BillItem[] items = new BillItem[0];
    public BillItem[] getItems() {
        return items;
    }
    public void setItems (BillItem[] items) {
        this.items = items;
    }

    public double getTotalPrice () {
        double sum = 0;
        for (BillItem item : items) {
            sum+= item.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        String result = "";
        for (BillItem item : items) {
            result += item.toString() + "\n";
        }
        result += "Total: " + getTotalPrice();
        return result;
    }

    public class BillItem {
        private double price;
        private CarComponent item;

        public double getPrice () {
            return price;
        }
        public CarComponent getItem () {
            return item;
        }
        public void setPrice (double price) {
            this.price = price;
        }
        public void setItem (CarComponent c) {
            this.item = c;
        }

        @Override
        public String toString () {
            String components = getComponentsString(item.getComponents());
            return item.getName() + components + ": " + price;
        }

        private String getComponentsString(CarComponent[] components) {
            String result = "";
            if (components != null && components.length > 0) {
                result = " (";
                for (CarComponent component : components) {
                    result += component.getName() + getComponentsString(component.getComponents()) + " ";
                }
                result += ") ";
            }
            return result;
        }
    }

}
