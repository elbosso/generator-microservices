package de.elbosso.microgenerator.handlers.number;

import io.javalin.plugin.openapi.annotations.OpenApi;
import io.javalin.plugin.openapi.annotations.OpenApiContent;
import io.javalin.plugin.openapi.annotations.OpenApiParam;
import io.javalin.plugin.openapi.annotations.OpenApiResponse;

public class GaussianRandomBoxMuller extends java.lang.Object implements io.javalin.http.Handler
{
	private final de.elbosso.util.generator.generalpurpose.GaussianRandomBoxMuller gaussianRandomBoxMuller=new de.elbosso.util.generator.generalpurpose.GaussianRandomBoxMuller();

	public static void register(io.javalin.Javalin app)
	{
		GaussianRandomBoxMuller handler=new GaussianRandomBoxMuller();
		app.get("/gaussianRandomBoxMuller/", handler);
		app.get("/gaussianRandomBoxMuller/:mean/:variance", handler);
	}

	@Override
/*	@OpenApi(
			operationId = "getGaussianrandomboxmullerWithMeanWithVariance",
			pathParams = {
					@OpenApiParam(name = "mean", description = "mean",type = Number.class, required = false),
					@OpenApiParam(name = "variance", description = "variance", type = Number.class, required = false)
			},
			responses = {
					@OpenApiResponse(status = "200", content = @OpenApiContent(from = double.class)),
					@OpenApiResponse(status = "204") // No content
			}
	)
*/	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private Number generate(io.javalin.http.Context ctx)
	{
		double mean=0.0;
		double variance=1.0;
		try
		{
			mean=ctx.pathParam("mean",java.lang.Double.class).getValue().doubleValue();
		}
		catch(java.lang.Throwable t)
		{
			mean=0.0;
		}
		try
		{
			variance=ctx.pathParam("variance",java.lang.Double.class).getValue().doubleValue();
		}
		catch(java.lang.Throwable t)
		{
			variance=1.0;
		}
		gaussianRandomBoxMuller.setMean(mean);
		gaussianRandomBoxMuller.setVariance(variance);
		return gaussianRandomBoxMuller.next();
	}
}
