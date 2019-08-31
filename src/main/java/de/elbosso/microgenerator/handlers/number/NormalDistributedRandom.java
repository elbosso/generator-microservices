package de.elbosso.microgenerator.handlers.number;

public class NormalDistributedRandom extends Object implements io.javalin.http.Handler
{
	private final de.elbosso.util.generator.generalpurpose.NormalDistributedRandom normalDistributedRandom=new de.elbosso.util.generator.generalpurpose.NormalDistributedRandom();

	public static void register(io.javalin.Javalin app)
	{
		NormalDistributedRandom handler=new NormalDistributedRandom();
		app.get("/normalDistributedRandom/", handler);
		app.get("/normalDistributedRandom/:mue/:wantedSigma", handler);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private Number generate(io.javalin.http.Context ctx)
	{
		double mue=0.0;
		double wantedSigma=0.5;
		try
		{
			mue=ctx.pathParam("mue", Double.class).getValue().doubleValue();
		}
		catch(Throwable t)
		{
			mue=0.0;
		}
		try
		{
			wantedSigma=ctx.pathParam("wantedSigma", Double.class).getValue().doubleValue();
		}
		catch(Throwable t)
		{
			wantedSigma=0.5;
		}
		normalDistributedRandom.setMue(mue);
		normalDistributedRandom.setWantedSigma(wantedSigma);
		return normalDistributedRandom.next();
	}
}
