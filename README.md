# UUID Creator Benchmark

This is a simple benchmark using JMH v1.21 that compares [UUID Creator](https://github.com/f4b6a3/uuid-creator) to other UUID generators.

The table below shows the results for UUID Creator v1.4.5.

```text
------------------------------------------------------------------------------
Benchmark                                   Mode   Cnt   Score   Error  Units
------------------------------------------------------------------------------
MyBenchmark.EAIO_TimeBasedWithMac             ss  1000   5,683 ± 0,093  ms/op
MyBenchmark.JUG_NameBasedMd5                  ss  1000  26,724 ± 0,224  ms/op
MyBenchmark.JUG_NameBasedSha1                 ss  1000  35,422 ± 0,264  ms/op
MyBenchmark.JUG_Random                        ss  1000  48,340 ± 0,281  ms/op
MyBenchmark.JUG_TimeBased                     ss  1000   9,298 ± 0,144  ms/op
MyBenchmark.JUG_TimeBasedWithMAC              ss  1000   9,309 ± 0,143  ms/op
MyBenchmark.Java_NameBased                    ss  1000  35,493 ± 0,378  ms/op
MyBenchmark.Java_Random                       ss  1000  47,729 ± 0,280  ms/op
MyBenchmark.UuidCreator_CombGuid              ss  1000   5,785 ± 0,108  ms/op
MyBenchmark.UuidCreator_DceSecurity           ss  1000   5,674 ± 0,099  ms/op
MyBenchmark.UuidCreator_DceSecurityWithMac    ss  1000   5,700 ± 0,108  ms/op
MyBenchmark.UuidCreator_FastRandom            ss  1000   1,911 ± 0,070  ms/op
MyBenchmark.UuidCreator_NameBasedMd5          ss  1000  25,382 ± 0,199  ms/op
MyBenchmark.UuidCreator_NameBasedSha1         ss  1000  34,729 ± 0,249  ms/op
MyBenchmark.UuidCreator_Random                ss  1000  47,792 ± 0,273  ms/op
MyBenchmark.UuidCreator_Sequential            ss  1000   5,279 ± 0,104  ms/op
MyBenchmark.UuidCreator_SequentialWithMac     ss  1000   5,245 ± 0,102  ms/op
MyBenchmark.UuidCreator_TimeBased             ss  1000   5,381 ± 0,105  ms/op
MyBenchmark.UuidCreator_TimeBasedWithMac      ss  1000   5,396 ± 0,104  ms/op
MyBenchmark.UuidCreator_UlidBasedGuid         ss  1000   5,613 ± 0,101  ms/op
------------------------------------------------------------------------------
Total time: 00:07:16
------------------------------------------------------------------------------
```

Command executed on bash:

```bash
java -jar path/to/uuid-creator-benchmark/target/benchmarks.jar 1> /tmp/benchmark.txt 2> /dev/null;
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

