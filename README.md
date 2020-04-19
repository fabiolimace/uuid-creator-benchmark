# UUID Creator Benchmark

This file shows benchmarks for [UUID Creator](https://github.com/f4b6a3/uuid-creator) v2.0.2 using JMH v1.23.

```text
-----------------------------------------------------------------------------------
THROUGHPUT (operations/millis)
-----------------------------------------------------------------------------------
Benchmark                                Mode  Cnt      Score     Error   Units
-----------------------------------------------------------------------------------
Throughput.Eaio_TimeBased               thrpt    5  21350,078 ± 123,608  ops/ms
Throughput.Java_Random                  thrpt    5   2199,813 ±   5,564  ops/ms
Throughput.TsidCreator_Tsid             thrpt    5  32113,516 ± 158,437  ops/ms
Throughput.TsidCreator_TsidString       thrpt    5   8357,057 ±  67,245  ops/ms
Throughput.UlidCreator_Ulid             thrpt    5  30472,976 ± 253,581  ops/ms
Throughput.UlidCreator_UlidString       thrpt    5   4296,420 ±  42,628  ops/ms
Throughput.UuidCreator_CombGuid         thrpt    5   2755,767 ±  16,405  ops/ms
Throughput.UuidCreator_FastRandomBased  thrpt    5  89950,189 ± 649,687  ops/ms
Throughput.UuidCreator_NameBasedMd5     thrpt    5   3989,824 ±  13,802  ops/ms
Throughput.UuidCreator_NameBasedSha1    thrpt    5   3001,964 ±   4,703  ops/ms
Throughput.UuidCreator_RandomBased      thrpt    5   2184,672 ±   7,996  ops/ms
Throughput.UuidCreator_TimeBased        thrpt    5  18129,622 ±  53,520  ops/ms
Throughput.UuidCreator_TimeOrdered      thrpt    5  18222,911 ±  35,550  ops/ms
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
AverageTime.Eaio_TimeBased               avgt    5   47,051 ± 0,213  ns/op
AverageTime.Java_Random                  avgt    5  456,015 ± 2,100  ns/op
AverageTime.TsidCreator_Tsid             avgt    5   31,112 ± 0,148  ns/op
AverageTime.TsidCreator_TsidString       avgt    5  119,659 ± 1,199  ns/op
AverageTime.UlidCreator_Ulid             avgt    5   32,619 ± 0,065  ns/op
AverageTime.UlidCreator_UlidString       avgt    5  233,100 ± 0,943  ns/op
AverageTime.UuidCreator_CombGuid         avgt    5  361,115 ± 1,268  ns/op
AverageTime.UuidCreator_FastRandomBased  avgt    5   10,638 ± 0,050  ns/op
AverageTime.UuidCreator_NameBasedMd5     avgt    5  243,790 ± 1,622  ns/op
AverageTime.UuidCreator_NameBasedSha1    avgt    5  332,346 ± 0,919  ns/op
AverageTime.UuidCreator_RandomBased      avgt    5  452,502 ± 1,144  ns/op
AverageTime.UuidCreator_TimeBased        avgt    5   55,475 ± 0,322  ns/op
AverageTime.UuidCreator_TimeOrdered      avgt    5   54,210 ± 0,293  ns/op
-----------------------------------------------------------------------------------
Total time: 00:17:24
-----------------------------------------------------------------------------------
```
These external generators are used for comparison:

- com.eaio.uuid.UUID (for time-based UUID);
- java.util.UUID (for random UUID).

Benchmarks executed in a PC with Ubuntu 20.04, JVM 11.0.7, CPU Intel i5-3330 and 8GB RAM.

Links for generators
-------------------------------------------
* [UUID Creator](https://github.com/f4b6a3/uuid-creator)
* [ULID Creator](https://github.com/f4b6a3/ulid-creator)
* [TSID Creator](https://github.com/f4b6a3/tsid-creator)
* [Java Utils UUID Type and Generator](https://docs.oracle.com/javase/7/docs/api/java/util/UUID.html)
* [EAIO UUID Generator - Burkard (original)](https://johannburkard.de/software/uuid/)


