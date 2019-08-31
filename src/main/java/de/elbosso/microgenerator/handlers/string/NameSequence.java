package de.elbosso.microgenerator.handlers.string;

public class NameSequence extends Object implements io.javalin.http.Handler
{
	private final de.elbosso.util.generator.semantics.NameSequence nameSequence=new de.elbosso.util.generator.semantics.NameSequence();

	public static void register(io.javalin.Javalin app)
	{
		NameSequence handler=new NameSequence();
		app.get("/nameSequence/", handler);
	}

	public NameSequence()
	{
		super();
		nameSequence.setAllowsNull(false);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private String generate(io.javalin.http.Context ctx)
	{
		return nameSequence.next();
	}
}
