package de.elbosso.microgenerator.handlers.string;

public class EMailAddressSequence extends Object implements io.javalin.http.Handler
{
	private final de.elbosso.util.generator.semantics.EMailAddressSequence eMailAddressSequence=new de.elbosso.util.generator.semantics.EMailAddressSequence();

	public static void register(io.javalin.Javalin app)
	{
		EMailAddressSequence handler=new EMailAddressSequence();
		app.get("/eMailAddressSequence/", handler);
	}

	public EMailAddressSequence()
	{
		super();
		eMailAddressSequence.setAllowsNull(false);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private String generate(io.javalin.http.Context ctx)
	{
		return eMailAddressSequence.next();
	}
}
