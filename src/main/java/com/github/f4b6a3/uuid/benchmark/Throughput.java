package com.github.f4b6a3.uuid.benchmark;

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
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.github.f4b6a3.tsid.TsidCreator;
import com.github.f4b6a3.ulid.UlidCreator;
import com.github.f4b6a3.uuid.UuidCreator;
import com.github.f4b6a3.uuid.exception.UuidCreatorException;

@Threads(1)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class Throughput {

	private byte[] bytes = "John Smith".getBytes(StandardCharsets.UTF_8);

	// Java UUID

	@Benchmark
	public UUID Java_RandomBased() {
		return UUID.randomUUID();
	}

	// UUID Creator

	@Benchmark
	public UUID UuidCreator_TimeBased() {
		try {
			return UuidCreator.getTimeBased();
		} catch (UuidCreatorException e) {
			return null;
		}
	}

	@Benchmark
	public UUID UuidCreator_TimeOrdered() {
		try {
			return UuidCreator.getTimeOrdered();
		} catch (UuidCreatorException e) {
			return null;
		}
	}

	@Benchmark
	public UUID UuidCreator_RandomBased() {
		return UuidCreator.getRandomBased();
	}

	@Benchmark
	public UUID UuidCreator_NameBasedMd5() {
		return UuidCreator.getNameBasedMd5(bytes);
	}

	@Benchmark
	public UUID UuidCreator_NameBasedSha1() {
		return UuidCreator.getNameBasedSha1(bytes);
	}

	@Benchmark
	public UUID UuidCreator_PrefixComb() {
		return UuidCreator.getPrefixComb();
	}

	@Benchmark
	public UUID UuidCreator_ShortPrefixComb() {
		return UuidCreator.getShortPrefixComb();
	}

	// ULID Creator

	@Benchmark
	public UUID UlidCreator_Ulid() {
		return UlidCreator.getUlid();
	}

	@Benchmark
	public String UlidCreator_UlidString() {
		return UlidCreator.getUlidString();
	}

	// TSID Creator

	@Benchmark
	public long TsidCreator_Tsid256() {
		return TsidCreator.getTsid256();
	}

	@Benchmark
	public String TsidCreator_TsidString256() {
		return TsidCreator.getTsidString256();
	}

	@Benchmark
	public long TsidCreator_Tsid1024() {
		return TsidCreator.getTsid1024();
	}

	@Benchmark
	public String TsidCreator_TsidString1024() {
		return TsidCreator.getTsidString1024();
	}

	@Benchmark
	public long TsidCreator_Tsid4096() {
		return TsidCreator.getTsid4096();
	}

	@Benchmark
	public String TsidCreator_TsidString4096() {
		return TsidCreator.getTsidString4096();
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(Throughput.class.getSimpleName()).build();
		new Runner(opt).run();
	}
}