/*
Copyright (c) 2012-2021.

Juergen Key. Alle Rechte vorbehalten.

Weiterverbreitung und Verwendung in nichtkompilierter oder kompilierter Form, 
mit oder ohne Veraenderung, sind unter den folgenden Bedingungen zulaessig:

   1. Weiterverbreitete nichtkompilierte Exemplare muessen das obige Copyright, 
die Liste der Bedingungen und den folgenden Haftungsausschluss im Quelltext 
enthalten.
   2. Weiterverbreitete kompilierte Exemplare muessen das obige Copyright, 
die Liste der Bedingungen und den folgenden Haftungsausschluss in der 
Dokumentation und/oder anderen Materialien, die mit dem Exemplar verbreitet 
werden, enthalten.
   3. Weder der Name des Autors noch die Namen der Beitragsleistenden 
duerfen zum Kennzeichnen oder Bewerben von Produkten, die von dieser Software 
abgeleitet wurden, ohne spezielle vorherige schriftliche Genehmigung verwendet 
werden.

DIESE SOFTWARE WIRD VOM AUTOR UND DEN BEITRAGSLEISTENDEN OHNE 
JEGLICHE SPEZIELLE ODER IMPLIZIERTE GARANTIEN ZUR VERFUEGUNG GESTELLT, DIE 
UNTER ANDEREM EINSCHLIESSEN: DIE IMPLIZIERTE GARANTIE DER VERWENDBARKEIT DER 
SOFTWARE FUER EINEN BESTIMMTEN ZWECK. AUF KEINEN FALL IST DER AUTOR 
ODER DIE BEITRAGSLEISTENDEN FUER IRGENDWELCHE DIREKTEN, INDIREKTEN, 
ZUFAELLIGEN, SPEZIELLEN, BEISPIELHAFTEN ODER FOLGENDEN SCHAEDEN (UNTER ANDEREM 
VERSCHAFFEN VON ERSATZGUETERN ODER -DIENSTLEISTUNGEN; EINSCHRAENKUNG DER 
NUTZUNGSFAEHIGKEIT; VERLUST VON NUTZUNGSFAEHIGKEIT; DATEN; PROFIT ODER 
GESCHAEFTSUNTERBRECHUNG), WIE AUCH IMMER VERURSACHT UND UNTER WELCHER 
VERPFLICHTUNG AUCH IMMER, OB IN VERTRAG, STRIKTER VERPFLICHTUNG ODER 
UNERLAUBTE HANDLUNG (INKLUSIVE FAHRLAESSIGKEIT) VERANTWORTLICH, AUF WELCHEM 
WEG SIE AUCH IMMER DURCH DIE BENUTZUNG DIESER SOFTWARE ENTSTANDEN SIND, SOGAR, 
WENN SIE AUF DIE MOEGLICHKEIT EINES SOLCHEN SCHADENS HINGEWIESEN WORDEN SIND.
*/
package de.elbosso.microgenerator.handlers.java.awt.image.bufferedimage;

import io.javalin.plugin.openapi.annotations.OpenApi;
import io.javalin.plugin.openapi.annotations.OpenApiContent;
import io.javalin.plugin.openapi.annotations.OpenApiParam;
import io.javalin.plugin.openapi.annotations.OpenApiResponse;

@javax.annotation.Generated(value="de.elbosso.util.processors.GeneratorRestHandlerProcessor", date="2021-01-29T15:07:39.221Z")
public class TunnelImageSequenceHandler extends
de.elbosso.microgenerator.handlers.image.PNGEncoder
{
	private final de.elbosso.util.generator.generalpurpose.TunnelImageSequence generator=new de.elbosso.util.generator.generalpurpose.TunnelImageSequence();

	public static void register(io.javalin.Javalin app)
	{
		TunnelImageSequenceHandler handler=new TunnelImageSequenceHandler();
		app.get("/truchetTilingImg/", handler);
	}

	public TunnelImageSequenceHandler()
	{
		super();
	}

	@Override
	@OpenApi(
			summary = "Get TunnelImageSequence",
			deprecated = false,
			//tags = {"user"},
			queryParams = {
					@OpenApiParam(name = "Mode", type = int.class),
					@OpenApiParam(name = "ShapeCount", type = int.class),
					@OpenApiParam(name = "Dimension", type = int.class),
			},
			responses = {
					@OpenApiResponse(status = "200", content = @OpenApiContent(from = java.awt.image.BufferedImage.class)),
					@OpenApiResponse(status = "204") // No content
			}
	)
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.result(generate(ctx));
	}
	private java.io.InputStream generate(io.javalin.http.Context ctx) throws java.io.IOException
	{
        int Mode=0;
        try
        {
            Mode=ctx.queryParam("Mode",java.lang.Integer.class).getValue().intValue();
        }
        catch(java.lang.Throwable t)
        {
            Mode=0;
        }
        generator.setMode(Mode);
        int ShapeCount=80;
        try
        {
            ShapeCount=ctx.queryParam("ShapeCount",java.lang.Integer.class).getValue().intValue();
        }
        catch(java.lang.Throwable t)
        {
            ShapeCount=80;
        }
        generator.setShapeCount(ShapeCount);
        int Dimension=512;
        try
        {
            Dimension=ctx.queryParam("Dimension",java.lang.Integer.class).getValue().intValue();
        }
        catch(java.lang.Throwable t)
        {
            Dimension=512;
        }
        generator.setDimension(Dimension);
		ctx.contentType("image/png");
		return encode(generator.next());
	}
}

