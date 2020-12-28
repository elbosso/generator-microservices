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
package de.elbosso.microgenerator.handlers.java.lang.string;

import io.javalin.plugin.openapi.annotations.OpenApi;
import io.javalin.plugin.openapi.annotations.OpenApiContent;
import io.javalin.plugin.openapi.annotations.OpenApiParam;
import io.javalin.plugin.openapi.annotations.OpenApiResponse;

@javax.annotation.Generated(value="de.elbosso.util.processors.GeneratorRestHandlerProcessor", date="2020-12-28T13:17:02.617Z")
public class DungeonMazeTextSequenceHandler extends
java.lang.Object implements io.javalin.http.Handler
{
	private final de.elbosso.util.generator.semantics.DungeonMazeTextSequence generator=new de.elbosso.util.generator.semantics.DungeonMazeTextSequence();

	public static void register(io.javalin.Javalin app)
	{
		DungeonMazeTextSequenceHandler handler=new DungeonMazeTextSequenceHandler();
		app.get("/dungeonMazeText/", handler);
	}

	public DungeonMazeTextSequenceHandler()
	{
		super();
	}

	@Override
	@OpenApi(
			summary = "Get DungeonMazeTextSequence",
			deprecated = false,
			//tags = {"user"},
			queryParams = {
					@OpenApiParam(name = "HeightMue", type = int.class),
					@OpenApiParam(name = "WidthSigma", type = int.class),
					@OpenApiParam(name = "TronMode", type = boolean.class),
					@OpenApiParam(name = "AnsiEscapes", type = boolean.class),
					@OpenApiParam(name = "WidthMue", type = int.class),
					@OpenApiParam(name = "HeightSigma", type = int.class),
			},
			responses = {
					@OpenApiResponse(status = "200", content = @OpenApiContent(from = java.lang.String.class)),
					@OpenApiResponse(status = "204") // No content
			}
	)
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private java.lang.String generate(io.javalin.http.Context ctx)
	{
        int HeightMue=15;
        try
        {
            HeightMue=ctx.queryParam("HeightMue",java.lang.Integer.class).getValue().intValue();
        }
        catch(java.lang.Throwable t)
        {
            HeightMue=15;
        }
        generator.setHeightMue(HeightMue);
        int WidthSigma=8;
        try
        {
            WidthSigma=ctx.queryParam("WidthSigma",java.lang.Integer.class).getValue().intValue();
        }
        catch(java.lang.Throwable t)
        {
            WidthSigma=8;
        }
        generator.setWidthSigma(WidthSigma);
        boolean TronMode=false;
        try
        {
            TronMode=ctx.queryParam("TronMode",java.lang.Boolean.class).getValue().booleanValue();
        }
        catch(java.lang.Throwable t)
        {
            TronMode=false;
        }
        generator.setTronMode(TronMode);
        boolean AnsiEscapes=false;
        try
        {
            AnsiEscapes=ctx.queryParam("AnsiEscapes",java.lang.Boolean.class).getValue().booleanValue();
        }
        catch(java.lang.Throwable t)
        {
            AnsiEscapes=false;
        }
        generator.setAnsiEscapes(AnsiEscapes);
        int WidthMue=50;
        try
        {
            WidthMue=ctx.queryParam("WidthMue",java.lang.Integer.class).getValue().intValue();
        }
        catch(java.lang.Throwable t)
        {
            WidthMue=50;
        }
        generator.setWidthMue(WidthMue);
        int HeightSigma=5;
        try
        {
            HeightSigma=ctx.queryParam("HeightSigma",java.lang.Integer.class).getValue().intValue();
        }
        catch(java.lang.Throwable t)
        {
            HeightSigma=5;
        }
        generator.setHeightSigma(HeightSigma);
		return generator.next();
	}
}

