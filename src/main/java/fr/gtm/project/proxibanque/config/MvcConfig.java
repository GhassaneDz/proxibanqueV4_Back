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

/**
 * MvcConfig paramètre Spring. Il paramètre - le Cors qui permet l'échange entre
 * le back/front au niveau des requètes. - le managerFactoryBean - la gestion
 * des transactions - le view resolver permettant à JASPER (tomCat) de traduire
 * une .jsp en .html
 *
 * @author Kamir Elsisi, Steven Roman, Antoine Volatron
 *
 */
@SuppressWarnings("deprecation")
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "fr.gtm.project.proxibanque.web", "fr.gtm.project.proxibanque.business" })
@EnableJpaRepositories(basePackages = { "fr.gtm.project.proxibanque.dao" })
public class MvcConfig extends WebMvcConfigurerAdapter {
	private static final Integer MAXAGE = 3600;

	/**
	 * addCorsMappings permet de d'accepter des requètes provenant du front
	 * (angular) vers le back (JEE).
	 *
	 **/
	@Override
	public void addCorsMappings(final CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*").allowCredentials(true)
				.maxAge(MvcConfig.MAXAGE);
	}

	/**
	 * LocalContainerEntityManagerFactoryBean parametre le container de bean à
	 * partir de la persistence.
	 *
	 * @return lcemfb le container de bean
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setPersistenceUnitName("proxibanque");
		return lcemfb;
	}

	/**
	 * PlatformTransactionManager gère les transaction avec la base de donnée
	 *
	 * @return la plate forme de transaction manager
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(this.entityManagerFactory().getObject());
	}

	/**
	 * InternalResourceViewResolver permet de paramétrer les pages JSP lors de
	 * l'appel des controlleurs.
	 *
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		final InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		vr.setViewClass(JstlView.class);
		return vr;
	}
}
