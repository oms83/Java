package Factory;

public class OperatingSystemsAbstractFactory {

    // abstract factory
    public static interface IUserInterface
    {
        IButton getButton();
        IWindow getWindow();
    }

    // abstract product
    public static interface IButton
    {
        void show();
    }

    // abstract product
    public static interface IWindow
    {
        void show();
    }

    // concrete product
    public static class WindowsWindow implements IWindow
    {
        @Override
        public void show() {
            System.out.println("WindowsWindow");
        }
    }

    // concrete product
    public static class LinuxWindow implements IWindow
    {
        @Override
        public void show() {
            System.out.println("LinuxWindow");
        }
    }

    // concrete product
    public static class MacWindow implements IWindow
    {
        @Override
        public void show() {
            System.out.println("MacWindow");
        }
    }

    // concrete product
    public static class WindowsButton implements IButton
    {
        @Override
        public void show() {
            System.out.println("WindowsButton");
        }
    }

    // concrete product
    public static class LinuxButton implements IButton
    {
        @Override
        public void show() {
            System.out.println("LinuxButton");
        }
    }

    // concrete product
    public static class MacButton implements IButton
    {
        @Override
        public void show() {
            System.out.println("MacButton");
        }
    }

    // concrete factory
    public class WindowsFactory implements IUserInterface
    {
        @Override
        public IWindow getWindow() {
            return new WindowsWindow();
        }

        @Override
        public IButton getButton() {
            return new WindowsButton();
        }
    }

    // concrete factory
    public static class MacFactory implements IUserInterface
    {
        @Override
        public IWindow getWindow() {
            return new MacWindow();
        }

        @Override
        public IButton getButton() {
            return new MacButton();
        }
    }

    public static class LinuxFactory implements IUserInterface
    {
        @Override
        public IButton getButton() {
            return new LinuxButton();
        }

        @Override
        public IWindow getWindow() {
            return new LinuxWindow();
        }
    }

    public static void main(String[] args) {
        IUserInterface ui = new LinuxFactory();
        IButton button = ui.getButton();
        IWindow window = ui.getWindow();
        button.show();
        window.show();

        System.out.println("\n--------------------------------------\n");

        ui = new MacFactory();
        button = ui.getButton();
        window = ui.getWindow();
        button.show();
        window.show();
    }
}
