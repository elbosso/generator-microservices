package de.elbosso.microgenerator.handlers.string;

public class AddressSequence extends Object implements io.javalin.http.Handler
{
	private final de.netsysit.util.generator.semantics.AddressSequence addressSequence=new de.netsysit.util.generator.semantics.AddressSequence();

	public static void register(io.javalin.Javalin app)
	{
		AddressSequence handler=new AddressSequence();
		app.get("/addressSequence", handler);
	}

	public AddressSequence()
	{
		super();
		addressSequence.setAllowsNull(false);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private String generate(io.javalin.http.Context ctx)
	{
		return addressSequence.next();
	}
}
