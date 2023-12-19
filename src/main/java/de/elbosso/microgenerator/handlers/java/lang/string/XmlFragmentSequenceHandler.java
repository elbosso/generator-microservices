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

import de.elbosso.util.generator.semantics.xml.Customizations;
import de.elbosso.util.generator.semantics.xml.SchemaAnalyzer;
import io.javalin.plugin.openapi.annotations.OpenApi;
import io.javalin.plugin.openapi.annotations.OpenApiContent;
import io.javalin.plugin.openapi.annotations.OpenApiParam;
import io.javalin.plugin.openapi.annotations.OpenApiResponse;
import net.sourceforge.cardme.vcard.exceptions.VCardBuildException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.util.Collections;

public class XmlFragmentSequenceHandler extends
Object implements io.javalin.http.Handler
{
	private de.elbosso.util.generator.semantics.VCardSequence vCardSequence=new de.elbosso.util.generator.semantics.VCardSequence();

	public static void register(io.javalin.Javalin app)
	{
		XmlFragmentSequenceHandler handler=new XmlFragmentSequenceHandler();
		app.get("/xmlFragment/", handler);
	}

	public XmlFragmentSequenceHandler()
	{
		super();
	}

	@Override
	@OpenApi(
			description = "This is a highly fragile example - and one that does not show the true possibilities of this generator: " +
					"There are multiple possibilities to customize the ways the resulting xml is populated. The Schema and all its referenced" +
					"schemas must be reachable at exactly the given location for this generator to work - and you have to know one top level" +
					"element of the schema - this is going to be the starting point for the generator...",
			summary = "Get XmlFragment",
			deprecated = false,
			//tags = {"user"},
			queryParams = {
					@OpenApiParam(name = "Schema", type = String.class, description = "For example: http://tecfa.unige.ch/guides/xml/examples/xsd-examples/recipe.xsd"),
					@OpenApiParam(name = "RootElementName", type = String.class, description = "For example: list"),
			},
			responses = {
					@OpenApiResponse(status = "200", content = @OpenApiContent(from = String.class, type = "text/vcard")),
					@OpenApiResponse(status = "204") // No content
			}
	)
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.result(generate(ctx)).contentType("text/xml");
	}
	private String generate(io.javalin.http.Context ctx) throws IOException, TransformerException, SAXException, URISyntaxException, org.apache.xmlbeans.XmlException, ParserConfigurationException
	{
		String schema=ctx.queryParam("Schema",java.lang.String.class).getValue();
		String rootElementName=ctx.queryParam("RootElementName",java.lang.String.class).getValue();

		java.net.URI schemaUri=new java.net.URI(schema);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		SchemaAnalyzer.generate(schemaUri,result,rootElementName, new Customizations(Collections.emptyMap(),Collections.EMPTY_MAP));
		writer.close();
		return writer.toString();
	}
}

