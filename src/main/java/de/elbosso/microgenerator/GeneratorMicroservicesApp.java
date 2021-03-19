/*
Copyright (c) 2012-2019.

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
package de.elbosso.microgenerator;

import io.javalin.Javalin;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;
import net.fortuna.ical4j.util.MapTimeZoneCache;

public class GeneratorMicroservicesApp
{

	public static void main(String[] args) {
		System.setProperty("net.fortuna.ical4j.timezone.cache.impl", MapTimeZoneCache.class.getName());
		Javalin app = Javalin.create(config ->
				config
//						.registerPlugin(new RouteOverviewPlugin("/"))
		.registerPlugin(new OpenApiPlugin(getOpenApiOptions()))
		.enableWebjars()
				.addStaticFiles("/site")
		).start(7000);

	//java.lang.Float
		de.elbosso.microgenerator.handlers.java.lang.floatp.RandomFloatSequenceHandler.register(app);
	//de.netsysit.util.lang.Tupel
		de.elbosso.microgenerator.handlers.de.netsysit.util.lang.tupel.NameEMailAddressBundleSequenceHandler.register(app);
	//java.awt.image.BufferedImage
		de.elbosso.microgenerator.handlers.java.awt.image.bufferedimage.ConstantTestPatternImageSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.awt.image.bufferedimage.NixieNumberImageSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.awt.image.bufferedimage.ParkhausNumberImageSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.awt.image.bufferedimage.QRCodeImageSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.awt.image.bufferedimage.SevenSegmentNumberImageSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.awt.image.bufferedimage.AvatarIconImageSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.awt.image.bufferedimage.DungeonMazeImageSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.awt.image.bufferedimage.TexEquationImageSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.awt.image.bufferedimage.TruchetTilingSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.awt.image.bufferedimage.TunnelImageSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.awt.image.bufferedimage.WangDominoTilingSequenceHandler.register(app);
	//java.lang.Double
		de.elbosso.microgenerator.handlers.java.lang.doublep.DoubleIncrementSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.doublep.NrRandomizer0Handler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.doublep.NrRandomizer1Handler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.doublep.NrRandomizer2Handler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.doublep.RandomDoubleSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.doublep.RandomGaussianSequenceHandler.register(app);
	//java.util.Date
		de.elbosso.microgenerator.handlers.java.util.date.NormalOverDayDateSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.util.date.NowHandler.register(app);
		de.elbosso.microgenerator.handlers.java.util.date.DateIncrementSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.util.date.SimpleRandomDateInThePastSequenceHandler.register(app);
	//de.netsysit.util.geo.mashups.Placemark
		de.elbosso.microgenerator.handlers.de.netsysit.util.geo.mashups.placemark.PlacemarkSequenceHandler.register(app);
	//java.lang.Integer
		de.elbosso.microgenerator.handlers.java.lang.integer.IntIncrementSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.integer.RandomIntSequenceHandler.register(app);
	//de.elbosso.util.generator.semantics.CreditCard
		de.elbosso.microgenerator.handlers.de.elbosso.util.generator.semantics.creditcard.CreditCardSequenceHandler.register(app);
	//	de.elbosso.util.generator.semantics.Quotation
		de.elbosso.microgenerator.handlers.de.elbosso.util.generator.semantics.quotation.QuotationSequenceHandler.register(app);
	//java.lang.Long
		de.elbosso.microgenerator.handlers.java.lang.longp.RandomLongSequenceHandler.register(app);
	//java.lang.Short
		de.elbosso.microgenerator.handlers.java.lang.shortp.RandomShortSequenceHandler.register(app);
	//java.lang.Boolean
		de.elbosso.microgenerator.handlers.java.lang.booleanp.BiasedBooleanSequenceHandler.register(app);
	//java.lang.String
		de.elbosso.microgenerator.handlers.java.lang.string.LoremIpsumWordSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.QRCodeSVGSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.ClickBaitSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.CreditCardNumberSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.EANSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.EMailAddressSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.FamilyBusinessSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.GivenNameSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.GuruProfessionSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.HTMLDinBriefSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.IBANHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.Ipv4AddressSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.LandmarkNameSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.NameSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.RandomLanguageCodeSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.RandomUserAgentSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.RomanNumeralSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.SurNameSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.TeXDinBriefSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.UrlSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.GUIDSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.LoremIpsumSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.AddressSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.HausNummerSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.PhoneNumberSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.PlacesSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.ZipSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.JavaIdentifierSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.BullshitPhrasesSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.Base32PasswordSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.ProductSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.ICalSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.VCardSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.FakeIdentitySequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.XmlFragmentSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.OpenApiSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.DungeonMazeTextSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.TexEquationGeneratorHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.ColourSequenceHandler.register(app);

	//java.lang.Number
		de.elbosso.microgenerator.handlers.java.lang.number.GaussianRandomBoxMullerHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.number.NormalDistributedRandomHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.number.OneDimensionalPerlinNoiseHandler.register(app);
	//	org.json.JSONObject
		de.elbosso.microgenerator.handlers.org.json.jsonobject.TrackerInfoSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.org.json.jsonobject.PlacemarkSequenceHandler.register(app);
	}

	private static OpenApiOptions getOpenApiOptions()
	{
		Info applicationInfo = new Info()
			.version("2.2.0-SNAPSHOT")
			.description("de.elbosso.generator-microservices");
		return new OpenApiOptions(applicationInfo)
				.path("/open-api-spec")
				.swagger(new SwaggerOptions("/try-it").title("de.elbosso.generator-microservices - try it!"))
//				.reDoc(new ReDocOptions("/redoc").title("My ReDoc Documentation"))
		;
	}
}