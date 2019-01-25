/*****************************************
 * Created by Lance Douglas on 1/25/2019
 *****************************************/
public class Test {
    public static void main(String[] args) {
        Thing num = new Thing();
        Widget wid = new Widget();
        num.countUp();
        wid.setName("Terry");

        System.out.println("Count: " + num.getCount());
        System.out.println("Name: " + wid.getName());
    }
}
