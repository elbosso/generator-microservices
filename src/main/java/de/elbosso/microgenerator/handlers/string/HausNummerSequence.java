package de.elbosso.microgenerator.handlers.string;

public class HausNummerSequence extends Object implements io.javalin.http.Handler
{
	private final de.netsysit.util.generator.semantics.HausNummerSequence hausNummerSequence=new de.netsysit.util.generator.semantics.HausNummerSequence();

	public static void register(io.javalin.Javalin app)
	{
		HausNummerSequence handler=new HausNummerSequence();
		app.get("/hausNummerSequence", handler);
		app.get("/hausNummerSequence/:minlen/:maxlen/:maxlinelen", handler);
	}

	public HausNummerSequence()
	{
		super();
		hausNummerSequence.setAllowsNull(false);
		hausNummerSequence.setAppartments(true);
		hausNummerSequence.setRanges(true);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private String generate(io.javalin.http.Context ctx)
	{
		return hausNummerSequence.next();
	}
}
