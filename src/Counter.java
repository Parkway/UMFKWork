class Counter {
    public int zero;
    public String printCount;

    void setZero() {
        zero = 0;
    }

    void increment() {
        zero++;
    }

    void decrement() {
        zero--;
    }

    void printCounter() {
        System.out.println(zero);
    }
    public int countIs() {
        return zero;
    }
}
