package de.elbosso.microgenerator.handlers.string;

public class LoremIpsumSequence extends Object implements io.javalin.http.Handler
{
	private final de.netsysit.util.generator.generalpurpose.LoremIpsumSequence loremIpsumSequence=new de.netsysit.util.generator.generalpurpose.LoremIpsumSequence();

	public static void register(io.javalin.Javalin app)
	{
		LoremIpsumSequence handler=new LoremIpsumSequence();
		app.get("/loremIpsumSequence", handler);
		app.get("/loremIpsumSequence/:minlen/:maxlen/:maxlinelen", handler);
	}

	public LoremIpsumSequence()
	{
		super();
		loremIpsumSequence.setAllowsNulls(false);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		int minlen=0;
		try
		{
			minlen=ctx.pathParam("minlen",java.lang.Integer.class).getValue().intValue();
		}
		catch(java.lang.Throwable t)
		{
			minlen=0;
		}
		int maxlen=1024;
		try
		{
			maxlen=ctx.pathParam("maxlen",java.lang.Integer.class).getValue().intValue();
		}
		catch(java.lang.Throwable t)
		{
			maxlen=1024;
		}
		int maxlinelen=0;
		try
		{
			maxlinelen=ctx.pathParam("maxlinelen",java.lang.Integer.class).getValue().intValue();
		}
		catch(java.lang.Throwable t)
		{
			maxlinelen=0;
		}
		loremIpsumSequence.setMinLen(minlen);
		loremIpsumSequence.setMaxLen(maxlen);
		loremIpsumSequence.setMaxlinelength(maxlinelen);
		ctx.json(generate(ctx));
	}
	private String generate(io.javalin.http.Context ctx)
	{
		return loremIpsumSequence.next();
	}
}
