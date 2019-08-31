package de.elbosso.microgenerator.handlers.string;

public class GuruProfessionSequence extends Object implements io.javalin.http.Handler
{
	private final de.elbosso.util.generator.semantics.GuruProfessionSequence guruProfessionSequence=new de.elbosso.util.generator.semantics.GuruProfessionSequence();

	public static void register(io.javalin.Javalin app)
	{
		GuruProfessionSequence handler=new GuruProfessionSequence();
		app.get("/guruProfessionSequence/", handler);
	}

	public GuruProfessionSequence()
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
		return guruProfessionSequence.next();
	}
}
