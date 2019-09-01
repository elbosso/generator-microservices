package de.elbosso.microgenerator.handlers.date;

public class SimpleRandomDateInThePastSequence extends Object implements io.javalin.http.Handler
{
	private final de.netsysit.util.generator.generalpurpose.SimpleRandomDateInThePastSequence simpleRandomDateInThePastSequence=new de.netsysit.util.generator.generalpurpose.SimpleRandomDateInThePastSequence();

	public static void register(io.javalin.Javalin app)
	{
		SimpleRandomDateInThePastSequence handler=new SimpleRandomDateInThePastSequence();
		app.get("/simpleRandomDateInThePastSequence/", handler);
	}

	public SimpleRandomDateInThePastSequence()
	{
		super();
		simpleRandomDateInThePastSequence.setAllowsNull(false);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private java.util.Date generate(io.javalin.http.Context ctx)
	{
		return simpleRandomDateInThePastSequence.next();
	}
}
