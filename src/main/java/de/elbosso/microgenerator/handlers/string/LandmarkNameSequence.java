package de.elbosso.microgenerator.handlers.string;

public class LandmarkNameSequence extends Object implements io.javalin.http.Handler
{
	private final de.elbosso.util.generator.semantics.LandmarkNameSequence landmarkNameSequence=new de.elbosso.util.generator.semantics.LandmarkNameSequence();

	public static void register(io.javalin.Javalin app)
	{
		LandmarkNameSequence handler=new LandmarkNameSequence();
		app.get("/landmarkNameSequence/", handler);
	}

	public LandmarkNameSequence()
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
		return landmarkNameSequence.next();
	}
}
