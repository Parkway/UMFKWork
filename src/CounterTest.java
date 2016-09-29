/**

 File name: CounterTest.java

 This program does the following:
 Creates an instance of the class "Counter" to test the
 various methods:
 1.  Sets the counter to zero using method setZero().
 2.  Increments the counter using increment() then
 prints out its value twice,
 once using printCounter(),
 and again using countIs(), in a loop that repeats 10 times.
 3.  Similarly, decrements the counter using decrement()
 then prints out its value each time through a
 loop that repeats 11 times (to make sure
 it cannot go below zero).

 Note:
 code has been put into both loops to stop the program so you
 can see the result of each iteration.


 */

public class CounterTest
{
    public static void main(String[] args)
    {
        Counter testCounter = new Counter();

        testCounter.setZero();
        System.out.println("After setZero() testCounter = "
                + testCounter.countIs());

        int i;
        String junk;
        for(i = 0; i < 5; i++)
        {
            System.out.println("Loop count = " + i);
            testCounter.increment();
            System.out.println("After increment() in loop "
                    + "using printCounter(): ");
            testCounter.printCounter();
            System.out.println("Using countIs() to return value: "
                    + testCounter.countIs());
        }

        for(i = 0; i < 6; i++)
        {
            System.out.println("Loop count = " + i);
            testCounter.decrement();
            System.out.println("After decrement() in loop "
                    + "using printCounter(): ");
            testCounter.printCounter();
            System.out.println("Using countIs() to return value: "
                    + testCounter.countIs());
        }
    }
}