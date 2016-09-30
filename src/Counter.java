class Counter {
    private int zero;
    void setZero() {
        zero = 0;
    }
    void increment() {
        zero++;
    }
    void decrement() {
        if (zero > 0) {
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
    }
}
