package org.chaoticbits.gofirst.genetic.dicegenome;

import java.util.ArrayList;
import java.util.Random;

import org.chaoticbits.gofirst.genetic.DiceGenome;
import org.chaoticbits.gofirst.genetic.SimulationEvaluator;
import org.chaoticbits.gofirst.genetic.algorithm.BirthCertificate;
import org.chaoticbits.gofirst.genetic.algorithm.IFitnessEvaluator;
import org.junit.Test;
import org.uncommons.maths.random.MersenneTwisterRNG;
import static org.chaoticbits.gofirst.genetic.algorithm.BirthCertificate.Type.*;
import static org.junit.Assert.*;

public class BirthCertificateTest {
	private Random rand = new MersenneTwisterRNG(new byte[] { 0x0, 0x1, 0x2, 0x3, 0x4, 0x5, 0x6, 0x7, 0x8, 0x9, 0xa,
			0xb, 0xc, 0xd, 0xe, 0xf });
	private IFitnessEvaluator<DiceGenome> evaluator = new SimulationEvaluator(rand);

	@Test
	public void originalIsInit() throws Exception {
		DiceGenome genome = new DiceGenome(rand, evaluator);
		assertEquals(INIT, genome.getBirthCertificate().getType());
		assertNull(genome.getBirthCertificate().getParent());
	}

	@Test
	public void givenIsGiven() throws Exception {
		DiceGenome parent = new DiceGenome(rand, new ArrayList<Integer>());
		DiceGenome genome = new DiceGenome(rand, evaluator, new BirthCertificate<DiceGenome>(parent, IMMIGRANT));
		assertEquals(IMMIGRANT, genome.getBirthCertificate().getType());
		assertSame(parent, genome.getBirthCertificate().getParent());
	}
	
	
}
