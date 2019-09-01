package de.elbosso.microgenerator.handlers.string;

public class PlacesSequence extends Object implements io.javalin.http.Handler
{
	private final de.netsysit.util.generator.semantics.PlacesSequence placesSequence=new de.netsysit.util.generator.semantics.PlacesSequence();

	public static void register(io.javalin.Javalin app)
	{
		PlacesSequence handler=new PlacesSequence();
		app.get("/placesSequence", handler);
	}

	public PlacesSequence()
	{
		super();
		placesSequence.setAllowsNull(false);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private String generate(io.javalin.http.Context ctx)
	{
		return placesSequence.next();
	}
}
