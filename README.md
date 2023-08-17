## Сервис доставки

Имеются 3 таблицы в базе данных `post_office`, `postal_delivery`, `history` 

1) Создать несколько почтовые отделения `/post/office` [example](http/postOfficeCreate.http)

2) Зарегестрировать доставку `/postal/delivery/registration` [example](http/registration.http)

3) Посылка выехала из пункта `/postal/delivery/intermediate/office/went` [example](http/went.http)

4) Посылка приехала в пункт `/postal/delivery/intermediate/office/come` [example](http/come.http)

5) Посылка получена адрессантом `/postal/delivery/received` [example](http/received.http)

6) История транзакций посылки `/history/all/{id}` [example](http/history.http)

7) Текущий статус посылки `/history/{id}` [example](http/history.http)



`docker compose up` - поднять бд для сервиса