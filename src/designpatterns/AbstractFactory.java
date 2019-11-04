package designpatterns;

import java.util.List;
import java.util.Random;

// an existing hierarchy
interface Button {
    void paint();
}
class WinButton implements Button {
    @Override
    public void paint() {
        System.out.println("WinButton");
    }
}
class OSXButton implements Button {
    @Override
    public void paint() {
        System.out.println("OSXButton");
    }
}

public class AbstractFactory {
    // abstract the way to create a button
    @FunctionalInterface
    interface GUIFactory {
        public Button createButton();
    }
  
    private static GUIFactory factory(String appearance) {
        switch(appearance) {
            case "osx":
                return OSXButton::new;
            case "win":
                return WinButton::new;
            default:
                throw new IllegalArgumentException("unknown " + appearance);
       }
    }
 
    public static void main(final String[] arguments) {
      // This is just for the sake of testing this program,
      // and doesn't have to do with the Abstract Factory pattern.
      //var randomAppearance = List of("osx", "win").get(new Random().nextInt(2));
      
      // get the button factory for an appearance
      GUIFactory factory = factory("osx");
      
      // use the factory to create the button
      Button button = factory.createButton();
      button.paint();
    }
}