-- 1
-- Необходимо написать один SQL запрос, возвращающий все транзакции клиента
-- "Иванов Иван Иванович" по картам с номерами "1234567890123451" и "1234567890123452"
-- совершенные за период с 01.01.2012 по 01.01.2015. Запрос должен вывести: номер карты,
-- дату совершения операции, сумму транзакции.

select Cardnumber, DATE_OF_TRANSACTION "Date", Summa  from Clients
  inner join  CARDS on  Cards.ClientId = Clients.ClientId
  inner join  Transactions on  cards.CardId = Transactions.CardId
  where FIO in 'Иванов Иван Иванович'
            and (Cardnumber = 1234567890123451 or Cardnumber = 1234567890123452)
            and (DATE_OF_TRANSACTION between '01.01.2012' and  '01.01.2015');
        -- условие даты может выдавать ошибку из-за настроек времени и среды разработки
        -- alter session set nls_date_format = 'DD.MM.YYYY HH24:MI';
-- 1 end

-- 2
-- Необходимо написать один SQL запрос, который вернет общую сумму всех транзакций с разбивкой
-- по каждой карте для клиента "Сидоров Сидор Сидорович" за весь период.
-- Запрос должен вывести: номер карты, общую сумму транзакций по карте.

select Cardnumber, sum (Summa) Summa   from Clients
  inner join  CARDS on  Cards.ClientId = Clients.ClientId
  inner join  Transactions on  cards.CardId = Transactions.CardId
  where FIO in 'Сидоров Сидор Сидорович'
  group by Cardnumber

-- 2 end

-- 3
-- Удалить ошибочную транзакцию по карте "1234567890123451" от "19.06.2012  15:13:13"

Delete (select * from Transactions
inner join  cards on Transactions.CardId = cards.CardId
where CardNumber in 1234567890123451 and
    DATE_OF_TRANSACTION in '19.06.2012 15:13');

-- 3 end

-- 4
-- Вставить новую транзакцию по карте "1234567890123411" на сумму 1000 с текущей датой

insert into transactions(CardId, DATE_OF_TRANSACTION,  Summa )
Select CardId, to_date ( sysdate), 1000
from Cards
where CardNumber in 1234567890123411;

-- 4 end

-- 5
-- Обновить поле FIO клиента с картой "1234567890123458" на "Смирнов Олег Петрович"

update Clients
set FIO = 'Смирнов Олег Петрович'
where FIO in (select FIO from Clients
where ClientId in (select ClientId from Cards
                where CardNumber in 1234567890123458 ));

-- 5 end
































