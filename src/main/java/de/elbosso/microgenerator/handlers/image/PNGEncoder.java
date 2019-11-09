package de.elbosso.microgenerator.handlers.image;

import java.io.IOException;

public abstract class PNGEncoder extends java.lang.Object implements io.javalin.http.Handler
{
	protected java.io.InputStream encode(java.awt.image.BufferedImage img) throws IOException
	{
		java.io.ByteArrayOutputStream baos=new java.io.ByteArrayOutputStream();
		javax.imageio.ImageIO.write(img,"png",baos);
		baos.close();
		return new java.io.ByteArrayInputStream(baos.toByteArray());
	}
}
