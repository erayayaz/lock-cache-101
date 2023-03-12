## Info
- Optimistic Locking, projedeki işlemlerin birbirlerini etkilemeden gerçekleşeceğine inanarak hareket eder, fakat Pessimistic Locking biraz şüpheci olacağından karamsar bir yapıdadır. Fakat deadlocklar ile karşılaşılabilir.
- Herhangi bir repository katmanında Lock anatasyonu kullanılacaksa ilgili serviste de aryıca @Transactional anatasyonu kullanılmalıdır.
- Optimistic Locking verileri versiyonlar (@Version anatasyonu ile). Pessimistic, locklar.
- Sonradan redis kullanılarak veriler getirilirken cache kullanılmıştır.

- Bu projede farklı lock mekanizmaları commentlidir. Conccurrencyi daha iyi görünebilmesi için alt satırda yer alan komut ile test edilebilir :)

- ab -n 100 -c 2 http://localhost:8080/customers/inc

## Requirements
- Java17
- PostgreSQL
- Redis

## DB
```shell
docker run --name postgres -e POSTGRES_PASSWORD=fresh -e POSTGRES_DB=lock -e POSTGRES_USER=postgres postgres
```
## RUN
```shell
./gradlew bootRun
```

## Benchmark
```shell
ab -n 100 -c 2 http://localhost:8080/customers/inc
```