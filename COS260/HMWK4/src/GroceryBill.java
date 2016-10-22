public class GroceryBill {

    public static void main(String[] args){

        double totalCost = 0;
        Purchase item = new Purchase(); //Calls Purchase.java and assigns methods to variable item? Take note: item is henceforth "purchaseVariableName"

        item.setName("Oranges"); //Makes name of item Oranges
        item.setPrice(10, 2.99); // 10 oranges for $2.99
        item.setNumberBought(24); // I bought 24 oranges
        item.writeOutput(); //Calls writeOutput method via purchaseVariableName.MethodName();
        System.out.println("Subtotal: " + item.getTotalCost()); //Outputs "Subtotal: cost of all oranges
        totalCost = totalCost + item.getTotalCost(); //Reassigns totalcost to add the cost of the oranges. It was zero.

        item.setName("Eggs");
        item.setPrice(12, 1.69);
        item.setNumberBought(36);
        item.writeOutput();
        System.out.println("Subtotal: " + item.getTotalCost());
        totalCost = totalCost + item.getTotalCost();

        item.setName("Apples");
        item.setPrice(3, 1.00);
        item.setNumberBought(20);
        item.writeOutput();
        System.out.println("Subtotal: " + item.getTotalCost());
        totalCost = totalCost + item.getTotalCost();

        item.setName("Watermelons");
        item.setPrice(1, 4.39);
        item.setNumberBought(2);
        item.writeOutput();
        System.out.println("Subtotal: " + item.getTotalCost());
        totalCost = totalCost + item.getTotalCost();

        item.setName("Bagels");
        item.setPrice(6, 3.50);
        item.setNumberBought(12);
        item.writeOutput();
        System.out.println("Subtotal: " + item.getTotalCost());
        item.getUnitCost();
        item.getNumberBought();
        totalCost = totalCost + item.getTotalCost();

        System.out.println("Total: " + totalCost);
    }

}