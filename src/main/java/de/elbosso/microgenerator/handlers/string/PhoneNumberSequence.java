package de.elbosso.microgenerator.handlers.string;

public class PhoneNumberSequence extends Object implements io.javalin.http.Handler
{
	private final de.netsysit.util.generator.semantics.PhoneNumberSequence phoneNumberSequence=new de.netsysit.util.generator.semantics.PhoneNumberSequence();

	public static void register(io.javalin.Javalin app)
	{
		PhoneNumberSequence handler=new PhoneNumberSequence();
		app.get("/phoneNumberSequence", handler);
	}

	public PhoneNumberSequence()
	{
		super();
		phoneNumberSequence.setAllowsNull(false);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private String generate(io.javalin.http.Context ctx)
	{
		return phoneNumberSequence.next();
	}
}
