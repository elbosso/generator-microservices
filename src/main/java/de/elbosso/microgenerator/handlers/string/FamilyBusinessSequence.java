package de.elbosso.microgenerator.handlers.string;

public class FamilyBusinessSequence extends Object implements io.javalin.http.Handler
{
	private final de.elbosso.util.generator.semantics.FamilyBusinessSequence familyBusinessSequence=new de.elbosso.util.generator.semantics.FamilyBusinessSequence();

	public static void register(io.javalin.Javalin app)
	{
		FamilyBusinessSequence handler=new FamilyBusinessSequence();
		app.get("/familyBusinessSequence", handler);
	}

	public FamilyBusinessSequence()
	{
		super();
		familyBusinessSequence.setAllowsNull(false);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private String generate(io.javalin.http.Context ctx)
	{
		return familyBusinessSequence.next();
	}
}
