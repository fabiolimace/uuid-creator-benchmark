# UUID Creator Benchmark

This is a simple benchmark using JMH that compares [UUID Creator](https://github.com/f4b6a3/uuid-creator) to other UUID generators.

The table below shows the results for UUID Creator v0.9.5.

```text
---------------------------------------------------------------------------------
Benchmark                                       Mode  Cnt   Score   Error  Units
---------------------------------------------------------------------------------
BenchmarkRunner.EAIO_TimeBasedWithMac             ss  100   7,282 ±  0,691  ms/op
BenchmarkRunner.JUG_NameBased                     ss  100  40,858 ±  3,520  ms/op
BenchmarkRunner.JUG_Random                        ss  100  54,906 ±  4,317  ms/op
BenchmarkRunner.JUG_TimeBased                     ss  100   7,832 ±  0,917  ms/op
BenchmarkRunner.JUG_TimeBasedWithMAC              ss  100   7,692 ±  0,918  ms/op
BenchmarkRunner.Java_NameBased                    ss  100  53,126 ± 10,778  ms/op
BenchmarkRunner.Java_Random                       ss  100  55,164 ±  4,495  ms/op
BenchmarkRunner.UuidCreator_CombGuid              ss  100  48,176 ±  5,144  ms/op
BenchmarkRunner.UuidCreator_DceSecurity           ss  100   7,976 ±  1,181  ms/op
BenchmarkRunner.UuidCreator_DceSecurityWithMac    ss  100   7,961 ±  1,175  ms/op
BenchmarkRunner.UuidCreator_FastRandom            ss  100   3,294 ±  0,554  ms/op
BenchmarkRunner.UuidCreator_MssqlGuid             ss  100   8,055 ±  0,901  ms/op
BenchmarkRunner.UuidCreator_NameBasedMd5          ss  100  43,760 ±  4,619  ms/op
BenchmarkRunner.UuidCreator_NameBasedSha1         ss  100  52,222 ±  4,914  ms/op
BenchmarkRunner.UuidCreator_Random                ss  100  46,679 ±  2,731  ms/op
BenchmarkRunner.UuidCreator_Sequential            ss  100   7,300 ±  0,983  ms/op
BenchmarkRunner.UuidCreator_SequentialWithMac     ss  100   7,416 ±  1,017  ms/op
BenchmarkRunner.UuidCreator_TimeBased             ss  100   7,375 ±  1,016  ms/op
BenchmarkRunner.UuidCreator_TimeBasedWithMac      ss  100   7,550 ±  0,947  ms/op
---------------------------------------------------------------------------------
Total time: 00:01:51
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

