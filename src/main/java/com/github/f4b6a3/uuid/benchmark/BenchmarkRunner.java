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
import org.openjdk.jmh.annotations.Warmup;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.NameBasedGenerator;
import com.fasterxml.uuid.impl.RandomBasedGenerator;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import com.github.f4b6a3.uuid.UuidCreator;
import com.github.f4b6a3.uuid.exception.UuidCreatorException;
import com.github.f4b6a3.uuid.factory.CombGuidCreator;
import com.github.f4b6a3.uuid.factory.DceSecurityUuidCreator;
import com.github.f4b6a3.uuid.factory.MssqlGuidCreator;
import com.github.f4b6a3.uuid.factory.SequentialUuidCreator;
import com.github.f4b6a3.uuid.factory.TimeBasedUuidCreator;

/**
 * A simple benchmark that compares this implementation to others.
 * 
 * If the computer is too fast, {@link OverrunException} may be thrown,
 * increasing some scores.
 *
 */
@State(Scope.Thread)
@Warmup(iterations = 1, batchSize = 1000)
@Measurement(iterations = 10, batchSize = 100000)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class BenchmarkRunner {

	private String name;
	private byte[] bytes;

	private NameBasedGenerator jugNameBasedGenerator;
	private TimeBasedGenerator jugTimeBasedGenerator;
	private TimeBasedGenerator jugTimeBasedMACGenerator;
	private RandomBasedGenerator jugRandomGenerator;

	private SequentialUuidCreator sequentialCreator;
	private TimeBasedUuidCreator timeBasedCreator;
	private SequentialUuidCreator sequentialMacCreator;
	private TimeBasedUuidCreator timeBasedMacCreator;
	private DceSecurityUuidCreator dceSecurityCreator;
	private DceSecurityUuidCreator dceSecurityWithMacCreator;
	private MssqlGuidCreator mssqlCreator;
	private CombGuidCreator combCreator;

	@Setup
	public void setUp() {

		name = "https://github.com/";
		bytes = name.getBytes();

		jugNameBasedGenerator = Generators.nameBasedGenerator();
		jugTimeBasedGenerator = Generators.timeBasedGenerator();
		jugTimeBasedMACGenerator = Generators.timeBasedGenerator(EthernetAddress.fromInterface());
		jugRandomGenerator = Generators.randomBasedGenerator();

		sequentialCreator = UuidCreator.getSequentialCreator();
		timeBasedCreator = UuidCreator.getTimeBasedCreator();
		sequentialMacCreator = UuidCreator.getSequentialCreator().withHardwareAddress();
		timeBasedMacCreator = UuidCreator.getTimeBasedCreator().withHardwareAddress();
		dceSecurityCreator = UuidCreator.getDceSecurityCreator();
		dceSecurityWithMacCreator = UuidCreator.getDceSecurityCreator().withHardwareAddress();
		mssqlCreator = UuidCreator.getMssqlGuidCreator();
		combCreator = UuidCreator.getCombGuidCreator();

	}

	// Java UUID

	@Benchmark
	public UUID JavaRandom() {
		return UUID.randomUUID();
	}

	@Benchmark
	public UUID JavaNameBased() {
		return UUID.nameUUIDFromBytes(bytes);
	}

	// EAIO

	@Benchmark
	public com.eaio.uuid.UUID EaioTimeBasedWithMac() {
		return new com.eaio.uuid.UUID();
	}

	// JUG

	@Benchmark
	public UUID JugNameBased() {
		return jugNameBasedGenerator.generate(bytes);
	}

	@Benchmark
	public UUID JugTimeBased() {
		return jugTimeBasedGenerator.generate();
	}

	@Benchmark
	public UUID JugTimeBasedWithMAC() {
		return jugTimeBasedMACGenerator.generate();
	}

	@Benchmark
	public UUID JugRandom() {
		return jugRandomGenerator.generate();
	}

	// UUID Creator

	@Benchmark
	public UUID UuidCreatorRandom() {
		return UuidCreator.getRandom();
	}

	@Benchmark
	public UUID UuidCreatorFastRandom() {
		return UuidCreator.getFastRandom();
	}

	@Benchmark
	public UUID UuidCreatorNameBasedMd5() {
		return UuidCreator.getNameBasedMd5(name);
	}

	@Benchmark
	public UUID UuidCreatorNameBasedSha1() {
		return UuidCreator.getNameBasedSha1(name);
	}

	@Benchmark
	public UUID UuidCreatorNameBasedSha256() {
		return UuidCreator.getNameBasedSha256(name);
	}

	@Benchmark
	public UUID UuidCreatorCombGuid() {
		return combCreator.create();
	}

	@Benchmark
	public UUID UuidCreatorMssqlGuid() {
		try {
			return mssqlCreator.create();
		} catch (UuidCreatorException e) {
			return null;
		}
	}

	@Benchmark
	public UUID UuidCreatorDceSecurity() {
		try {
			return dceSecurityCreator.create((byte) 1, 1701);
		} catch (UuidCreatorException e) {
			return null;
		}
	}

	@Benchmark
	public UUID UuidCreatorDceSecurityWithMac() {
		try {
			return dceSecurityWithMacCreator.create((byte) 1, 1701);
		} catch (UuidCreatorException e) {
			return null;
		}
	}

	@Benchmark
	public UUID UuidCreatorSequential() {
		try {
			return sequentialCreator.create();
		} catch (UuidCreatorException e) {
			return null;
		}
	}

	@Benchmark
	public UUID UuidCreatorSequentialWithMac() {
		try {
			return sequentialMacCreator.create();
		} catch (UuidCreatorException e) {
			return null;
		}
	}

	@Benchmark
	public UUID UuidCreatorTimeBased() {
		try {
			return timeBasedCreator.create();
		} catch (UuidCreatorException e) {
			return null;
		}
	}

	@Benchmark
	public UUID UuidCreatorTimeBasedWithMac() {
		try {
			return timeBasedMacCreator.create();
		} catch (UuidCreatorException e) {
			return null;
		}
	}

	public static void main(String[] args) throws Exception {
		org.openjdk.jmh.Main.main(args);
	}
}