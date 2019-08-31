package de.elbosso.microgenerator.handlers.string;

public class LoremIpsumWordSequence extends Object implements io.javalin.http.Handler
{
	private final de.elbosso.util.generator.generalpurpose.LoremIpsumWordSequence loremIpsumWordSequence=new de.elbosso.util.generator.generalpurpose.LoremIpsumWordSequence();

	public static void register(io.javalin.Javalin app)
	{
		LoremIpsumWordSequence handler=new LoremIpsumWordSequence();
		app.get("/loremIpsumWordSequence/", handler);
	}

	public LoremIpsumWordSequence()
	{
		super();
		loremIpsumWordSequence.setAllowsNull(false);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private String generate(io.javalin.http.Context ctx)
	{
		return loremIpsumWordSequence.next();
	}
}
