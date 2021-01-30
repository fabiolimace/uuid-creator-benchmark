package com.github.f4b6a3.uuid.benchmark;

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

import com.github.f4b6a3.tsid.Tsid;
import com.github.f4b6a3.tsid.TsidCreator;
import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;
import com.github.f4b6a3.uuid.UuidCreator;

@Threads(1)
@Fork(1)
@State(Scope.Thread)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class Throughput {

	UUID uuid = UUID.randomUUID();
	String string = uuid.toString();
	private byte[] bytes = "http://www.github.com".getBytes();

	/*********** JDK UUID ***********/

	@Benchmark
	public String Uuid01_toString() {
		return uuid.toString();
	}

	@Benchmark
	public UUID Uuid02_fromString() {
		return UUID.fromString(string);
	}

	@Benchmark
	public UUID Uuid03_RandomBased() {
		return UUID.randomUUID();
	}

	@Benchmark
	public UUID Uuid04_NameBasedMd5() {
		return UUID.nameUUIDFromBytes(bytes);
	}

	/*********** UUID Creator ***********/

	@Benchmark
	public String UuidCreator01_toString() {
		return UuidCreator.toString(uuid);
	}

	@Benchmark
	public UUID UuidCreator02_fromString() {
		return UuidCreator.fromString(string);
	}

	@Benchmark
	public UUID UuidCreator03_RandomBased() {
		return UuidCreator.getRandomBased();
	}

	@Benchmark
	public UUID UuidCreator04_PrefixComb() {
		return UuidCreator.getPrefixComb();
	}

	@Benchmark
	public UUID UuidCreator05_ShortPrefixComb() {
		return UuidCreator.getShortPrefixComb();
	}

	@Benchmark
	public UUID UuidCreator06_NameBasedMd5() {
		return UuidCreator.getNameBasedMd5(bytes);
	}

	@Benchmark
	public UUID UuidCreator07_NameBasedSha1() {
		return UuidCreator.getNameBasedSha1(bytes);
	}

	@Benchmark
	public UUID UuidCreator08_TimeBased() {
		return UuidCreator.getTimeBased();
	}

	@Benchmark
	public UUID UuidCreator09_TimeOrdered() {
		return UuidCreator.getTimeOrdered();
	}

	/*********** ULID Creator ***********/

	@Benchmark
	public Ulid UlidCreator01_Ulid() {
		return UlidCreator.getUlid();
	}

	@Benchmark
	public Ulid UlidCreator02_MonotonicUlid() {
		return UlidCreator.getMonotonicUlid();
	}

	@Benchmark
	public String UlidCreator03_UlidString() {
		return UlidCreator.getUlid().toString();
	}

	@Benchmark
	public String UlidCreator04_MonotonicUlidString() {
		return UlidCreator.getMonotonicUlid().toString();
	}

	/*********** TSID Creator ***********/

	@Benchmark
	public Tsid TsidCreator01_Tsid256() {
		return TsidCreator.getTsid256();
	}

	@Benchmark
	public Tsid TsidCreator02_Tsid1024() {
		return TsidCreator.getTsid1024();
	}

	@Benchmark
	public Tsid TsidCreator03_Tsid4096() {
		return TsidCreator.getTsid4096();
	}

	@Benchmark
	public String TsidCreator04_Tsid256String() {
		return TsidCreator.getTsid256().toString();
	}

	@Benchmark
	public String TsidCreator05_Tsid1024String() {
		return TsidCreator.getTsid1024().toString();
	}

	@Benchmark
	public String TsidCreator06_Tsid4096String() {
		return TsidCreator.getTsid4096().toString();
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(Throughput.class.getSimpleName()).build();
		new Runner(opt).run();
	}
}