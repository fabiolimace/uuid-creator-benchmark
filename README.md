# UUID Creator Benchmark

This is a simple benchmark using JMH that compares [UUID Creator](https://github.com/f4b6a3/uuid-creator) to other UUID generators.

The table below shows the results for UUID Creator v1.3.7.

```text
-----------------------------------------------------------------------------
Benchmark                                   Mode  Cnt   Score   Error  Units
-----------------------------------------------------------------------------
MyBenchmark.EAIO_TimeBasedWithMac             ss  200   5,653 ± 0,224  ms/op
MyBenchmark.JUG_NameBasedMd5                  ss  200  37,970 ± 1,380  ms/op
MyBenchmark.JUG_NameBasedSha1                 ss  200  46,836 ± 1,378  ms/op
MyBenchmark.JUG_Random                        ss  200  49,320 ± 0,697  ms/op
MyBenchmark.JUG_TimeBased                     ss  200   6,145 ± 0,303  ms/op
MyBenchmark.JUG_TimeBasedWithMAC              ss  200   5,915 ± 0,244  ms/op
MyBenchmark.Java_NameBased                    ss  200  47,809 ± 2,225  ms/op
MyBenchmark.Java_Random                       ss  200  49,110 ± 0,691  ms/op
MyBenchmark.UuidCreator_CombGuid              ss  200   5,444 ± 0,299  ms/op
MyBenchmark.UuidCreator_DceSecurity           ss  200   5,943 ± 0,256  ms/op
MyBenchmark.UuidCreator_DceSecurityWithMac    ss  200   6,125 ± 0,306  ms/op
MyBenchmark.UuidCreator_FastRandom            ss  200   1,979 ± 0,159  ms/op
MyBenchmark.UuidCreator_LexicalOrderGuid      ss  200   6,459 ± 0,315  ms/op
MyBenchmark.UuidCreator_MssqlGuid             ss  200   6,220 ± 0,273  ms/op
MyBenchmark.UuidCreator_NameBasedMd5          ss  200  37,952 ± 1,320  ms/op
MyBenchmark.UuidCreator_NameBasedSha1         ss  200  46,963 ± 1,473  ms/op
MyBenchmark.UuidCreator_NameBasedSha256       ss  200  64,943 ± 1,161  ms/op
MyBenchmark.UuidCreator_Random                ss  200  49,174 ± 0,667  ms/op
MyBenchmark.UuidCreator_Sequential            ss  200   5,709 ± 0,293  ms/op
MyBenchmark.UuidCreator_SequentialWithMac     ss  200   5,841 ± 0,320  ms/op
MyBenchmark.UuidCreator_TimeBased             ss  200   5,710 ± 0,287  ms/op
MyBenchmark.UuidCreator_TimeBasedWithMac      ss  200   5,746 ± 0,283  ms/op
-----------------------------------------------------------------------------
Total time: 00:03:55
-----------------------------------------------------------------------------
```

This benchmark was executed in a machine Ubuntu 18.04, processor Intel i5-3330 and 8GB RAM.

### Benchmark options

```java
@Threads(1)
@State(Scope.Thread)
@Warmup(iterations = 10, batchSize = 100_000)
@Measurement(iterations = 20, batchSize = 100_000)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
```

Links for generators
-------------------------------------------
* [UUID Creator](https://github.com/f4b6a3/uuid-creator)
* [Java Utils UUID Type and Generator](https://docs.oracle.com/javase/7/docs/api/java/util/UUID.html)
* [Java UUID Generator (JUG)](https://github.com/cowtowncoder/java-uuid-generator)
* [EAIO UUID Generator - Connolly (fork)](http://stephenc.github.io/eaio-uuid/)
* [EAIO UUID Generator - Burkard (original)](https://johannburkard.de/software/uuid/)

