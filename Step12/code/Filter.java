package refactoring; //change package name if desired
import com.jpaulmorrison.fbp.core.engine.*; 
@ComponentDescription("Filter") 
@InPorts({@InPort("IN"), @InPort("PARM")})
@OutPort("OUT")

public class Filter extends SubNet {
String description = "Filter";
protected void define() { 
  component("SUBIN",SubIn.class); 
  initialize("IN", component("SUBIN"), port("NAME")); 
  component("SUBIN_2_",SubIn.class); 
  initialize("PARM", component("SUBIN_2_"), port("NAME")); 
  component("filter_by___first__letter",com.jpaulmorrison.fbp.core.components.text.StartsWith.class); 
  component("ignore",com.jpaulmorrison.fbp.core.components.routing.Discard.class); 
  component("SUBOUT",SubOut.class); 
  initialize("OUT", component("SUBOUT"), port("NAME")); 
  connect(component("filter_by___first__letter"), port("ACC"), component("SUBOUT"), port("IN" )); 
  connect(component("SUBIN"), port("OUT"), component("filter_by___first__letter"), port("IN")); 
  connect(component("SUBIN_2_"), port("OUT"), component("filter_by___first__letter"), port("TEST")); 
  connect(component("filter_by___first__letter"), port("REJ"), component("ignore"), port("IN")); 
} 
}
