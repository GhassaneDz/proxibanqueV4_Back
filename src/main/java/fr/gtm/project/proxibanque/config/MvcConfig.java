package fr.gtm.project.proxibanque.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SuppressWarnings("deprecation")
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "fr.gtm.project.proxibanque.web", "fr.gtm.project.proxibanque.business" })
@EnableJpaRepositories(basePackages = { "fr.gtm.project.proxibanque.dao" })
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(final CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*").allowCredentials(true)
				.maxAge(3600);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setPersistenceUnitName("proxibanque");
		return lcemfb;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		final PlatformTransactionManager tm = new JpaTransactionManager(this.entityManagerFactory().getObject());
		return tm;
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		final InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		vr.setViewClass(JstlView.class);
		return vr;
	}
}
