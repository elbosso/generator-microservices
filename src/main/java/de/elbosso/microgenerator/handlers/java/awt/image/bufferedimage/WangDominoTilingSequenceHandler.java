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

@javax.annotation.Generated(value="de.elbosso.util.processors.GeneratorRestHandlerProcessor", date="2021-01-29T15:07:39.228Z")
public class WangDominoTilingSequenceHandler extends
de.elbosso.microgenerator.handlers.image.PNGEncoder
{
	private final de.elbosso.util.generator.generalpurpose.WangDominoTilingSequence generator=new de.elbosso.util.generator.generalpurpose.WangDominoTilingSequence();

	public static void register(io.javalin.Javalin app)
	{
		WangDominoTilingSequenceHandler handler=new WangDominoTilingSequenceHandler();
		app.get("/wangDominoTilingImg/", handler);
	}

	public WangDominoTilingSequenceHandler()
	{
		super();
	}

	@Override
	@OpenApi(
			summary = "Get WangDominoTilingSequence",
			deprecated = false,
			//tags = {"user"},
			queryParams = {
					@OpenApiParam(name = "DimensionWidth", type = int.class),
					@OpenApiParam(name = "PreferHomogenousRegions", type = boolean.class),
					@OpenApiParam(name = "DimensionHeight", type = int.class),
					@OpenApiParam(name = "Tilesize", type = int.class),
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
        int DimensionWidth=8;
        try
        {
            DimensionWidth=ctx.queryParam("DimensionWidth",java.lang.Integer.class).getValue().intValue();
        }
        catch(java.lang.Throwable t)
        {
            DimensionWidth=8;
        }
        generator.setDimensionWidth(DimensionWidth);
        boolean PreferHomogenousRegions=true;
        try
        {
            PreferHomogenousRegions=ctx.queryParam("PreferHomogenousRegions",java.lang.Boolean.class).getValue().booleanValue();
        }
        catch(java.lang.Throwable t)
        {
            PreferHomogenousRegions=true;
        }
        generator.setPreferHomogenousRegions(PreferHomogenousRegions);
        int DimensionHeight=6;
        try
        {
            DimensionHeight=ctx.queryParam("DimensionHeight",java.lang.Integer.class).getValue().intValue();
        }
        catch(java.lang.Throwable t)
        {
            DimensionHeight=6;
        }
        generator.setDimensionHeight(DimensionHeight);
        int Tilesize=128;
        try
        {
            Tilesize=ctx.queryParam("Tilesize",java.lang.Integer.class).getValue().intValue();
        }
        catch(java.lang.Throwable t)
        {
            Tilesize=128;
        }
        generator.setTilesize(Tilesize);
		ctx.contentType("image/png");
		return encode(generator.next());
	}
}

