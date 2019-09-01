package de.elbosso.microgenerator.handlers.string;

public class GUIDSequence extends Object implements io.javalin.http.Handler
{
	private final de.netsysit.util.generator.generalpurpose.GUIDSequence guidSequence=new de.netsysit.util.generator.generalpurpose.GUIDSequence();

	public static void register(io.javalin.Javalin app)
	{
		GUIDSequence handler=new GUIDSequence();
		app.get("/guidSequence/", handler);
	}

	public GUIDSequence()
	{
		super();
//		guidSequence.setAllowsNull(false);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private String generate(io.javalin.http.Context ctx)
	{
		return guidSequence.next();
	}
}
