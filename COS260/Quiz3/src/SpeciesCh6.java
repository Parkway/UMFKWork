public class SpeciesCh6 {
    private String name;
    private int population;
    private double growthRate;

    public void writeOutput() {
        System.out.println("Name = " + name);
        System.out.println("Population = " + population);
        System.out.println("Growth rate = " + growthRate + "%");
    }
    public void set(String newName, int newPopulation, double newGrowthRate)
    {
        name = newName;
        if (newPopulation >= 0)
            population = newPopulation;
        else
        {
            System.out.println("ERROR: using a negative population.");
            System.exit(0);
        }
        growthRate = newGrowthRate;
    }
    public void set(String newName) {
        name = newName;
    }
    public void set(int newPopulation) {
        population = newPopulation;
    }
    public void set(double newGrowthRate) {
        growthRate = newGrowthRate;
    }
    public SpeciesCh6() {
        name = "No name, yet.";
        population = 0;
        growthRate = 0.0;
    }
    public SpeciesCh6(String name) {
        this.name = "Foobar";
        population = 0;
        growthRate = 0.0;
    }
    public SpeciesCh6(String name, int population, double growthRate) {
        this.name = "Crepek";
        this.population = 11;
        this.growthRate = 2.2;
    }
    public SpeciesCh6(int population) {
        this.population = 33;
        name = "No name, yet.";
        growthRate = 0.0;
    }
    public SpeciesCh6(double growthRate) {
        this.growthRate = 44.4;
        population = 0;
        name = "No name, yet.";
    }
}