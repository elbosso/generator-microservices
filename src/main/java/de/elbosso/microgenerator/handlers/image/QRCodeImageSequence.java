package de.elbosso.microgenerator.handlers.image;

public class QRCodeImageSequence extends PNGEncoder
{
	private final de.elbosso.util.generator.generalpurpose.QRCodeImageSequence qrCodeImageSequence=new de.elbosso.util.generator.generalpurpose.QRCodeImageSequence();

	public static void register(io.javalin.Javalin app)
	{
		QRCodeImageSequence handler=new QRCodeImageSequence();
		app.get("/qrCodeImageSequence/", handler);
		app.get("/qrCodeImageSequence/:dim", handler);
	}

	@Override
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.result(generate(ctx));
	}
	private java.io.InputStream generate(io.javalin.http.Context ctx) throws java.io.IOException
	{
		int dim=320;
		try
		{
			dim=ctx.pathParam("dim",java.lang.Integer.class).getValue().intValue();
		}
		catch(java.lang.Throwable t)
		{
			dim=320;
		}
		qrCodeImageSequence.setDimensionWidth(dim);
		ctx.contentType("image/png");
		return encode(qrCodeImageSequence.next());
	}
}
