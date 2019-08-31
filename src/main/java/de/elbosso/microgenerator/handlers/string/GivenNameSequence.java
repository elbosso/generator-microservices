package de.elbosso.microgenerator.handlers.string;

public class GivenNameSequence extends Object implements io.javalin.http.Handler
{
	private final de.elbosso.util.generator.semantics.GivenNameSequence givenNameSequence=new de.elbosso.util.generator.semantics.GivenNameSequence();

	public static void register(io.javalin.Javalin app)
	{
		GivenNameSequence handler=new GivenNameSequence();
		app.get("/givenNameSequence/", handler);
	}

	public GivenNameSequence()
	{
		super();
		givenNameSequence.setAllowsNull(false);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private String generate(io.javalin.http.Context ctx)
	{
		return givenNameSequence.next();
	}
}
