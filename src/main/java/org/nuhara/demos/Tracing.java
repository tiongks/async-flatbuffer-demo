package org.nuhara.demos;

import io.jaegertracing.Configuration;
import io.jaegertracing.Configuration.ReporterConfiguration;
import io.jaegertracing.Configuration.SamplerConfiguration;
import io.jaegertracing.internal.samplers.ConstSampler;
import io.opentracing.Tracer;

public class Tracing {
	
	public static final String APP_NAME = "async-flatbuffer-demo";

	public static Tracer initTracer(String service) {
		if (null == service || service.isEmpty()) {
			service = APP_NAME;
		}
		SamplerConfiguration samplerConfiguration = SamplerConfiguration.fromEnv()
				.withType(ConstSampler.TYPE)
				.withParam(1);
		ReporterConfiguration reporterConfiguration = ReporterConfiguration.fromEnv()
				.withLogSpans(true);
		Configuration configuration = new Configuration(service)
				.withSampler(samplerConfiguration)
				.withReporter(reporterConfiguration);
		return configuration.getTracer();
	}
}
