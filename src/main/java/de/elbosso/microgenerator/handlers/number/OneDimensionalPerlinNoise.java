package de.elbosso.microgenerator.handlers.number;

public class OneDimensionalPerlinNoise extends Object implements io.javalin.http.Handler
{
	private final de.elbosso.util.generator.generalpurpose.OneDimensionalPerlinNoise oneDimensionalPerlinNoise=new de.elbosso.util.generator.generalpurpose.OneDimensionalPerlinNoise();

	public static void register(io.javalin.Javalin app)
	{
		OneDimensionalPerlinNoise handler=new OneDimensionalPerlinNoise();
		app.get("/oneDimensionalPerlinNoise/", handler);
		app.get("/oneDimensionalPerlinNoise/:min/:max/:frequency", handler);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private Number generate(io.javalin.http.Context ctx)
	{
		double frequency=1.0;
		double min=-1.0;
		double max=1.0;
		try
		{
			frequency=ctx.pathParam("frequency", Double.class).getValue().doubleValue();
		}
		catch(Throwable t)
		{
			frequency=1.0;
		}
		try
		{
			min=ctx.pathParam("min", Double.class).getValue().doubleValue();
		}
		catch(Throwable t)
		{
			min=-1.0;
		}
		try
		{
			max=ctx.pathParam("max", Double.class).getValue().doubleValue();
		}
		catch(Throwable t)
		{
			max=1.0;
		}
		oneDimensionalPerlinNoise.setFrequency(frequency);
		oneDimensionalPerlinNoise.setMiniMax(new de.netsysit.util.lang.MiniMax(min,max));
		return oneDimensionalPerlinNoise.next();
	}
}
