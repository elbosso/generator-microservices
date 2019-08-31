package de.elbosso.microgenerator.handlers.string;

public class SurNameSequence extends Object implements io.javalin.http.Handler
{
	private final de.elbosso.util.generator.semantics.SurNameSequence surNameSequence=new de.elbosso.util.generator.semantics.SurNameSequence();

	public static void register(io.javalin.Javalin app)
	{
		SurNameSequence handler=new SurNameSequence();
		app.get("/surNameSequence/", handler);
	}

	public SurNameSequence()
	{
		super();
		surNameSequence.setAllowsNull(false);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private String generate(io.javalin.http.Context ctx)
	{
		return surNameSequence.next();
	}
}
