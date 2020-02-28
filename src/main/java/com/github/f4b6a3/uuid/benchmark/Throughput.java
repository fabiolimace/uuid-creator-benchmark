package com.github.f4b6a3.uuid.benchmark;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.github.f4b6a3.uuid.UuidCreator;
import com.github.f4b6a3.uuid.exception.UuidCreatorException;
import com.github.f4b6a3.uuid.factory.CombGuidCreator;
import com.github.f4b6a3.uuid.factory.NameBasedMd5UuidCreator;
import com.github.f4b6a3.uuid.factory.NameBasedSha1UuidCreator;
import com.github.f4b6a3.uuid.factory.RandomUuidCreator;
import com.github.f4b6a3.uuid.factory.SequentialUuidCreator;
import com.github.f4b6a3.uuid.factory.TimeBasedUuidCreator;
import com.github.f4b6a3.uuid.factory.UlidBasedGuidCreator;

@Threads(1)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 1)
@Measurement(iterations = 5)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class Throughput {

	private byte[] bytes = "John Smith".getBytes(StandardCharsets.UTF_8);

	private RandomUuidCreator randomCreator;
	private RandomUuidCreator fastRandomCreator;
	private NameBasedMd5UuidCreator nameBasedMd5Creator;
	private NameBasedSha1UuidCreator nameBasedSha1Creator;
	private SequentialUuidCreator sequentialCreator;
	private TimeBasedUuidCreator timeBasedCreator;
	private SequentialUuidCreator sequentialMacCreator;
	private TimeBasedUuidCreator timeBasedMacCreator;
	private CombGuidCreator combCreator;
	private UlidBasedGuidCreator ulidBasedCreator;

	@Setup
	public void setUp() throws IOException {
		randomCreator = UuidCreator.getRandomCreator();
		fastRandomCreator = UuidCreator.getFastRandomCreator();
		nameBasedMd5Creator = UuidCreator.getNameBasedMd5Creator();
		nameBasedSha1Creator = UuidCreator.getNameBasedSha1Creator();
		sequentialCreator = UuidCreator.getSequentialCreator();
		timeBasedCreator = UuidCreator.getTimeBasedCreator();
		sequentialMacCreator = UuidCreator.getSequentialCreator().withHardwareAddressNodeIdentifier();
		timeBasedMacCreator = UuidCreator.getTimeBasedCreator().withHardwareAddressNodeIdentifier();
		combCreator = UuidCreator.getCombCreator();
		ulidBasedCreator = UuidCreator.getUlidBasedCreator();
	}

	// Java UUID

	@Benchmark
	public UUID Java_Random() {
		return UUID.randomUUID();
	}

	// EAIO

	@Benchmark
	public com.eaio.uuid.UUID EAIO_TimeBasedWithMac() {
		return new com.eaio.uuid.UUID();
	}

	// UUID Creator

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
	public UUID UuidCreator_UlidBasedGuid() {
		return ulidBasedCreator.create();
	}

	@Benchmark
	public UUID UuidCreator_CombGuid() {
		return combCreator.create();
	}

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

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(Throughput.class.getSimpleName()).build();
		new Runner(opt).run();
	}
}