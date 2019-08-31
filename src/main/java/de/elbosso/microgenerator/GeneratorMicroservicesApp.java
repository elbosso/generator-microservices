package de.elbosso.microgenerator;

import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import io.javalin.http.Context;

import java.io.IOException;

public class GeneratorMicroservicesApp
{

	private static final de.elbosso.util.generator.generalpurpose.GaussianRandomBoxMuller gaussianRandomBoxMuller=new de.elbosso.util.generator.generalpurpose.GaussianRandomBoxMuller();
//	private static final de.elbosso.util.generator.generalpurpose.PasswordCardImageSequence passwordCardImageSequence=new de.elbosso.util.generator.generalpurpose.PasswordCardImageSequence();
//	private static final de.elbosso.util.generator.generalpurpose.QRCodeImageSequence qrCodeImageSequence=new de.elbosso.util.generator.generalpurpose.QRCodeImageSequence();
//	private static final de.elbosso.util.generator.generalpurpose.NormalOverDayDateSequence normalOverDayDateSequence=new de.elbosso.util.generator.generalpurpose.NormalOverDayDateSequence();


	public static void main(String[] args) {
		Javalin app = Javalin.create(config ->
				config.registerPlugin(new RouteOverviewPlugin("/"))).start(7000);
		app.get("/gaussianRandomBoxMuller/",ctx -> ctx.json(generateGaussianRandomBoxMuller(ctx)));
		app.get("/gaussianRandomBoxMuller/:mean/:variance",ctx -> ctx.json(generateGaussianRandomBoxMuller(ctx)));
//		app.get("/passwordCardImageSequence/",ctx -> ctx.json(generatePasswordCardImageSequence(ctx)));
		de.elbosso.microgenerator.handlers.image.QRCodeImageSequence.register(app);
//		normalOverDayDateSequence.setAllowsNull(false);
//		app.get("/normalOverDayDateSequence/", ctx -> ctx.result(generateNormalOverDayDateSequence(ctx)));
//		app.get("/normalOverDayDateSequence/:mueInMinutes/:sigmaInMinutes", ctx -> ctx.json(generateNormalOverDayDateSequence(ctx)));
	}


	/*	private static java.awt.image.BufferedImage generatePasswordCardImageSequence(Context ctx)
		{
			return passwordCardImageSequence.next();
		}
	*/
	private static Number generateGaussianRandomBoxMuller(Context ctx)
	{
		double mean=0.0;
		double variance=1.0;
		int dim=320;
		try
		{
			mean=ctx.pathParam("mean",java.lang.Double.class).getValue().doubleValue();
		}
		catch(java.lang.Throwable t)
		{
			mean=0.0;
		}
		try
		{
			variance=ctx.pathParam("variance",java.lang.Double.class).getValue().doubleValue();
		}
		catch(java.lang.Throwable t)
		{
			variance=1.0;
		}
		gaussianRandomBoxMuller.setMean(mean);
		gaussianRandomBoxMuller.setVariance(variance);
		return gaussianRandomBoxMuller.next();
	}
}