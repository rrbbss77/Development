package hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Model;

@RefreshScope
@RestController
@RequestMapping("/product")
@Api(value="MY Product API")
public class AppController {

    @Autowired
    private AppProp appProp;
    
    @Value("${app.name}")
    private String appName;
    
    @Autowired
    private MyEventPublisher pub;

    
    @RequestMapping(value = "/config", method= RequestMethod.GET)
    public String config() {
    	
    	return "Current Config Value::: " + appProp.getName() + 
    			"</br> Current Address:: " + appProp.getAddress() + 
    			"</br> Direct value name:: " + this.appName;
    }
    
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved properties"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @ApiOperation(value = "Show APP Properties",response = AppProp.class)
    @RequestMapping(value = "/showProp", method= RequestMethod.GET, produces = "application/json")
    public MyProp showAppProp(){
    	
    	//publish a custom event
    	this.pub.refreshDBConfig();
    	
    	
      return new MyProp(this.appProp);
    }
    
    
}
