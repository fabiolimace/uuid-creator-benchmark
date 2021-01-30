# UUID Creator Benchmark

This file shows benchmarks using JMH v1.25.2.

```text
==================================================================================
THROUGHPUT (operations/msec)               Mode  Cnt      Score     Error   Units
==================================================================================
Throughput.JDK01_toString                 thrpt    5   2915,524 ±  86,400  ops/ms
Throughput.JDK02_fromString               thrpt    5   1938,784 ±  88,818  ops/ms
Throughput.JDK03_RandomBased              thrpt    5   2050,995 ±  21,636  ops/ms
Throughput.JDK04_NameBasedMd5             thrpt    5   2809,598 ±  73,894  ops/ms
----------------------------------------------------------------------------------
Throughput.TsidCreator01_Tsid256          thrpt    5  16075,867 ± 274,681  ops/ms
Throughput.TsidCreator02_Tsid1024         thrpt    5   4093,735 ±   0,272  ops/ms
Throughput.TsidCreator03_Tsid4096         thrpt    5   1024,009 ±   0,252  ops/ms
Throughput.TsidCreator04_Tsid256String    thrpt    5  15379,666 ± 167,178  ops/ms
Throughput.TsidCreator05_Tsid1024String   thrpt    5   4076,510 ±   2,437  ops/ms
Throughput.TsidCreator06_Tsid4096String   thrpt    5   1023,653 ±   0,379  ops/ms
----------------------------------------------------------------------------------
Throughput.UlidCreator01_toString         thrpt    5  29487,382 ± 627,808  ops/ms
Throughput.UlidCreator02_fromString       thrpt    5  21194,263 ± 706,398  ops/ms
Throughput.UlidCreator03_Ulid             thrpt    5   2745,123 ±  41,326  ops/ms
Throughput.UlidCreator04_MonotonicUlid    thrpt    5  19542,344 ± 423,271  ops/ms
----------------------------------------------------------------------------------
Throughput.UuidCreator01_toString         thrpt    5  20940,350 ± 244,373  ops/ms
Throughput.UuidCreator02_fromString       thrpt    5  10229,685 ± 286,160  ops/ms
Throughput.UuidCreator03_RandomBased      thrpt    5   2017,299 ±  23,892  ops/ms
Throughput.UuidCreator04_PrefixComb       thrpt    5   2665,831 ±  49,381  ops/ms
Throughput.UuidCreator05_ShortPrefixComb  thrpt    5   2082,030 ±  19,635  ops/ms
Throughput.UuidCreator06_NameBasedMd5     thrpt    5   2847,436 ±  56,548  ops/ms
Throughput.UuidCreator07_NameBasedSha1    thrpt    5   2155,267 ±  48,075  ops/ms
Throughput.UuidCreator08_TimeBased        thrpt    5   9892,718 ±  38,906  ops/ms
Throughput.UuidCreator09_TimeOrdered      thrpt    5   9898,455 ±  24,376  ops/ms
==================================================================================
Total time: 00:30:40
==================================================================================
```

How to run the benchmark on command line:

```bash
mvn clean install
```

Benchmarks executed in a PC with JDK 8, Ubuntu 20.04, CPU Intel i5-3330 and 8GB RAM.

Links for generators
-------------------------------------------
* [UUID Creator](https://github.com/f4b6a3/uuid-creator)
* [ULID Creator](https://github.com/f4b6a3/ulid-creator)
* [TSID Creator](https://github.com/f4b6a3/tsid-creator)

