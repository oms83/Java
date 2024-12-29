package Builder;

public class BuildComputerComponent {

    // product
    public static class Computer
    {
        public String CPU;
        public String GPU;
        public String HARD;
        public String RAM;

        public void setCPU(String CPU) {
            this.CPU = CPU;
        }
        public void setGPU(String GPU) {
            this.GPU = GPU;
        }
        public void setHard(String HARD) {
            this.HARD = HARD;
        }
        public void setRAM(String RAM) {
            this.RAM = RAM;
        }

        @Override
        public String toString() {
            return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", HARD=" + HARD + ", GPU=" + GPU + "]";
        }
    }

    // builder
    public static interface ComputerBuilder
    {
        public Computer buildComputer();
        public void buildCPU();
        public void buildGPU();
        public void buildHard();
        public void buildRAM();
    }

    // concrete builder
    public static class GammingComputerBuilder implements ComputerBuilder
    {
        private Computer computer;

        public GammingComputerBuilder() {
            computer = new Computer();
        }

        @Override
        public Computer buildComputer() {
            return computer;
        }

        @Override
        public void buildCPU() {
            computer.setCPU("Intel Core i9");
        }

        @Override
        public void buildGPU() {
            computer.setGPU("NVIDIA RTX 3080");
        }

        @Override
        public void buildHard() {
            computer.setHard("1TB SSD");
        }

        @Override
        public void buildRAM() {
            computer.setRAM("32GB");
        }
    }

    // Director
    public static class ComputerDirector
    {
        private ComputerBuilder computerBuilder;

        public ComputerDirector(ComputerBuilder computerBuilder) {
            this.computerBuilder = computerBuilder;
        }

        public Computer costructComputer() {
            computerBuilder.buildCPU();
            computerBuilder.buildGPU();
            computerBuilder.buildHard();
            computerBuilder.buildRAM();
            return computerBuilder.buildComputer();
        }
    }

    public static void main(String[] args) {
        ComputerBuilder computerBuilder = new GammingComputerBuilder();
        ComputerDirector computerDirector = new ComputerDirector(computerBuilder);
        Computer computer = computerDirector.costructComputer();
        System.out.println(computer.toString());
    }

}
