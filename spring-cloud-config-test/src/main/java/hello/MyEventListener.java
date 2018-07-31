package hello;

import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;

@Component
public class MyEventListener {
	
	@EventListener
	public void handleEvent(Object event) {
	      System.out.println("event: "+event);
	}
	
	@EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
		System.out.println("Context Refresh Event: "+event);
    }
	
	
	@EventListener
    public void handleServletRequestHandledEvent(ServletRequestHandledEvent event) {
		System.out.println("************ServletRequestHandled Event: "+event);
    }
	
	@EventListener
    public void handleEnvironmentChangedEvent(EnvironmentChangeEvent event) {
		System.out.println("<<<<<<************EnvironmentChangedEvent Event: "+event);
    }

	
	@EventListener
    public void handleRefreshScopeRefreshedEvent(RefreshScopeRefreshedEvent event) {
		System.out.println("-------------<<<<<<************RefreshScopeRefreshedEvent Event: "+event);
    }
	
	
	

}
