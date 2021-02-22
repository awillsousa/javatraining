package br.mp.mpf.cursowebservice.cursowebservice.configuration;

import br.mp.mpf.cursowebservice.cursowebservice.utils.RequestResponseLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestTemplateConfiguration {

	@Bean
	public RestTemplate createRestTemplate() {

		ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new RequestResponseLoggingInterceptor());

		RestTemplate restTemplate =  new RestTemplate();
		restTemplate.setInterceptors(interceptors);

		return restTemplate;
	}
}
