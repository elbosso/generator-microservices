package de.elbosso.microgenerator.handlers.number;

public class PoissonDistributedRandom extends Object implements io.javalin.http.Handler
{
	private final de.elbosso.util.generator.generalpurpose.PoissonDistributedRandom poissonDistributedRandom=new de.elbosso.util.generator.generalpurpose.PoissonDistributedRandom();

	public static void register(io.javalin.Javalin app)
	{
		PoissonDistributedRandom handler=new PoissonDistributedRandom();
		app.get("/poissonDistributedRandom/", handler);
		app.get("/poissonDistributedRandom/:lambda", handler);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private Number generate(io.javalin.http.Context ctx)
	{
		int lambda=4;
		try
		{
			lambda=ctx.pathParam("lambda", Integer.class).getValue().intValue();
		}
		catch(Throwable t)
		{
			lambda=4;
		}
		poissonDistributedRandom.setLambda(lambda);
		return poissonDistributedRandom.next();
	}
}
