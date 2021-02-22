package br.mp.mpf.cursowebservice.cursowebservice;

import br.mp.mpf.cursowebservice.cursowebservice.model.Categoria;
import br.mp.mpf.cursowebservice.cursowebservice.model.dto.CategoriaDTO;
import br.mp.mpf.cursowebservice.cursowebservice.model.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class CursowebserviceApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursowebserviceApplication.class, args);
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public LocalValidatorFactoryBean getValidator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria = Categoria.builder()
				.nome("Escritório")
				.build();

		Categoria categoria2 = Categoria.builder()
				.nome("Papelaria")
				.build();

		this.categoriaRepository.saveAll(Arrays.asList(categoria, categoria2));
	}
}
