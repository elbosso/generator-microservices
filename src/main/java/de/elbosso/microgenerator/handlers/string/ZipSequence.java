package de.elbosso.microgenerator.handlers.string;

public class ZipSequence extends Object implements io.javalin.http.Handler
{
	private final de.netsysit.util.generator.semantics.ZipSequence zipSequence=new de.netsysit.util.generator.semantics.ZipSequence();

	public static void register(io.javalin.Javalin app)
	{
		ZipSequence handler=new ZipSequence();
		app.get("/zipSequence", handler);
	}

	public ZipSequence()
	{
		super();
		zipSequence.setAllowsNull(false);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private String generate(io.javalin.http.Context ctx)
	{
		return zipSequence.next();
	}
}
