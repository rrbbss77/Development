package hello;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyCustomEventListener implements ApplicationListener<MyCustomEvent> {
	@Override
	public void onApplicationEvent(MyCustomEvent event) {
		System.out.println("************************************************Received spring custom event - " + event.getMessage());
	}
}
