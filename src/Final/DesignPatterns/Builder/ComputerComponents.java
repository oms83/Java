package Final.DesignPatterns.Builder;

public class ComputerComponents {

    public static class Computer {
        public String Ram;
        public String Disk;
        public String Gpu;

        public void setDisk(String disk) {
            Disk = disk;
        }
        public void setRam(String ram) {
            Ram = ram;
        }
        public void setGpu(String gpu) {
            Gpu = gpu;
        }

        @Override
        public String toString() {
            return "Ram: " + Ram + ", Disk: " + Disk + ", Gpu: " + Gpu;
        }
    }
    public static interface ComputerBuilder {
        Computer buildComputer();
        ComputerBuilder buildRam(String ram);
        ComputerBuilder buildDisk(String disk);
        ComputerBuilder buildGpu(String gpu);
    }
    public static class BuildGamingComputer implements ComputerBuilder {
        private Computer computer;

        BuildGamingComputer() {
            computer = new Computer();
        }

        @Override
        public Computer buildComputer() {
            return computer;
        }

        @Override
        public ComputerBuilder buildGpu(String gpu) {
            computer.setGpu(gpu);
            return this;
        }

        @Override
        public ComputerBuilder buildDisk(String disk) {
            computer.setDisk(disk);
            return this;
        }

        @Override
        public ComputerBuilder buildRam(String ram) {
            computer.setRam(ram);
            return this;
        }
    }

    public static class ComputerDirector {
        ComputerBuilder builder;
        public ComputerDirector(ComputerBuilder builder) {
            this.builder = builder;
        }
        public Computer constructComputer() {
            return builder.buildDisk("1TB")
                    .buildGpu("Intel Core i9")
                    .buildRam("32GB")
                    .buildComputer();
        }
    }
    public static void main(String[] args) {
        BuildGamingComputer gamingComputer = new BuildGamingComputer();
        ComputerDirector computerDirector = new ComputerDirector(gamingComputer);
        Computer computer = computerDirector.constructComputer();
        System.out.println(computer);
    }
}
