package examples.mycompany.com;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.core.osgi.OsgiDefaultCamelContext;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component
public class Activator {
	
	@Activate
	public void activate(BundleContext bundleContext) throws Exception {
		//Create an OSGI Camel Context
		CamelContext cc = new OsgiDefaultCamelContext(bundleContext);
		
		//Add some routes via an anonymous route builder
		cc.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				from("timer")
				.log("Log got a new message ${id}");
			}
			
		});
		
		//start the routes
		cc.start();
		
		
	}
}
