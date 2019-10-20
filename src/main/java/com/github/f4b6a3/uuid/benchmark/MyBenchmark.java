/**
 * Copyright 2018 Fabio Lima <br/>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); <br/>
 * you may not use this file except in compliance with the License. <br/>
 * You may obtain a copy of the License at <br/>
 *
 * http://www.apache.org/licenses/LICENSE-2.0 <br/>
 *
 * Unless required by applicable law or agreed to in writing, software <br/>
 * distributed under the License is distributed on an "AS IS" BASIS, <br/>
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. <br/>
 * See the License for the specific language governing permissions and <br/>
 * limitations under the License. <br/>
 *
 */

package com.github.f4b6a3.uuid.benchmark;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.RunnerException;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.UUIDTimer;
import com.fasterxml.uuid.impl.NameBasedGenerator;
import com.fasterxml.uuid.impl.RandomBasedGenerator;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import com.github.f4b6a3.uuid.UuidCreator;
import com.github.f4b6a3.uuid.exception.UuidCreatorException;
import com.github.f4b6a3.uuid.factory.CombGuidCreator;
import com.github.f4b6a3.uuid.factory.DceSecurityUuidCreator;
import com.github.f4b6a3.uuid.factory.LexicalOrderGuidCreator;
import com.github.f4b6a3.uuid.factory.NameBasedMd5UuidCreator;
import com.github.f4b6a3.uuid.factory.NameBasedSha1UuidCreator;
import com.github.f4b6a3.uuid.factory.RandomUuidCreator;
import com.github.f4b6a3.uuid.factory.SequentialUuidCreator;
import com.github.f4b6a3.uuid.factory.TimeBasedUuidCreator;

@Threads(1)
@State(Scope.Thread)
@Warmup(iterations = 10, batchSize = 100_000)
@Measurement(iterations = 20, batchSize = 100_000)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MyBenchmark {

	private String name = "John Smith";
	private byte[] bytes = name.getBytes(StandardCharsets.UTF_8);

	private NameBasedGenerator jugNameBasedMd5Generator;
	private NameBasedGenerator jugNameBasedSha1Generator;
	private TimeBasedGenerator jugTimeBasedGenerator;
	private TimeBasedGenerator jugTimeBasedMacGenerator;
	private RandomBasedGenerator jugRandomGenerator;

	private RandomUuidCreator randomCreator;
	private RandomUuidCreator fastRandomCreator;
	private NameBasedMd5UuidCreator nameBasedMd5Creator;
	private NameBasedSha1UuidCreator nameBasedSha1Creator;
	private SequentialUuidCreator sequentialCreator;
	private TimeBasedUuidCreator timeBasedCreator;
	private SequentialUuidCreator sequentialMacCreator;
	private TimeBasedUuidCreator timeBasedMacCreator;
	private DceSecurityUuidCreator dceSecurityCreator;
	private DceSecurityUuidCreator dceSecurityWithMacCreator;
	private CombGuidCreator combCreator;
	private LexicalOrderGuidCreator lexicalOrderCreator;

	@Setup
	public void setUp() throws IOException {

		name = "https://github.com/";

		jugNameBasedMd5Generator = Generators.nameBasedGenerator(null, getDigester("MD5"));
		jugNameBasedSha1Generator = Generators.nameBasedGenerator(null, getDigester("SHA-1"));
		jugTimeBasedGenerator = Generators.timeBasedGenerator(null, getUUIDTimer());
		jugTimeBasedMacGenerator = Generators.timeBasedGenerator(EthernetAddress.fromInterface(), getUUIDTimer());
		jugRandomGenerator = Generators.randomBasedGenerator(new SecureRandom());

		randomCreator = UuidCreator.getRandomCreator();
		fastRandomCreator = UuidCreator.getFastRandomCreator();
		nameBasedMd5Creator = UuidCreator.getNameBasedMd5Creator();
		nameBasedSha1Creator = UuidCreator.getNameBasedSha1Creator();
		sequentialCreator = UuidCreator.getSequentialCreator();
		timeBasedCreator = UuidCreator.getTimeBasedCreator();
		sequentialMacCreator = UuidCreator.getSequentialCreator().withHardwareAddressNodeIdentifier();
		timeBasedMacCreator = UuidCreator.getTimeBasedCreator().withHardwareAddressNodeIdentifier();
		dceSecurityCreator = UuidCreator.getDceSecurityCreator();
		dceSecurityWithMacCreator = UuidCreator.getDceSecurityCreator().withHardwareAddressNodeIdentifier();
		combCreator = UuidCreator.getCombGuidCreator();
		lexicalOrderCreator = UuidCreator.getLexicalOrderCreator();
	}

	private static MessageDigest getDigester(String alg) {
		MessageDigest digester;
		try {
			digester = MessageDigest.getInstance(alg);
		} catch (NoSuchAlgorithmException nex) {
			throw new IllegalArgumentException("Couldn't instantiate SHA-1 MessageDigest instance: " + nex.toString());
		}
		return digester;
	}

	private static UUIDTimer getUUIDTimer() {
		try {
			return new UUIDTimer(new Random(System.currentTimeMillis()), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Java UUID

	@Benchmark
	public UUID Java_Random() {
		return UUID.randomUUID();
	}

	@Benchmark
	public UUID Java_NameBased() {
		return UUID.nameUUIDFromBytes(bytes);
	}

	// EAIO

	@Benchmark
	public com.eaio.uuid.UUID EAIO_TimeBasedWithMac() {
		return new com.eaio.uuid.UUID();
	}

	// JUG

	@Benchmark
	public UUID JUG_NameBasedMd5() {
		return jugNameBasedMd5Generator.generate(bytes);
	}

	@Benchmark
	public UUID JUG_NameBasedSha1() {
		return jugNameBasedSha1Generator.generate(bytes);
	}

	@Benchmark
	public UUID JUG_TimeBased() {
		return jugTimeBasedGenerator.generate();
	}

	@Benchmark
	public UUID JUG_TimeBasedWithMAC() {
		return jugTimeBasedMacGenerator.generate();
	}

	@Benchmark
	public UUID JUG_Random() {
		return jugRandomGenerator.generate();
	}

	// UUID Creator

	@Benchmark
	public UUID UuidCreator_Random() {
		return randomCreator.create();
	}

	@Benchmark
	public UUID UuidCreator_FastRandom() {
		return fastRandomCreator.create();
	}

	@Benchmark
	public UUID UuidCreator_NameBasedMd5() {
		return nameBasedMd5Creator.create(bytes);
	}

	@Benchmark
	public UUID UuidCreator_NameBasedSha1() {
		return nameBasedSha1Creator.create(bytes);
	}

	@Benchmark
	public UUID UuidCreator_CombGuid() {
		return combCreator.create();
	}

	@Benchmark
	public UUID UuidCreator_DceSecurity() {
		try {
			return dceSecurityCreator.create((byte) 1, 1701);
		} catch (UuidCreatorException e) {
			return null;
		}
	}

	@Benchmark
	public UUID UuidCreator_DceSecurityWithMac() {
		try {
			return dceSecurityWithMacCreator.create((byte) 1, 1701);
		} catch (UuidCreatorException e) {
			return null;
		}
	}

	@Benchmark
	public UUID UuidCreator_Sequential() {
		try {
			return sequentialCreator.create();
		} catch (UuidCreatorException e) {
			return null;
		}
	}

	@Benchmark
	public UUID UuidCreator_SequentialWithMac() {
		try {
			return sequentialMacCreator.create();
		} catch (UuidCreatorException e) {
			return null;
		}
	}

	@Benchmark
	public UUID UuidCreator_TimeBased() {
		try {
			return timeBasedCreator.create();
		} catch (UuidCreatorException e) {
			return null;
		}
	}
	
	@Benchmark
	public UUID UuidCreator_TimeBasedWithMac() {
		try {
			return timeBasedMacCreator.create();
		} catch (UuidCreatorException e) {
			return null;
		}
	}

	@Benchmark
	public UUID UuidCreator_LexicalOrderGuid() {
		try {
			return lexicalOrderCreator.create();
		} catch (UuidCreatorException e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		try {
			org.openjdk.jmh.Main.main(args);
		} catch (RunnerException | IOException e) {
		}
	}
}