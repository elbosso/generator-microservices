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

import io.javalin.plugin.openapi.annotations.OpenApi;
import io.javalin.plugin.openapi.annotations.OpenApiContent;
import io.javalin.plugin.openapi.annotations.OpenApiResponse;
import net.sourceforge.cardme.vcard.exceptions.VCardBuildException;

import java.io.IOException;

public class VCardSequenceHandler extends
Object implements io.javalin.http.Handler
{
	private de.elbosso.util.generator.semantics.VCardSequence vCardSequence=new de.elbosso.util.generator.semantics.VCardSequence();

	public static void register(io.javalin.Javalin app)
	{
		VCardSequenceHandler handler=new VCardSequenceHandler();
		app.get("/vCard/", handler);
	}

	public VCardSequenceHandler()
	{
		super();
	}

	@Override
	@OpenApi(
			summary = "Get VCardSequence",
			deprecated = false,
			//tags = {"user"},
			responses = {
					@OpenApiResponse(status = "200", content = @OpenApiContent(from = String.class, type = "text/vcard")),
					@OpenApiResponse(status = "204") // No content
			}
	)
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.result(generate(ctx)).contentType("text/vcard");
	}
	private String generate(io.javalin.http.Context ctx) throws IOException, VCardBuildException
	{
		java.io.StringWriter sw=new java.io.StringWriter();
		while (true)
		{
			try
			{
				net.sourceforge.cardme.vcard.VCard vCard = vCardSequence.next();
				java.io.PrintWriter pw = new java.io.PrintWriter(sw);
				net.sourceforge.cardme.io.VCardWriter vcardWriter = new net.sourceforge.cardme.io.VCardWriter();
				vcardWriter.setOutputVersion(net.sourceforge.cardme.vcard.arch.VCardVersion.V3_0);
				vcardWriter.setFoldingScheme(net.sourceforge.cardme.io.FoldingScheme.MIME_DIR);
				vcardWriter.setCompatibilityMode(net.sourceforge.cardme.io.CompatibilityMode.RFC2426);
				vcardWriter.setBinaryfoldingScheme(net.sourceforge.cardme.io.BinaryFoldingScheme.MIME_DIR);
				vcardWriter.setVCard(vCard);

				String vcardString = vcardWriter.buildVCardString();
				pw.println(vcardString);
				pw.close();
				break;
			}
			catch(Throwable t){}
		}
		return sw.toString();
	}
}

