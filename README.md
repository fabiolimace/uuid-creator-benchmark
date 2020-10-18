# UUID Creator Benchmark

This file shows benchmarks using JMH v1.25.2.

```text
-----------------------------------------------------------------------------------
THROUGHPUT (operations/millis)
-----------------------------------------------------------------------------------
Benchmark                                Mode  Cnt      Score     Error   Units
-----------------------------------------------------------------------------------
Throughput.Java_RandomBased             thrpt    5   2203,710 ±   7,539  ops/ms
Throughput.UuidCreator_RandomBased      thrpt    5   2204,038 ±   4,716  ops/ms
Throughput.UuidCreator_PrefixComb       thrpt    5   2750,621 ±  14,206  ops/ms
Throughput.UuidCreator_ShortPrefixComb  thrpt    5   2149,540 ±   2,840  ops/ms
Throughput.UuidCreator_NameBasedMd5     thrpt    5   3888,460 ±  18,874  ops/ms
Throughput.UuidCreator_NameBasedSha1    thrpt    5   2950,550 ±   4,524  ops/ms
Throughput.UuidCreator_TimeBased        thrpt    5  18111,045 ±  92,912  ops/ms
Throughput.UuidCreator_TimeOrdered      thrpt    5  18272,405 ±  66,720  ops/ms
Throughput.UlidCreator_Ulid             thrpt    5  19187,272 ±  73,752  ops/ms
Throughput.UlidCreator_UlidString       thrpt    5   5092,343 ±  31,329  ops/ms
Throughput.TsidCreator_Tsid             thrpt    5  32003,000 ± 142,804  ops/ms
Throughput.TsidCreator_TsidString       thrpt    5  11790,429 ± 101,426  ops/ms
Throughput.TsidCreator_Tsid1024         thrpt    5   4096,236 ±   0,352  ops/ms
Throughput.TsidCreator_TsidString1024   thrpt    5   4088,976 ±   0,729  ops/ms
-----------------------------------------------------------------------------------
Total time: 00:17:24
-----------------------------------------------------------------------------------
```

```text
-----------------------------------------------------------------------------------
AVERAGE TIME (nanos/operation)
-----------------------------------------------------------------------------------
Benchmark                                Mode  Cnt    Score   Error  Units
-----------------------------------------------------------------------------------
AverageTime.Java_RandomBased             avgt    5  452,032 ± 2,062  ns/op
AverageTime.UuidCreator_RandomBased      avgt    5  448,903 ± 1,541  ns/op
AverageTime.UuidCreator_PrefixComb       avgt    5  360,176 ± 1,578  ns/op
AverageTime.UuidCreator_ShortPrefixComb  avgt    5  465,791 ± 1,319  ns/op
AverageTime.UuidCreator_NameBasedMd5     avgt    5  244,583 ± 0,681  ns/op
AverageTime.UuidCreator_NameBasedSha1    avgt    5  332,775 ± 1,030  ns/op
AverageTime.UuidCreator_TimeBased        avgt    5   55,593 ± 0,294  ns/op
AverageTime.UuidCreator_TimeOrdered      avgt    5   55,185 ± 0,292  ns/op
AverageTime.UlidCreator_Ulid             avgt    5   52,122 ± 0,110  ns/op
AverageTime.UlidCreator_UlidString       avgt    5  196,876 ± 0,730  ns/op
AverageTime.TsidCreator_Tsid1024         avgt    5  244,127 ± 0,026  ns/op
AverageTime.TsidCreator_TsidString1024   avgt    5  244,594 ± 0,422  ns/op
-----------------------------------------------------------------------------------
Total time: 00:17:24
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

