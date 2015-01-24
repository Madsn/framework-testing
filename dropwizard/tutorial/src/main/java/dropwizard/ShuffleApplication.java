package dropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ShuffleApplication extends Application<ShuffleConfiguration> {
	
	public static void main(String[] args) throws Exception {
        new ShuffleApplication().run(args);
    }

	@Override
	public void initialize(Bootstrap<ShuffleConfiguration> arg0) {
		
	}

	@Override
	public void run(ShuffleConfiguration configuration, Environment environment)
			throws Exception {
		final MemberResource resource = new MemberResource();
	    environment.jersey().register(resource);
	}

}
