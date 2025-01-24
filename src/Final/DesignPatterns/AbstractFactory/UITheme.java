package Final.DesignPatterns.AbstractFactory;

public class UITheme {

    // products
    public static interface Button {
        void render();
    }
    public static interface Label {
        void render();
    }
    public static interface Dialog {
        void render();
    }
    // abstract factory
    public static interface UI {
        Button getButton();
        Label getLabel();
        Dialog getDialog();
    }
    // concrete product
    public static class LightButton implements Button {
        public void render() {
            System.out.println("LightButton");
        }
    }
    public static class DarkButton implements Button {
        public void render() {
            System.out.println("DarkButton");
        }
    }
    public static class LightLabel implements Label {
        public void render() {
            System.out.println("LightLabel");
        }
    }
    public static class DarkLabel implements Label {
        public void render() {
            System.out.println("DarkLabel");
        }
    }
    public static class LightDialog implements Dialog {
        public void render() {
            System.out.println("LightDialog");
        }
    }
    public static class DarkDialog implements Dialog {
        public void render() {
            System.out.println("DarkDialog");
        }
    }
    // concrete factory
    public static class DarkMode implements UI {

        @Override
        public Button getButton() {
            return new DarkButton();
        }

        @Override
        public Label getLabel() {
            return new DarkLabel();
        }

        @Override
        public Dialog getDialog() {
            return new DarkDialog();
        }
    }

    public static void main(String[] args) {
        DarkMode darkMode = new DarkMode();
        Button button = darkMode.getButton();
        Label label = darkMode.getLabel();
        Dialog dialog = darkMode.getDialog();

        button.render();
        label.render();
        dialog.render();
    }
}
