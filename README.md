# UUID Creator Benchmark

This is a simple benchmark using JMH that compares [UUID Creator](https://github.com/f4b6a3/uuid-creator) to other UUID generators.

The table below shows the results for UUID Creator v0.9.8.

```text
---------------------------------------------------------------------------------
Benchmark                                       Mode  Cnt   Score   Error  Units
---------------------------------------------------------------------------------
Benchmark                                       Mode  Cnt   Score   Error  Units
BenchmarkRunner.EAIO_TimeBasedWithMac             ss  100   6,960 ± 0,599  ms/op
BenchmarkRunner.JUG_NameBased                     ss  100  40,234 ± 3,409  ms/op
BenchmarkRunner.JUG_Random                        ss  100  54,829 ± 4,449  ms/op
BenchmarkRunner.JUG_TimeBased                     ss  100   7,719 ± 0,916  ms/op
BenchmarkRunner.JUG_TimeBasedWithMAC              ss  100   7,658 ± 0,947  ms/op
BenchmarkRunner.Java_NameBased                    ss  100  51,298 ± 8,535  ms/op
BenchmarkRunner.Java_Random                       ss  100  54,596 ± 4,349  ms/op
BenchmarkRunner.UuidCreator_CombGuid              ss  100  49,012 ± 4,834  ms/op
BenchmarkRunner.UuidCreator_DceSecurity           ss  100   7,955 ± 1,212  ms/op
BenchmarkRunner.UuidCreator_DceSecurityWithMac    ss  100   7,960 ± 1,134  ms/op
BenchmarkRunner.UuidCreator_FastRandom            ss  100   3,184 ± 0,591  ms/op
BenchmarkRunner.UuidCreator_MssqlGuid             ss  100   7,653 ± 0,935  ms/op
BenchmarkRunner.UuidCreator_NameBasedMd5          ss  100  43,577 ± 4,424  ms/op
BenchmarkRunner.UuidCreator_NameBasedSha1         ss  100  52,338 ± 4,488  ms/op
BenchmarkRunner.UuidCreator_NameBasedSha256       ss  100  71,916 ± 4,108  ms/op
BenchmarkRunner.UuidCreator_Random                ss  100  46,137 ± 2,364  ms/op
BenchmarkRunner.UuidCreator_Sequential            ss  100   6,988 ± 0,943  ms/op
BenchmarkRunner.UuidCreator_SequentialWithMac     ss  100   6,995 ± 0,928  ms/op
BenchmarkRunner.UuidCreator_TimeBased             ss  100   7,254 ± 0,925  ms/op
BenchmarkRunner.UuidCreator_TimeBasedWithMac      ss  100   7,235 ± 0,921  ms/op
---------------------------------------------------------------------------------
Total time: 00:02:02
---------------------------------------------------------------------------------
```

This benchmark was executed in a machine Intel i5-3330 with 8GB RAM.

Links for generators
-------------------------------------------
* [UUID Creator](https://github.com/f4b6a3/uuid-creator)
* [Java Utils UUID Type and Generator](https://docs.oracle.com/javase/7/docs/api/java/util/UUID.html)
* [Java UUID Generator (JUG)](https://github.com/cowtowncoder/java-uuid-generator)
* [EAIO UUID Generator - Connolly (fork)](http://stephenc.github.io/eaio-uuid/)
* [EAIO UUID Generator - Burkard (original)](https://johannburkard.de/software/uuid/)

