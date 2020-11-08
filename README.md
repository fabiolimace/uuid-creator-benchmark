# UUID Creator Benchmark

This file shows benchmarks using JMH v1.25.2.

```text
-----------------------------------------------------------------------------------
THROUGHPUT (operations/millis)
-----------------------------------------------------------------------------------
Benchmark                                Mode  Cnt      Score     Error   Units
-----------------------------------------------------------------------------------
Throughput.JDK_RandomBased              thrpt    5   2177,034 ±  12,483  ops/ms
Throughput.JDK_NameBasedMd5             thrpt    5   3238,463 ±  54,932  ops/ms
Throughput.UuidCreator_RandomBased      thrpt    5   2172,602 ±  12,425  ops/ms
Throughput.UuidCreator_NameBasedMd5     thrpt    5   3197,579 ±  18,163  ops/ms
Throughput.UuidCreator_NameBasedSha1    thrpt    5   2475,547 ±  31,032  ops/ms
Throughput.UuidCreator_PrefixComb       thrpt    5   2876,617 ±  25,612  ops/ms
Throughput.UuidCreator_ShortPrefixComb  thrpt    5   2227,698 ±  12,688  ops/ms
Throughput.UuidCreator_TimeBased        thrpt    5   9971,924 ±   9,817  ops/ms
Throughput.UuidCreator_TimeOrdered      thrpt    5   9972,807 ±   3,678  ops/ms
Throughput.UlidCreator_Ulid             thrpt    5  19236,123 ± 156,123  ops/ms
Throughput.UlidCreator_UlidString       thrpt    5  12893,016 ± 179,618  ops/ms
Throughput.TsidCreator_Tsid256          thrpt    5  16375,673 ±  38,712  ops/ms
Throughput.TsidCreator_Tsid1024         thrpt    5   4096,214 ±   0,189  ops/ms
Throughput.TsidCreator_Tsid4096         thrpt    5   1024,060 ±   0,107  ops/ms
Throughput.TsidCreator_TsidString256    thrpt    5  14806,519 ±  68,378  ops/ms
Throughput.TsidCreator_TsidString1024   thrpt    5   4092,947 ±   0,909  ops/ms
Throughput.TsidCreator_TsidString4096   thrpt    5   1024,026 ±   0,135  ops/ms
-----------------------------------------------------------------------------------
Total time: 00:22:40
-----------------------------------------------------------------------------------
```

How to run the benchmark on command line:

```bash
mvn clean install
```

Benchmarks executed in a PC with Ubuntu 20.04, JVM 11.0.7, CPU Intel i5-3330 and 8GB RAM.

Links for generators
-------------------------------------------
* [UUID Creator](https://github.com/f4b6a3/uuid-creator)
* [ULID Creator](https://github.com/f4b6a3/ulid-creator)
* [TSID Creator](https://github.com/f4b6a3/tsid-creator)

