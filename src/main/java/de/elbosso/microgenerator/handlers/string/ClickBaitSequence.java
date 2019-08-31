package de.elbosso.microgenerator.handlers.string;

public class ClickBaitSequence extends Object implements io.javalin.http.Handler
{
	private final de.elbosso.util.generator.semantics.ClickBaitSequence clickBaitSequence=new de.elbosso.util.generator.semantics.ClickBaitSequence();

	public static void register(io.javalin.Javalin app)
	{
		ClickBaitSequence handler=new ClickBaitSequence();
		app.get("/clickBaitSequence/", handler);
	}

	public ClickBaitSequence()
	{
		super();
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private String generate(io.javalin.http.Context ctx)
	{
		return clickBaitSequence.next();
	}
}
