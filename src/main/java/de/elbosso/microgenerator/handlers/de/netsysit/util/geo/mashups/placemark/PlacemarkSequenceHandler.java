/*
Copyright (c) 2012-2020.

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
package de.elbosso.microgenerator.handlers.de.netsysit.util.geo.mashups.placemark;

import io.javalin.plugin.openapi.annotations.OpenApi;
import io.javalin.plugin.openapi.annotations.OpenApiContent;
import io.javalin.plugin.openapi.annotations.OpenApiParam;
import io.javalin.plugin.openapi.annotations.OpenApiResponse;

@javax.annotation.Generated(value="de.elbosso.util.processors.GeneratorRestHandlerProcessor", date="2020-08-29T16:01:43.466Z")
public class PlacemarkSequenceHandler extends
java.lang.Object implements io.javalin.http.Handler
{
	private final de.netsysit.util.generator.semantics.PlacemarkSequence generator=new de.netsysit.util.generator.semantics.PlacemarkSequence();

	public static void register(io.javalin.Javalin app)
	{
		PlacemarkSequenceHandler handler=new PlacemarkSequenceHandler();
		app.get("/placemark/", handler);
	}

	public PlacemarkSequenceHandler()
	{
		super();
	}

	@Override
	@OpenApi(
			summary = "Get PlacemarkSequence",
			deprecated = false,
			//tags = {"user"},
			queryParams = {
					@OpenApiParam(name = "Maxx", type = double.class),
					@OpenApiParam(name = "Minx", type = double.class),
					@OpenApiParam(name = "Miny", type = double.class),
			},
			responses = {
					@OpenApiResponse(status = "200", content = @OpenApiContent(from = de.netsysit.util.geo.mashups.Placemark.class)),
					@OpenApiResponse(status = "204") // No content
			}
	)
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private de.netsysit.util.geo.mashups.Placemark generate(io.javalin.http.Context ctx)
	{
        double Maxx=-180;
        try
        {
            Maxx=ctx.queryParam("Maxx",java.lang.Double.class).getValue().doubleValue();
        }
        catch(java.lang.Throwable t)
        {
            Maxx=-180;
        }
        generator.setMaxx(Maxx);
        double Minx=180;
        try
        {
            Minx=ctx.queryParam("Minx",java.lang.Double.class).getValue().doubleValue();
        }
        catch(java.lang.Throwable t)
        {
            Minx=180;
        }
        generator.setMinx(Minx);
        double Miny=-90;
        try
        {
            Miny=ctx.queryParam("Miny",java.lang.Double.class).getValue().doubleValue();
        }
        catch(java.lang.Throwable t)
        {
            Miny=-90;
        }
        generator.setMiny(Miny);
		return generator.next();
	}
}

