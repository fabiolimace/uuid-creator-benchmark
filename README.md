# UUID Creator Benchmark

This is a simple benchmark using JMH that compares [UUID Creator](https://github.com/f4b6a3/uuid-creator) to other UUID generators.

The table below shows the results for UUID Creator v1.3.6.

```text
---------------------------------------------------------------------------------
Benchmark                                       Mode  Cnt   Score   Error  Units
---------------------------------------------------------------------------------
BenchmarkRunner.EaioTimeBasedWithMac _ _ _ _ _ _ ss  100   6,744 ± 0,420  ms/op
BenchmarkRunner.JavaNameBased                    ss  100  41,785 ± 2,062  ms/op
BenchmarkRunner.JavaRandom _ _ _ _ _ _ _ _ _ _ _ ss  100  49,404 ± 0,946  ms/op
BenchmarkRunner.JugNameBased                     ss  100  36,921 ± 0,970  ms/op
BenchmarkRunner.JugRandom                        ss  100  49,867 ± 0,928  ms/op
BenchmarkRunner.JugTimeBased                     ss  100   6,943 ± 0,485  ms/op
BenchmarkRunner.JugTimeBasedWithMAC_ _ _ _ _ _ _ ss  100   6,861 ± 0,472  ms/op
BenchmarkRunner.UuidCreatorCombGuid              ss  100   5,683 ± 0,430  ms/op
BenchmarkRunner.UuidCreatorDceSecurity           ss  100   6,852 ± 0,437  ms/op
BenchmarkRunner.UuidCreatorDceSecurityWithMac    ss  100   6,857 ± 0,425  ms/op
BenchmarkRunner.UuidCreatorFastRandom            ss  100   2,293 ± 0,391  ms/op
BenchmarkRunner.UuidCreatorLexicalOrderGuid      ss  100   6,702 ± 0,426  ms/op
BenchmarkRunner.UuidCreatorMssqlGuid             ss  100   6,805 ± 0,431  ms/op
BenchmarkRunner.UuidCreatorNameBasedMd5          ss  100  36,315 ± 1,340  ms/op
BenchmarkRunner.UuidCreatorNameBasedSha1         ss  100  44,729 ± 1,355  ms/op
BenchmarkRunner.UuidCreatorNameBasedSha256       ss  100  64,010 ± 1,274  ms/op
BenchmarkRunner.UuidCreatorRandom                ss  100  50,076 ± 0,953  ms/op
BenchmarkRunner.UuidCreatorSequential            ss  100   6,150 ± 0,414  ms/op
BenchmarkRunner.UuidCreatorSequentialWithMac     ss  100   6,311 ± 0,427  ms/op
BenchmarkRunner.UuidCreatorTimeBased             ss  100   6,352 ± 0,411  ms/op
BenchmarkRunner.UuidCreatorTimeBasedWithMac      ss  100   6,336 ± 0,422  ms/op
---------------------------------------------------------------------------------
Total time: 00:02:10
---------------------------------------------------------------------------------
```

This benchmark was executed in a machine Ubuntu 18.04, processor Intel i5-3330 and 8GB RAM.

### Benchmark options

The benchmark executes 10 iterations of 100 thousand operations. Before these iterations it executes 2 warm-up iterations of 100 thousand operations. These are the options used:

```java
@State(Scope.Thread)
@Warmup(iterations = 2, batchSize = 100_000)
@Measurement(iterations = 10, batchSize = 100_000)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
```

**Note:** the benchmark options was wrong before the uuid-creator v1.3.5. Before this version the benchmark used 1 warm-up iteration of 1 thousand operations. Now it uses 2 warm-up iterations of 100 thousand operations. The results changed a lot after this correction.

Links for generators
-------------------------------------------
* [UUID Creator](https://github.com/f4b6a3/uuid-creator)
* [Java Utils UUID Type and Generator](https://docs.oracle.com/javase/7/docs/api/java/util/UUID.html)
* [Java UUID Generator (JUG)](https://github.com/cowtowncoder/java-uuid-generator)
* [EAIO UUID Generator - Connolly (fork)](http://stephenc.github.io/eaio-uuid/)
* [EAIO UUID Generator - Burkard (original)](https://johannburkard.de/software/uuid/)

