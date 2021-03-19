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
import io.javalin.plugin.openapi.annotations.OpenApiResponse;

import java.awt.*;

public class ColourSequenceHandler extends
Object implements io.javalin.http.Handler
{
	private final de.elbosso.util.generator.generalpurpose.RandomColor generator=new de.elbosso.util.generator.generalpurpose.RandomColor();

	private float h=new java.util.Random().nextFloat();
	private float increment=0.005f;

	public static void register(io.javalin.Javalin app)
	{
		ColourSequenceHandler handler=new ColourSequenceHandler();
		app.get("/color/", handler);
	}

	public ColourSequenceHandler()
	{
		super();
	}

	@Override
	@OpenApi(
			summary = "Get random Color",
			deprecated = false,
			//tags = {"user"},
			responses = {
					@OpenApiResponse(status = "200", content = @OpenApiContent(from = String.class)),
					@OpenApiResponse(status = "204") // No content
			}
	)
	public void handle(io.javalin.http.Context ctx) throws Exception
	{
		ctx.json(generate(ctx));
	}
	private Obj[] generate(io.javalin.http.Context ctx)
	{
		java.awt.Color steady=java.awt.Color.getHSBColor(h, 1,1);
		h += increment;
		h %= 1;
		return new Obj[]{new Obj(generator.next()),new Obj(steady)};
	}
	public class Obj
	{
		private final java.awt.Color color;

		public Obj(Color color)
		{
			this.color = color;
		}
		public int getRed()
		{
			return color.getRed();
		}
		public int getGreen()
		{
			return color.getGreen();
		}
		public int getBlue()
		{
			return color.getBlue();
		}
		public int getAlpha()
		{
			return color.getAlpha();
		}
		public java.lang.String getHexRgb()
		{
			java.lang.String rv=java.lang.Integer.toHexString(color.getRGB());
			if(rv.length()>5)
				rv=rv.substring(rv.length()-6,rv.length());
			return rv;
		}
		public java.lang.String getDigiBlinkStickFormat()
		{
			return "*"+String.format("%03d", getRed())+","+String.format("%03d", getGreen())+","+String.format("%03d", getBlue());
		}
	}
}

