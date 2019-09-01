package de.elbosso.microgenerator.handlers.number;

public class NrRandomizer2 extends Object implements io.javalin.http.Handler
{
	private final de.netsysit.util.generator.generalpurpose.NrRandomizer2 nrRandomizer2=new de.netsysit.util.generator.generalpurpose.NrRandomizer2();

	public static void register(io.javalin.Javalin app)
	{
		NrRandomizer2 handler=new NrRandomizer2();
		app.get("/nrRandomizer2/", handler);
		app.get("/nrRandomizer2/:lambda", handler);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private Number generate(io.javalin.http.Context ctx)
	{
		return nrRandomizer2.next();
	}
}
