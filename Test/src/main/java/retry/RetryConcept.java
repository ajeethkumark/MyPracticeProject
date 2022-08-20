package retry;

import java.time.Duration;
import java.util.function.Supplier;

import javax.json.JsonObject;
import javax.ws.rs.core.Response;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;

public class RetryConcept {
	
	public static void main(String[] args) {
        String response;
            RetryConfig retryConfig = RetryConfig.<String>custom().waitDuration(Duration.ofMillis(100))
                    .maxAttempts(3).retryOnResult(r -> {
                    	//System.out.println("Test:"+true);
                        return r.contains("Hello");
                    }).build();
            RetryRegistry registry = RetryRegistry.of(retryConfig);
            Retry retry = registry.retry("Http client");
            retry.getEventPublisher().onRetry(e -> {
                System.out.println("Retrying:");
            });

            Supplier<String> retryableSupplier = Retry.decorateSupplier(retry,
                    () -> {
                    	RetryConcept retryConcept=new  RetryConcept();
                    	return retryConcept.makeit();
            		});
           System.out.println("Final Result"+ retryableSupplier.get());
            //System.out.println(response);
           
          

    }
public String makeit()
{
	Response r=null;
	return "Hello world";
}
	
}

/*
 * 
 *  CheckedFunction0<String> retryableSupplier = Retry.decorateCheckedSupplier(retry,
                    () -> {
                    	RetryConcept retryConcept=new  RetryConcept();
                    	retryConcept.makeit()
            		};
            		
            		*/
