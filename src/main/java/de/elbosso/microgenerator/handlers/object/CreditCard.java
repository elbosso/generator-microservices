package de.elbosso.microgenerator.handlers.object;

public class CreditCard extends Object implements io.javalin.http.Handler
{
	private final de.elbosso.util.generator.semantics.CreditCardSequence creditCardSequence=new de.elbosso.util.generator.semantics.CreditCardSequence();

	public static void register(io.javalin.Javalin app)
	{
		CreditCard handler=new CreditCard();
		app.get("/creditCardSequence/", handler);
	}

	CreditCard()
	{
		super();
		creditCardSequence.setAllowsNull(false);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private Object generate(io.javalin.http.Context ctx)
	{
		return creditCardSequence.next();
	}
}
