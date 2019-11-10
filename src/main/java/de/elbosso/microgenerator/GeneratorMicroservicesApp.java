package de.elbosso.microgenerator;

import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import io.javalin.http.Context;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.ui.ReDocOptions;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;

import java.io.IOException;

public class GeneratorMicroservicesApp
{

	public static void main(String[] args) {
		Javalin app = Javalin.create(config ->
				config
//						.registerPlugin(new RouteOverviewPlugin("/"))
		.registerPlugin(new OpenApiPlugin(getOpenApiOptions()))
		.enableWebjars()
				.addStaticFiles("/site")
		).start(7000);
		de.elbosso.microgenerator.handlers.java.lang.string.ClickBaitSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.string.HTMLDinBriefSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.lang.number.GaussianRandomBoxMullerHandler.register(app);
		de.elbosso.microgenerator.handlers.java.util.date.NowHandler.register(app);
		de.elbosso.microgenerator.handlers.de.elbosso.util.generator.semantics.creditcard.CreditCardSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.awt.image.bufferedimage.AvatarIconImageSequenceHandler.register(app);
		de.elbosso.microgenerator.handlers.java.awt.image.bufferedimage.PasswordCardImageSequenceHandler.register(app);
	}

	private static OpenApiOptions getOpenApiOptions()
	{
		Info applicationInfo = new Info()
			.version("1.0.0")
			.description("de.elbosso.generator-microservices");
		return new OpenApiOptions(applicationInfo)
				.path("/open-api-spec")
				.swagger(new SwaggerOptions("/try-it").title("de.elbosso.generator-microservices - try it!"))
//				.reDoc(new ReDocOptions("/redoc").title("My ReDoc Documentation"))
		;
	}
}