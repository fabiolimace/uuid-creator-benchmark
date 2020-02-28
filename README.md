# UUID Creator Benchmark

This file shows benchmarks for [UUID Creator](https://github.com/f4b6a3/uuid-creator) v1.4.5 using JMH v1.23.

```text
-----------------------------------------------------------------------------------
THROUGHPUT (operations/millis)
-----------------------------------------------------------------------------------
Benchmark                                  Mode  Cnt      Score      Error   Units
-----------------------------------------------------------------------------------
Throughput.EAIO_TimeBasedWithMac          thrpt    5  19578,248 ±  504,220  ops/ms
Throughput.Java_Random                    thrpt    5   2055,962 ±   76,224  ops/ms
Throughput.UuidCreator_CombGuid           thrpt    5  18925,621 ±  484,156  ops/ms
Throughput.UuidCreator_FastRandom         thrpt    5  74038,367 ± 6004,510  ops/ms
Throughput.UuidCreator_NameBasedMd5       thrpt    5   3741,944 ±   70,026  ops/ms
Throughput.UuidCreator_NameBasedSha1      thrpt    5   2735,199 ±   13,666  ops/ms
Throughput.UuidCreator_Random             thrpt    5   2030,067 ±   39,618  ops/ms
Throughput.UuidCreator_Sequential         thrpt    5  20062,382 ±  297,605  ops/ms
Throughput.UuidCreator_SequentialWithMac  thrpt    5  18200,088 ±  637,603  ops/ms
Throughput.UuidCreator_TimeBased          thrpt    5  18152,895 ±  414,916  ops/ms
Throughput.UuidCreator_TimeBasedWithMac   thrpt    5  17286,595 ± 1369,154  ops/ms
Throughput.UuidCreator_UlidBasedGuid      thrpt    5  19202,047 ±  608,979  ops/ms
-----------------------------------------------------------------------------------
Total time: 00:12:04
-----------------------------------------------------------------------------------
```

```text
-----------------------------------------------------------------------------------
AVERAGE TIME (nanos/operation)
-----------------------------------------------------------------------------------
Benchmark                                  Mode  Cnt    Score   Error  Units
-----------------------------------------------------------------------------------
AverageTime.EAIO_TimeBasedWithMac          avgt    5   51,294 ± 1,341  ns/op
AverageTime.Java_Random                    avgt    5  493,111 ± 8,411  ns/op
AverageTime.UuidCreator_CombGuid           avgt    5   52,823 ± 1,889  ns/op
AverageTime.UuidCreator_FastRandom         avgt    5   13,397 ± 0,985  ns/op
AverageTime.UuidCreator_NameBasedMd5       avgt    5  271,170 ± 3,716  ns/op
AverageTime.UuidCreator_NameBasedSha1      avgt    5  364,245 ± 5,948  ns/op
AverageTime.UuidCreator_Random             avgt    5  496,775 ± 4,361  ns/op
AverageTime.UuidCreator_Sequential         avgt    5   54,790 ± 3,298  ns/op
AverageTime.UuidCreator_SequentialWithMac  avgt    5   54,584 ± 1,097  ns/op
AverageTime.UuidCreator_TimeBased          avgt    5   56,329 ± 3,442  ns/op
AverageTime.UuidCreator_TimeBasedWithMac   avgt    5   57,638 ± 3,312  ns/op
AverageTime.UuidCreator_UlidBasedGuid      avgt    5   52,298 ± 0,727  ns/op
-----------------------------------------------------------------------------------
Total time: 00:12:03
-----------------------------------------------------------------------------------
```
These external generators are used for comparison:

- com.eaio.uuid.UUID (for time-based UUID);
- java.util.UUID (for random UUID).

Benchmarks executed in a PC with Ubuntu 19.04, JVM 1.8.0_161, CPU Intel i5-3330 and 8GB RAM.

Links for generators
-------------------------------------------
* [UUID Creator](https://github.com/f4b6a3/uuid-creator)
* [Java Utils UUID Type and Generator](https://docs.oracle.com/javase/7/docs/api/java/util/UUID.html)
* [EAIO UUID Generator - Burkard (original)](https://johannburkard.de/software/uuid/)


