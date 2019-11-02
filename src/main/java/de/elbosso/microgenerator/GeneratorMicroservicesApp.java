package de.elbosso.microgenerator;

import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import io.javalin.http.Context;

import java.io.IOException;

public class GeneratorMicroservicesApp
{

	public static void main(String[] args) {
		Javalin app = Javalin.create(config ->
				config.registerPlugin(new RouteOverviewPlugin("/"))).start(7000);
		de.elbosso.microgenerator.handlers.date.SimpleRandomDateInThePastSequence.register(app);
		de.elbosso.microgenerator.handlers.image.QRCodeImageSequence.register(app);
		de.elbosso.microgenerator.handlers.number.GaussianRandomBoxMuller.register(app);
		de.elbosso.microgenerator.handlers.number.NormalDistributedRandom.register(app);
		de.elbosso.microgenerator.handlers.number.NrRandomizer0.register(app);
		de.elbosso.microgenerator.handlers.number.NrRandomizer1.register(app);
		de.elbosso.microgenerator.handlers.number.NrRandomizer2.register(app);
		de.elbosso.microgenerator.handlers.number.OneDimensionalPerlinNoise.register(app);
		de.elbosso.microgenerator.handlers.number.PoissonDistributedRandom.register(app);
		de.elbosso.microgenerator.handlers.object.CreditCard.register(app);
		de.elbosso.microgenerator.handlers.string.AddressSequence.register(app);
		de.elbosso.microgenerator.handlers.string.ClickBaitSequence.register(app);
		de.elbosso.microgenerator.handlers.string.EMailAddressSequence.register(app);
		de.elbosso.microgenerator.handlers.string.GivenNameSequence.register(app);
		de.elbosso.microgenerator.handlers.string.GUIDSequence.register(app);
		de.elbosso.microgenerator.handlers.string.GuruProfessionSequence.register(app);
		de.elbosso.microgenerator.handlers.string.HausNummerSequence.register(app);
		de.elbosso.microgenerator.handlers.string.LoremIpsumSequence.register(app);
		de.elbosso.microgenerator.handlers.string.LoremIpsumWordSequence.register(app);
		de.elbosso.microgenerator.handlers.string.NameSequence.register(app);
		de.elbosso.microgenerator.handlers.string.PhoneNumberSequence.register(app);
		de.elbosso.microgenerator.handlers.string.PlacesSequence.register(app);
		de.elbosso.microgenerator.handlers.string.SurNameSequence.register(app);
		de.elbosso.microgenerator.handlers.string.ZipSequence.register(app);
		de.elbosso.microgenerator.handlers.string.LandmarkNameSequence.register(app);
		de.elbosso.microgenerator.handlers.string.FamilyBusinessSequence.register(app);
	}


}