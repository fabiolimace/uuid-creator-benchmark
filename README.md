# UUID Creator Benchmark

This is a simple benchmark using JMH that compares [UUID Creator](https://github.com/f4b6a3/uuid-creator) to other UUID generators.

The table below shows the results for UUID Creator v1.2.8.

```text
---------------------------------------------------------------------------------
Benchmark                                       Mode  Cnt   Score   Error  Units
---------------------------------------------------------------------------------
BenchmarkRunner.EaioTimeBasedWithMac             ss  100   6,946 ± 0,533  ms/op
BenchmarkRunner.JavaNameBased                    ss  100  52,486 ± 9,778  ms/op
BenchmarkRunner.JavaRandom                       ss  100  54,846 ± 4,672  ms/op
BenchmarkRunner.JugNameBased                     ss  100  39,635 ± 3,455  ms/op
BenchmarkRunner.JugRandom                        ss  100  55,042 ± 4,761  ms/op
BenchmarkRunner.JugTimeBased                     ss  100   7,815 ± 0,970  ms/op
BenchmarkRunner.JugTimeBasedWithMAC              ss  100   7,827 ± 0,951  ms/op
BenchmarkRunner.UuidCreatorCombGuid              ss  100  48,273 ± 4,948  ms/op
BenchmarkRunner.UuidCreatorDceSecurity           ss  100   8,101 ± 1,327  ms/op
BenchmarkRunner.UuidCreatorDceSecurityWithMac    ss  100   8,358 ± 1,333  ms/op
BenchmarkRunner.UuidCreatorFastRandom            ss  100   2,973 ± 0,540  ms/op
BenchmarkRunner.UuidCreatorMssqlGuid             ss  100   8,111 ± 0,967  ms/op
BenchmarkRunner.UuidCreatorNameBasedMd5          ss  100  42,855 ± 3,826  ms/op
BenchmarkRunner.UuidCreatorNameBasedSha1         ss  100  52,575 ± 4,795  ms/op
BenchmarkRunner.UuidCreatorNameBasedSha256       ss  100  71,507 ± 3,846  ms/op
BenchmarkRunner.UuidCreatorRandom                ss  100  45,711 ± 2,752  ms/op
BenchmarkRunner.UuidCreatorSequential            ss  100   7,406 ± 0,995  ms/op
BenchmarkRunner.UuidCreatorSequentialWithMac     ss  100   7,526 ± 1,056  ms/op
BenchmarkRunner.UuidCreatorTimeBased             ss  100   7,568 ± 1,026  ms/op
BenchmarkRunner.UuidCreatorTimeBasedWithMac      ss  100   7,591 ± 0,995  ms/op
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

