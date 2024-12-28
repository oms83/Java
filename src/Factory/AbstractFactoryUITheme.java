package Factory;

public class AbstractFactoryUITheme {

    // Abstract Factory
    public static interface IUIThemeFactory {
        Button CreateButton(); // used
        Label CreateLabel(); // used
        TextBox CreateTextBox(); // used
    }
    // Product1
    public static interface Button
    {
        void render();
    }
    // Product2
    public static interface Label
    {
        void render();
    }
    // Product3
    public static interface TextBox
    {
        void render();
    }

    // Concrete Product
    public static class LightTextBox implements TextBox
    {
        @Override
        public void render() {
            System.out.println("LightTextBox");
        }
    }
    // Concrete Product
    public static class DarkTextBox implements TextBox
    {
        @Override
        public void render() {
            System.out.println("DarkTextBox");
        }
    }
    // Concrete Product
    public static class DarkButton implements Button
    {
        @Override
        public void render() {
            System.out.println("DarkButton");
        }
    }
    // Concrete Product
    public static class LightButton implements Button
    {
        @Override
        public void render() {
            System.out.println("LightButton");
        }
    }
    // Concrete Product
    public static class LightLabel implements Label
    {
        @Override
        public void render() {
            System.out.println("LightLabel");
        }
    }
    // Concrete Product
    public static class DarkLabel implements Label
    {
        @Override
        public void render() {
            System.out.println("DarkLabel");
        }
    }

    // Concrete Factories
    public static class DarkThemeFactory implements IUIThemeFactory
    {
        @Override
        public Button CreateButton() {
            return new DarkButton();
        }

        @Override
        public Label CreateLabel() {
            return  new DarkLabel();
        }

        @Override
        public TextBox CreateTextBox() {
            return new DarkTextBox();
        }
    }

    public static class LightThemeFactory implements IUIThemeFactory
    {
        @Override
        public TextBox CreateTextBox() {
            return new LightTextBox();
        }

        @Override
        public Label CreateLabel() {
            return new LightLabel();
        }

        @Override
        public Button CreateButton() {
            return new LightButton();
        }
    }

    public static void main(String[] args) {
        DarkThemeFactory dtf = new DarkThemeFactory();
        Button darkButton = dtf.CreateButton();
        TextBox darkTextBox = dtf.CreateTextBox();
        Label darkLabel = dtf.CreateLabel();
        darkButton.render();
        darkLabel.render();
        darkTextBox.render();
    }
}
/*
                  uiTheme        <--     button    <--    text
                    |                       |               |
       (buttonFactory, textFactory) --> (Light/Dark)(button, text)
*/
