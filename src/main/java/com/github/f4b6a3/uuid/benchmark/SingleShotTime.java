
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
import com.github.f4b6a3.tsid.exception.TsidCreatorException;
import com.github.f4b6a3.ulid.UlidCreator;
import com.github.f4b6a3.ulid.exception.UlidCreatorException;
//import com.github.f4b6a3.tsid.TsidCreator;
//import com.github.f4b6a3.tsid.exception.TsidCreatorException;
//import com.github.f4b6a3.ulid.UlidCreator;
//import com.github.f4b6a3.ulid.exception.UlidCreatorException;
import com.github.f4b6a3.uuid.UuidCreator;
import com.github.f4b6a3.uuid.exception.UuidCreatorException;

@Threads(1)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 10, batchSize = 100_000)
@Measurement(iterations = 200, batchSize = 100_000)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class SingleShotTime {

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
		try {
			return UlidCreator.getUlid();
		} catch (UlidCreatorException e) {
			return null;
		}
	}

	@Benchmark
	public String UlidCreator_UlidString() {
		try {
			return UlidCreator.getUlidString();
		} catch (UlidCreatorException e) {
			return null;
		}
	}

	// TSID Creator

	@Benchmark
	public long TsidCreator_Tsid() {
		try {
			return TsidCreator.getTsid1024();
		} catch (TsidCreatorException e) {
			return 0;
		}
	}

	@Benchmark
	public String TsidCreator_TsidString() {
		try {
			return TsidCreator.getTsidString1024();
		} catch (TsidCreatorException e) {
			return null;
		}
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(SingleShotTime.class.getSimpleName()).build();
		new Runner(opt).run();
	}
}