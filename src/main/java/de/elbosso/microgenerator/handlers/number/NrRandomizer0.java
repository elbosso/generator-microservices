package de.elbosso.microgenerator.handlers.number;

public class NrRandomizer0 extends Object implements io.javalin.http.Handler
{
	private final de.netsysit.util.generator.generalpurpose.NrRandomizer0 nrRandomizer0=new de.netsysit.util.generator.generalpurpose.NrRandomizer0();

	public static void register(io.javalin.Javalin app)
	{
		NrRandomizer0 handler=new NrRandomizer0();
		app.get("/nrRandomizer0/", handler);
		app.get("/nrRandomizer0/:lambda", handler);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private Number generate(io.javalin.http.Context ctx)
	{
		return nrRandomizer0.next();
	}
}
