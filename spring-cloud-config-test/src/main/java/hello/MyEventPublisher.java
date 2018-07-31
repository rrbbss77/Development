package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class MyEventPublisher  
{
	@Autowired
	private ApplicationEventPublisher publisher;

	public void refreshDBConfig() {
		System.out.println("Publishing custom event refresh me. ");
		this.publisher.publishEvent(new MyCustomEvent(this, "Refresh Me"));
	}

	
	
}
