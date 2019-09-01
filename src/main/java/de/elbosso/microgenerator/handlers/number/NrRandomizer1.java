package de.elbosso.microgenerator.handlers.number;

public class NrRandomizer1 extends Object implements io.javalin.http.Handler
{
	private final de.netsysit.util.generator.generalpurpose.NrRandomizer1 nrRandomizer1=new de.netsysit.util.generator.generalpurpose.NrRandomizer1();

	public static void register(io.javalin.Javalin app)
	{
		NrRandomizer1 handler=new NrRandomizer1();
		app.get("/nrRandomizer1/", handler);
		app.get("/nrRandomizer1/:lambda", handler);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private Number generate(io.javalin.http.Context ctx)
	{
		return nrRandomizer1.next();
	}
}
