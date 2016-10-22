/* This class is a supplement to CounterTest. It performs the functions called by setZero(), increment(),
    decrement(), printCounter(), and countIs() from CounterTest.java
    Lance Douglas, Counter, September 30, 2016
 */

class Counter { //PackageLocal, public unnecessary.
    private int zero; //Doesn't need to be public.
    void setZero() {
        zero = 0;
    } //Sets variable to zero.
    void increment() {
        zero++;
    } //Increments zero.
    void decrement() {
        if (zero > 0) { //Ensures that variable cannot become negative.
            zero--;
        } else {
            setZero();
        }
    }
    void printCounter() {
        System.out.println("Counter value = " + zero);
    }
    int countIs() {
        return zero;
    } //Returns value of zero variable.
}
