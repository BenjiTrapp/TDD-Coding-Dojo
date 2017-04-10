# src.de.benjitrapp.fizzbuzz_tdd_kata.src.FizzBuzz TDD-Kata

## Über diese Kata
Diese Kata wurde bei der "agile2008" durch Michael Feathers und Emily Bache vorgeführt 
während des Vortrags "Programming wih the Stars". Damals war diese Kata zeitlich
auf 4 Minuten Limitiert. Zum Einsatz kam damals die Sprache Python. Diese Kata
wird heute noch sehr gerne in Rahmen von Einstellungstests eingesetzt und erhält
dadurch eine gewisse Brisanz.

## Problembeschreibung
Man stelle sich vor, man wird in der Zeit zurückversetzt und ist wieder ein
11 Jahre altes Kind. Fünf Minuten vor dem Ende der Stunde entscheidet sich 
der Mathematik Lehrer dazu, durch die Einführung eines Spiels, seinen Unterricht 
mit etwas "Spaß" zu bereichern. Er erklärt, dass er von Schüler zu Schüler
gehen wird und der Reihe nach diesen Schüler nach einer Zahl befragen wird, 
angefangen bei der Zahl eins.

Der "spaßige" Teil des Spiels besteht darin, immer wenn eine Zahl durch
drei teilbar ist, soll anstelle der Zahl das Wort "Fizz" und wenn die
Zahl durch fünf teilbar ist das Wort "Buzz" gesagt werden.

Nach der Erklärung geht der Lehrer in der Klasse umher und Zeigt auf dich
und deine Klassenkameraden. Die Klassenkameraden rufen "1", "2", "Fizz", "4",
"Buzz" ... bis er gezielt auf dich zeigt. Die Zeit beginnt stehen zu 
bleiben, der Mund wird trocken, die Hände beginnen zu schwitzen und du schaffst es 
gerade noch rechtzeitig ein "Fizz" herauszubringen. Dies ist gerade noch einmal
gut gegangen und der Lehrer zieht ohne eine Blamage vor der Klasse weiter.

Um zukünftig eine Blamage vor der Klasse zu vermeiden, möchtest du die gesamte Liste
ausgedruckt vor dir liegen haben, um immer genau zu wissen was du sagen
musst. Deine Klasse hat ca. 33 Schüler und der Lehrer wird voraussichtlich
drei Runden schaffen, bevor der Pausengong Erlösung bringt. Die nächste 
Mathe Stunde ist bereits morgen. Zeit mit dem Programmieren zu beginnen!

## Konkrete Aufgabenstellung
Schreibe ein Programm, das die Zahlen von 1 bis 100 ausgibt. Für Vielfache
von 3 soll das Wort "Fizz" ausgegeben werden und für Vielfache von 5 das 
Word "Buzz". Für Zahlen die ein Vielfaches von 3 und 5 sind, soll das Wort
"src.de.benjitrapp.fizzbuzz_tdd_kata.src.FizzBuzz" ausgegeben werden.

Um möglichst schnell eine robuste und gut getestete Implementation zu erlangen, 
empfiehlt sich der Einsatz von TDD resp. BabySteps im Einklang mit dem
"Rhythm of Test First" Ansatzes.

Beispielhafte Ausgabe:
``` java
1
2
Fizz
4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
src.de.benjitrapp.fizzbuzz_tdd_kata.src.FizzBuzz
16
17
Fizz
19
Buzz
... 
```


## Erweiterung der Aufgabenstellung

* Für eine Zahl wird "fizz" ausgegeben, wenn sie durch 3 teilbar ist oder eine 3 enthält
* Für eine Zahl wird "buzz" ausgegeben, wenn sie durch 5 teilbar ist oder eine 5 enthält

**TIPP**: Hierbei empfiehlt sich der Einsatz von 
[Predicates](http://howtodoinjava.com/java-8/how-to-use-predicate-in-java-8/) (Java 8) 
, um die "src.de.benjitrapp.fizzbuzz_tdd_kata.src.FizzBuzz"-Logik sauber, kurz und prägnant sowie erweiterbar zu gestalten. Wenn 
zuvor mittels TTD / BabySteps vorgegangen wurde, sollte ein Refactoring keine große Hürde 
darstellen.