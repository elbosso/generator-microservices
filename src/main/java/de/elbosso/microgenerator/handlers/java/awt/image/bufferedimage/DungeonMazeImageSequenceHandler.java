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

@javax.annotation.Generated(value="de.elbosso.util.processors.GeneratorRestHandlerProcessor", date="2021-01-29T15:07:39.286Z")
public class DungeonMazeImageSequenceHandler extends
de.elbosso.microgenerator.handlers.image.PNGEncoder
{
	private final de.elbosso.util.generator.semantics.DungeonMazeImageSequence generator=new de.elbosso.util.generator.semantics.DungeonMazeImageSequence();

	public static void register(io.javalin.Javalin app)
	{
		DungeonMazeImageSequenceHandler handler=new DungeonMazeImageSequenceHandler();
		app.get("/dungeonMazeImg/", handler);
	}

	public DungeonMazeImageSequenceHandler()
	{
		super();
	}

	@Override
	@OpenApi(
			summary = "Get DungeonMazeImageSequence",
			deprecated = false,
			//tags = {"user"},
			queryParams = {
					@OpenApiParam(name = "HeightMue", type = int.class),
					@OpenApiParam(name = "RemoveWallsWhenErasingCulDeSacs", type = boolean.class),
					@OpenApiParam(name = "WidthSigma", type = int.class),
					@OpenApiParam(name = "WithSolution", type = boolean.class),
					@OpenApiParam(name = "ThinWalls", type = boolean.class),
					@OpenApiParam(name = "EllipticShape", type = boolean.class),
					@OpenApiParam(name = "WidthMue", type = int.class),
					@OpenApiParam(name = "OnlyRectangularRooms", type = boolean.class),
					@OpenApiParam(name = "AllowBackTrack", type = boolean.class),
					@OpenApiParam(name = "HeightSigma", type = int.class),
					@OpenApiParam(name = "WithRooms", type = boolean.class),
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
        int HeightMue=20;
        try
        {
            HeightMue=ctx.queryParam("HeightMue",java.lang.Integer.class).getValue().intValue();
        }
        catch(java.lang.Throwable t)
        {
            HeightMue=20;
        }
        generator.setHeightMue(HeightMue);
        boolean RemoveWallsWhenErasingCulDeSacs=false;
        try
        {
            RemoveWallsWhenErasingCulDeSacs=ctx.queryParam("RemoveWallsWhenErasingCulDeSacs",java.lang.Boolean.class).getValue().booleanValue();
        }
        catch(java.lang.Throwable t)
        {
            RemoveWallsWhenErasingCulDeSacs=false;
        }
        generator.setRemoveWallsWhenErasingCulDeSacs(RemoveWallsWhenErasingCulDeSacs);
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
        boolean WithSolution=true;
        try
        {
            WithSolution=ctx.queryParam("WithSolution",java.lang.Boolean.class).getValue().booleanValue();
        }
        catch(java.lang.Throwable t)
        {
            WithSolution=true;
        }
        generator.setWithSolution(WithSolution);
        boolean ThinWalls=false;
        try
        {
            ThinWalls=ctx.queryParam("ThinWalls",java.lang.Boolean.class).getValue().booleanValue();
        }
        catch(java.lang.Throwable t)
        {
            ThinWalls=false;
        }
        generator.setThinWalls(ThinWalls);
        boolean EllipticShape=false;
        try
        {
            EllipticShape=ctx.queryParam("EllipticShape",java.lang.Boolean.class).getValue().booleanValue();
        }
        catch(java.lang.Throwable t)
        {
            EllipticShape=false;
        }
        generator.setEllipticShape(EllipticShape);
        int WidthMue=30;
        try
        {
            WidthMue=ctx.queryParam("WidthMue",java.lang.Integer.class).getValue().intValue();
        }
        catch(java.lang.Throwable t)
        {
            WidthMue=30;
        }
        generator.setWidthMue(WidthMue);
        boolean OnlyRectangularRooms=true;
        try
        {
            OnlyRectangularRooms=ctx.queryParam("OnlyRectangularRooms",java.lang.Boolean.class).getValue().booleanValue();
        }
        catch(java.lang.Throwable t)
        {
            OnlyRectangularRooms=true;
        }
        generator.setOnlyRectangularRooms(OnlyRectangularRooms);
        boolean AllowBackTrack=true;
        try
        {
            AllowBackTrack=ctx.queryParam("AllowBackTrack",java.lang.Boolean.class).getValue().booleanValue();
        }
        catch(java.lang.Throwable t)
        {
            AllowBackTrack=true;
        }
        generator.setAllowBackTrack(AllowBackTrack);
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
        boolean WithRooms=false;
        try
        {
            WithRooms=ctx.queryParam("WithRooms",java.lang.Boolean.class).getValue().booleanValue();
        }
        catch(java.lang.Throwable t)
        {
            WithRooms=false;
        }
        generator.setWithRooms(WithRooms);
		ctx.contentType("image/png");
		return encode(generator.next());
	}
}

