package blog;

import java.beans.PropertyVetoException;
import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
public class Application extends RepositoryRestMvcConfiguration  {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
//		BlogRepository blogRepo = context.getBean(BlogRepository.class);
	}
	
	@Override
	protected void configureRepositoryRestConfiguration(
			RepositoryRestConfiguration config) {
		config.exposeIdsFor(Blog.class);
	}
	
	@Bean(name = { "dataSource" }, destroyMethod = "close")
	protected DataSource dataSource() throws PropertyVetoException {
		final HikariDataSource dataSource = new HikariDataSource();
		dataSource.setDriverClassName(applicationContext.getEnvironment()
				.getProperty("javax.persistence.jdbc.driver"));
		dataSource.setJdbcUrl(applicationContext.getEnvironment().getProperty(
				"javax.persistence.jdbc.url"));
		dataSource.setUsername(applicationContext.getEnvironment().getProperty(
				"javax.persistence.jdbc.user"));
		dataSource.setPassword(applicationContext.getEnvironment().getProperty(
				"javax.persistence.jdbc.password"));

		return dataSource;
	}

	@Bean(name = { "jpaVendorAdapter" })
	protected JpaVendorAdapter defaultJpaVendorAdapter() {
		final HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(false);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter
				.setDatabasePlatform(org.hibernate.dialect.MySQL5Dialect.class
						.getCanonicalName());

		return hibernateJpaVendorAdapter;
	}

	@Bean(name = { "entityManagerFactory" })
	protected EntityManagerFactory entityManagerFactory(DataSource dataSource,
			Environment env) throws PropertyVetoException, IOException {
		final LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource);
		entityManagerFactory.setJpaVendorAdapter(defaultJpaVendorAdapter());
		entityManagerFactory.setJpaDialect(new HibernateJpaDialect());
		entityManagerFactory
				.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		entityManagerFactory
				.setPersistenceProviderClass(org.hibernate.jpa.HibernatePersistenceProvider.class);

		entityManagerFactory.afterPropertiesSet();

		return entityManagerFactory.getObject();
	}
	
	
}
