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

@javax.annotation.Generated(value="de.elbosso.util.processors.GeneratorRestHandlerProcessor", date="2020-12-27T11:21:28.607Z")
public class PhoneNumberSequenceHandler extends
java.lang.Object implements io.javalin.http.Handler
{
	private final de.netsysit.util.generator.semantics.PhoneNumberSequence generator=new de.netsysit.util.generator.semantics.PhoneNumberSequence();

	public static void register(io.javalin.Javalin app)
	{
		PhoneNumberSequenceHandler handler=new PhoneNumberSequenceHandler();
		app.get("/phoneNumber/", handler);
	}

	public PhoneNumberSequenceHandler()
	{
		super();
	}

	@Override
	@OpenApi(
			summary = "Get PhoneNumberSequence",
			deprecated = false,
			//tags = {"user"},
			queryParams = {
					@OpenApiParam(name = "IncludeCell", type = boolean.class),
					@OpenApiParam(name = "Separator", type = String.class),
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
        boolean IncludeCell=false;
        try
        {
            IncludeCell=ctx.queryParam("IncludeCell",java.lang.Boolean.class).getValue().booleanValue();
        }
        catch(java.lang.Throwable t)
        {
            IncludeCell=false;
        }
        generator.setIncludeCell(IncludeCell);
        String Separator="/";
        try
        {
            Separator=ctx.queryParam("Separator",java.lang.String.class).getValue().toString();
        }
        catch(java.lang.Throwable t)
        {
            Separator="/";
        }
        generator.setSeparator(Separator);
		return generator.next();
	}
}

