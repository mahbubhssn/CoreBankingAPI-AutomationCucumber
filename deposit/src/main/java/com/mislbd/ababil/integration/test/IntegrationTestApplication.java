package com.mislbd.ababil.integration.test;

import com.mislbd.ababil.integration.test.inmemorydb.model.Data;
import com.mislbd.ababil.integration.test.inmemorydb.repository.DataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.web.client.RestTemplate;

@Order
@SpringBootApplication
public class IntegrationTestApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(IntegrationTestApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	private Logger LOG = LoggerFactory.getLogger("IntegrationTestApplication");
	private String contentValueVar;
	private String jsonBodyVar;

	public void data(String contentValue, String jsonBody){
	    contentValueVar = contentValue;
		jsonBodyVar = jsonBody;
	}

	@Autowired
    private final DataRepository dataRepository;

	@Autowired
    public IntegrationTestApplication(DataRepository dataRepository){
	    this.dataRepository = dataRepository;
	}

	public void run(String... args) throws Exception{

	    Data data = new Data(contentValueVar,jsonBodyVar);

	    LOG.info("Inserting data in DB");
	    Data response = dataRepository.save(data);

	    LOG.info("Response: {}", response.getId());
	    LOG.info("Data: {}", dataRepository.findById(response.getId()));

	    LOG.info("Data count in DB: {}", dataRepository.count());
	    LOG.info("Data List: {}", dataRepository.findAll());
	}
}
