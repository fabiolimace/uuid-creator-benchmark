# UUID Creator Benchmark

This is a simple benchmark using JMH that compares [UUID Creator](https://github.com/f4b6a3/uuid-creator) to other UUID generators.

The table below shows the results for UUID Creator v1.3.5.

```text
---------------------------------------------------------------------------------
Benchmark                                       Mode  Cnt   Score   Error  Units
---------------------------------------------------------------------------------
BenchmarkRunner.EaioTimeBasedWithMac_ _ _ _ _ _  ss  100   6,451 ± 0,401  ms/op
BenchmarkRunner.JavaNameBased                    ss  100  41,219 ± 2,226  ms/op
BenchmarkRunner.JavaRandom_ _ _ _ _ _ _ _ _ _ _  ss  100  50,673 ± 1,050  ms/op
BenchmarkRunner.JugNameBased                     ss  100  37,119 ± 0,977  ms/op
BenchmarkRunner.JugRandom                        ss  100  51,056 ± 0,989  ms/op
BenchmarkRunner.JugTimeBased                     ss  100   6,922 ± 0,484  ms/op
BenchmarkRunner.JugTimeBasedWithMAC_ _ _ _ _ _ _ ss  100   6,871 ± 0,453  ms/op
BenchmarkRunner.UuidCreatorCombGuid              ss  100  35,288 ± 1,078  ms/op
BenchmarkRunner.UuidCreatorDceSecurity           ss  100   7,005 ± 0,464  ms/op
BenchmarkRunner.UuidCreatorDceSecurityWithMac    ss  100   6,849 ± 0,458  ms/op
BenchmarkRunner.UuidCreatorFastRandom            ss  100   2,402 ± 0,375  ms/op
BenchmarkRunner.UuidCreatorLexicalOrderGuid      ss  100   6,708 ± 0,447  ms/op
BenchmarkRunner.UuidCreatorMssqlGuid             ss  100   7,112 ± 0,442  ms/op
BenchmarkRunner.UuidCreatorNameBasedMd5          ss  100  36,083 ± 1,251  ms/op
BenchmarkRunner.UuidCreatorNameBasedSha1         ss  100  44,977 ± 1,343  ms/op
BenchmarkRunner.UuidCreatorNameBasedSha256       ss  100  63,744 ± 0,998  ms/op
BenchmarkRunner.UuidCreatorRandom                ss  100  50,518 ± 0,864  ms/op
BenchmarkRunner.UuidCreatorSequential            ss  100   6,447 ± 0,425  ms/op
BenchmarkRunner.UuidCreatorSequentialWithMac     ss  100   6,439 ± 0,462  ms/op
BenchmarkRunner.UuidCreatorTimeBased             ss  100   6,526 ± 0,432  ms/op
BenchmarkRunner.UuidCreatorTimeBasedWithMac      ss  100   6,471 ± 0,426  ms/op
---------------------------------------------------------------------------------
Total time: 00:02:15
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

