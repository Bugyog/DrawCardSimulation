### Симулятор поиска оружия в колоде для Arkham Horror LCG

## Описание алгоритма симуляции

1. Создаётся колода, состоящая из карт оружия, поисковых карт и всех остальных карт. Размер колоды указывается в конфиге. На данном этапе слабости в колоду не добавляется.
2. Набирается стартовая рука. На стартовой руке оставляем не более указанных в конфиге карт на поиск, среди остальных заменяем до трёх карт. Предполагаем, что остальные карты нам нужны, и менять мы их не хотим.
3. После набора стартовой руки в колоду добавляются слабости, и она перемешивается.
4. Если после набора стартовой руки оружия в руке нет, далее запускается симуляция игры по раундам:
  1. Если на руке есть карта на поиск, играем наивысшую из них по приоритету.
  2. Если карт на поиск нет, просто тянем одну карту.
  3. Тянем ещё одну карту в фазе передышки.
  4. Проверяем руку на предмет наличия оружия. Если оружие нашлось, симуляция останавливается.
5. Повторяем симуляцию указанное количество раз.
6. Выдаём в консоль результат симуляции в виде таблицы, каждая строчка которой имеет формат: X - YY.YY, где X - номер раунда, в котором нашлось оружие, YY.YY - шанс получения оружия не позднее указанного раунда. X равный 0 означает, что оружие нашлось на стартовой руке.

## Параметры конфигурации

Конфигурация предоставлена файлом Configuration.java, параметры:

 - ITERATIONS - количество повторов, которое делает симуляция. Чем число больше, тем меньше флуктуация результатов
 - DECK_SIZE - размер колоды с учётом персональных карт и слабостей
 - START_HAND_SIZE - размер стартовой руки
 - REPLACE_QUANTITY - максимальное количество карт, которые можно заменить при наборе стартовой руки без учёта слабостей
 - MAX_SEARCHING_CARDS_ON_START_HAND - максимальное количество карт на поиск, которые мы оставляем на стартовой руке
 - WEAPONS - количество карт оружия в колоде
 - BACKPACKS - количество карт "Рюкзак" уровня 0
 - PREPARED_FOR_THE_WORSTS - количество карт "Готовность к худшему", уровень не имеет значения
 - UPGRADED_BACKPACKS - количество карт "Рюкзак" уровня 2
 - WEAKNESSES - количество слабостей в колоде

## Ограничения

Алгоритм не учитывает слабости вида "Башня", которые нельзя заменить, и нестандартных сыщиков, у которых особые правила замены карт.
Также не предусмотрена валидация параметров конфигурации, можно задать что угодно, даже если это противоречит правилам игры.