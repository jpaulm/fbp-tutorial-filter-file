package refactoring; //change package name if desired
import com.jpaulmorrison.fbp.core.engine.*; 
public class Step5 extends Network {
String description = "Components filled in";
protected void define() { 
  component("read__sample__file",com.jpaulmorrison.fbp.core.components.io.ReadFile.class); 
  component("filter_by__first_letter",com.jpaulmorrison.fbp.core.components.text.StartsWith.class); 
  component("Ignore",com.jpaulmorrison.fbp.core.components.routing.Discard.class); 
  component("display__accepted__lines",com.jpaulmorrison.fbp.core.components.swing.ShowText.class); 
  connect(component("filter_by__first_letter"), port("REJ"), component("Ignore"), port("IN")); 
  connect(component("read__sample__file"), port("OUT"), component("filter_by__first_letter"), port("IN")); 
  initialize("C:/Users/bobco/drawfbp/txt-nonexist.csv", component("read__sample__file"), port("SOURCE")); 
  initialize("J", component("filter_by__first_letter"), port("TEST")); 
  initialize("Accepted entries", component("display__accepted__lines"), port("TITLE")); 
  connect(component("filter_by__first_letter"), port("ACC"), component("display__accepted__lines"), port("IN")); 
} 
public static void main(String[] argv) throws Exception  { 
  new Step5().go(); 
} 
}
