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
package de.elbosso.microgenerator.handlers.java.lang.string;

import de.elbosso.util.generator.semantics.openapi.Config;
import de.elbosso.util.generator.semantics.xml.Customizations;
import de.elbosso.util.generator.semantics.xml.SchemaAnalyzer;
import io.javalin.plugin.openapi.annotations.OpenApi;
import io.javalin.plugin.openapi.annotations.OpenApiContent;
import io.javalin.plugin.openapi.annotations.OpenApiParam;
import io.javalin.plugin.openapi.annotations.OpenApiResponse;
import org.json.JSONException;
import org.xml.sax.SAXException;

import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.util.Collections;

public class OpenApiSequenceHandler extends
Object implements io.javalin.http.Handler
{
	private de.elbosso.util.generator.semantics.VCardSequence vCardSequence=new de.elbosso.util.generator.semantics.VCardSequence();

	public static void register(io.javalin.Javalin app)
	{
		OpenApiSequenceHandler handler=new OpenApiSequenceHandler();
		app.get("/openApiFragment/", handler);
	}

	public OpenApiSequenceHandler()
	{
		super();
	}

	@Override
	@OpenApi(
			description = "This is a highly fragile example - and one that does not show the true possibilities of this generator: " +
					"There are multiple possibilities to customize the ways the resulting JSON is populated. The OpenApi Description and all its referenced" +
					"elements must be reachable at exactly the given location for this generator to work",
			summary = "Get XmlFragment",
			deprecated = false,
			//tags = {"user"},
			queryParams = {
					@OpenApiParam(name = "OpenApiSpec", type = String.class, description = "For example: https://petstore3.swagger.io/api/v3/openapi.json")
			},
			responses = {
					@OpenApiResponse(status = "200", content = @OpenApiContent(from = String.class, type = "text/vcard")),
					@OpenApiResponse(status = "204") // No content
			}
	)
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.result(generate(ctx)).contentType("application/json");
	}
	private String generate(io.javalin.http.Context ctx) throws IOException, JSONException, URISyntaxException
	{
		String openApiSpec=ctx.queryParam("OpenApiSpec", String.class).getValue();

		StringWriter writer = new StringWriter();
		de.elbosso.util.generator.semantics.openapi.OpenApi openAPI = new de.elbosso.util.generator.semantics.openapi.OpenApi(Collections.EMPTY_MAP,new Config(),new java.net.URI(openApiSpec));
		java.util.Collection<java.lang.String> schemaTypeNames=openAPI.getSchemaTypeNames();
		java.io.PrintWriter pw=new java.io.PrintWriter(writer);
		org.json.JSONObject obj=new org.json.JSONObject();
		for(java.lang.String schemaTypeName:schemaTypeNames)
		{
			obj.put(schemaTypeName,openAPI.produceJson(schemaTypeName));
		}
		pw.println(obj.toString(2));
		pw.close();
		writer.close();
		return writer.toString();
	}
}

