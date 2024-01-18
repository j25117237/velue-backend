package com.velue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
@ServletComponentScan
//@CrossOrigin(origins = "http://202.21.32.168:3000")
@EnableCaching
//@Import(CorsConfig.class)
//@CrossOrigin(origins = "*")
public class VelueApplication {

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(
      VelueApplication.class,
      args
    );

    //added
    // Get the names of all beans in the application context
    // String[] beanNames = context.getBeanDefinitionNames();

    // Print the list of bean names
    //System.out.println("List of all beans in the application context:");
    //Arrays.stream(beanNames).sorted().forEach(System.out::println);

  }

	/*
	 * @Bean public CacheManager cacheManager() {
	 * //System.out.println("=jagan in cache"); CaffeineCacheManager cacheManager =
	 * new CaffeineCacheManager(); cacheManager.setCaffeine(
	 * Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.HOURS).maximumSize(100) );
	 *
	 * return cacheManager; }
	 */
}
