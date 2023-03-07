# Pessimistic Locking & Optimistic Locking

*Optimistic Locking, projedeki işlemlerin birbirlerini etkilemeden gerçekleşeceğine inanarak hareket eder, fakat Pessimistic Locking
biraz şüpheci olacağından karamsar bir yapıdadır. Fakat deadlocklar ile karşılaşılabilir.
*Herhangi bir repository katmanında Lock anatasyonu kullanılacaksa ilgili serviste de aryıca @Transactional anatasyonu kullanılmalıdır.
*Optimistic verileri versiyonlar (@Version anatasyonu ile), Pessimistic locklar.

*Bu projede farklı lock mekanizmaları comentlidir. Conccurrencyi daha iyi görünebilmesi için alt satırda yer alan komut ile test edilebilir :)

ab -n 100 -c 2 http://localhost:8080/customers/inc

Happy Coding :)
