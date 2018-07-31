package hello;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import io.swagger.annotations.ApiModelProperty;

@RefreshScope
@Component
@ConfigurationProperties(prefix="app")
@JsonAutoDetect
public class AppProp {
	
	private String name;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String prop1) {
		this.name = prop1;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
