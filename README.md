# UUID Creator Benchmark

This is a simple benchmark using JMH v1.21 that compares [UUID Creator](https://github.com/f4b6a3/uuid-creator) to other UUID generators.

The table below shows the results for UUID Creator v1.4.2.

```text
-----------------------------------------------------------------------------
Benchmark                                   Mode  Cnt   Score   Error  Units
-----------------------------------------------------------------------------
MyBenchmark.EAIO_TimeBasedWithMac             ss  100   6,058 ± 0,352  ms/op
MyBenchmark.JUG_NameBasedMd5                  ss  100  28,850 ± 0,755  ms/op
MyBenchmark.JUG_NameBasedSha1                 ss  100  38,534 ± 0,872  ms/op
MyBenchmark.JUG_Random                        ss  100  51,553 ± 1,052  ms/op
MyBenchmark.JUG_TimeBased                     ss  100   6,030 ± 0,326  ms/op
MyBenchmark.JUG_TimeBasedWithMAC              ss  100   6,119 ± 0,452  ms/op
MyBenchmark.Java_NameBased                    ss  100  38,353 ± 1,839  ms/op
MyBenchmark.Java_Random                       ss  100  51,130 ± 0,899  ms/op
MyBenchmark.UuidCreator_CombGuid              ss  100   6,311 ± 0,409  ms/op
MyBenchmark.UuidCreator_DceSecurity           ss  100   6,223 ± 0,357  ms/op
MyBenchmark.UuidCreator_DceSecurityWithMac    ss  100   6,208 ± 0,359  ms/op
MyBenchmark.UuidCreator_FastRandom            ss  100   1,757 ± 0,216  ms/op
MyBenchmark.UuidCreator_LexicalOrderGuid      ss  100   6,271 ± 0,405  ms/op
MyBenchmark.UuidCreator_NameBasedMd5          ss  100  27,769 ± 0,654  ms/op
MyBenchmark.UuidCreator_NameBasedSha1         ss  100  38,242 ± 0,854  ms/op
MyBenchmark.UuidCreator_Random                ss  100  50,743 ± 0,961  ms/op
MyBenchmark.UuidCreator_Sequential            ss  100   5,641 ± 0,367  ms/op
MyBenchmark.UuidCreator_SequentialWithMac     ss  100   5,806 ± 0,383  ms/op
MyBenchmark.UuidCreator_TimeBased             ss  100   5,773 ± 0,381  ms/op
MyBenchmark.UuidCreator_TimeBasedWithMac      ss  100   5,613 ± 0,338  ms/op
-----------------------------------------------------------------------------
Total time: 00:01:35
-----------------------------------------------------------------------------
```

This benchmark was executed in a machine Ubuntu 19.04, processor Intel i5-3330 and 8GB RAM.

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

