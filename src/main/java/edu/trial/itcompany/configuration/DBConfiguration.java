package edu.trial.itcompany.configuration;

import edu.trial.itcompany.DB.repository.AnimalRepository;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories("edu.trial.itcompany.DB")
public class DBConfiguration {
    @Bean
    public DataSource dataSource ( ) {

        PGSimpleDataSource ds = new PGSimpleDataSource ( );
        ds.setServerNames ( new String[]{"localhost"} );
        ds.setDatabaseName ( "netcracker" );
        ds.setUser ( "postgres" );
        ds.setPassword ( "rainbow7" );
        return ds;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory ( ) {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter ( );
        vendorAdapter.setGenerateDdl ( true );
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean ( );
        factory.setJpaVendorAdapter ( vendorAdapter );
        factory.setPackagesToScan ( "edu.trial.itcompany.DB" );
        factory.setDataSource ( dataSource ( ) );
        factory.afterPropertiesSet ( );
        return factory.getObject ( );
    }


    @Bean
    CommandLineRunner initDatabase ( AnimalRepository repository ) {

        return args -> {
            System.err.println ( repository.findAll ( ) );
        };
    }
}

