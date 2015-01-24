package net.madsn.frameworktesting;

import net.madsn.frameworktesting.config.*;


import net.madsn.frameworktesting.resources.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.base.Optional;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShuffleService extends Application<ShuffleConfiguration> {
    private static final Logger LOG = LoggerFactory.getLogger(ShuffleService.class);

    public static void main(String[] args) throws Exception {
        new ShuffleService().run(args);
    }

    private final HibernateBundle<ShuffleConfiguration> hibernateBundle = new HibernateBundle<ShuffleConfiguration>(
            
            Void.class
        ) {
        @Override
        public DataSourceFactory getDataSourceFactory(ShuffleConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public String getName() {
        return "shuffle";
    }

    @Override
    public void initialize(Bootstrap<ShuffleConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets/app/", "/", "index.html"));
        bootstrap.addBundle(hibernateBundle);
        ObjectMapper mapper = bootstrap.getObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Override
    public void run(ShuffleConfiguration configuration,
                    Environment environment) throws Exception {
        environment.jersey().setUrlPattern("/shuffle/*");
        
        environment.jersey().register(new MemberResource());
        
    }
}
