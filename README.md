# UUID Creator Benchmark

This is a simple benchmark using JMH v1.21 that compares [UUID Creator](https://github.com/f4b6a3/uuid-creator) to other UUID generators.

The table below shows the results for UUID Creator v1.4.4.

```text
------------------------------------------------------------------------------
Benchmark                                   Mode   Cnt   Score   Error  Units
------------------------------------------------------------------------------
MyBenchmark.EAIO_TimeBasedWithMac             ss  1000   5,834 ± 0,092  ms/op
MyBenchmark.JUG_NameBasedMd5                  ss  1000  28,265 ± 0,229  ms/op
MyBenchmark.JUG_NameBasedSha1                 ss  1000  38,724 ± 0,254  ms/op
MyBenchmark.JUG_Random                        ss  1000  50,912 ± 0,264  ms/op
MyBenchmark.JUG_TimeBased                     ss  1000   9,225 ± 0,162  ms/op
MyBenchmark.JUG_TimeBasedWithMAC              ss  1000   9,237 ± 0,159  ms/op
MyBenchmark.Java_NameBased                    ss  1000  36,122 ± 0,367  ms/op
MyBenchmark.Java_Random                       ss  1000  50,832 ± 0,271  ms/op
MyBenchmark.UuidCreator_CombGuid              ss  1000   5,958 ± 0,105  ms/op
MyBenchmark.UuidCreator_DceSecurity           ss  1000   5,966 ± 0,107  ms/op
MyBenchmark.UuidCreator_DceSecurityWithMac    ss  1000   5,911 ± 0,109  ms/op
MyBenchmark.UuidCreator_FastRandom            ss  1000   1,916 ± 0,067  ms/op
MyBenchmark.UuidCreator_LexicalOrderGuid      ss  1000   5,742 ± 0,099  ms/op
MyBenchmark.UuidCreator_NameBasedMd5          ss  1000  27,564 ± 0,215  ms/op
MyBenchmark.UuidCreator_NameBasedSha1         ss  1000  37,800 ± 0,243  ms/op
MyBenchmark.UuidCreator_Random                ss  1000  50,594 ± 0,277  ms/op
MyBenchmark.UuidCreator_Sequential            ss  1000   5,385 ± 0,099  ms/op
MyBenchmark.UuidCreator_SequentialWithMac     ss  1000   5,397 ± 0,102  ms/op
MyBenchmark.UuidCreator_TimeBased             ss  1000   5,557 ± 0,102  ms/op
MyBenchmark.UuidCreator_TimeBasedWithMac      ss  1000   5,582 ± 0,106  ms/op
------------------------------------------------------------------------------
Total time: 00:07:37
------------------------------------------------------------------------------
```

This benchmark was executed in a machine with Ubuntu 19.04, JVM 1.8.0_161, processor Intel i5-3330 and 8GB RAM.

### Benchmark options

```java
@Threads(1)
@State(Scope.Thread)
@Warmup(iterations = 10, batchSize = 100_000)
@Measurement(iterations = 200, batchSize = 100_000)
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

