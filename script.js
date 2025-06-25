// --- 1. QUIZ DATA: PERSONALIZZA QUI LE TUE DOMANDE E RISPOSTE ---
const questions = [
    {
        question: "Quale delle seguenti è la sintassi corretta per dichiarare la classe MyClass come non ereditabile?",
        options: ["abstract class MyClass {}", "final class MyClass {}", "static class MyClass {}", "private class MyClass {}"],
        answer: "final class MyClass {}",
        explanation: "La parola chiave 'final' impedisce l'ereditarietà di una classe. Una classe 'abstract' non può essere istanziata direttamente ma può essere ereditata. 'static' non si applica alle classi di primo livello in questo modo. 'private' rende la classe accessibile solo all'interno della stessa unità di compilazione, ma non ne impedisce l'ereditarietà se accessibile."
    },
    {
        question: "Qual è l'output del seguente codice?\n```java\npublic class Test {\n    public static void main(String[] args) {\n        String s = \"Java\";\n        s.concat(\" is fun\");\n        System.out.println(s);\n    }\n}\n```",
        options: ["Java", "Java is fun", "Javais fun", "Errore di compilazione"],
        answer: "Java",
        explanation: "Il metodo `concat()` delle stringhe in Java crea una *nuova* stringa e la restituisce, ma non modifica l'oggetto `String` originale poiché le stringhe sono immutabili. La variabile `s` continua a puntare alla stringa originale 'Java'."
    },
    {
        question: "Quale operatore viene utilizzato per verificare l'uguaglianza di due valori in Java?",
        options: ["=", "==", "!=", "==="],
        answer: "==",
        explanation: "L'operatore `==` viene utilizzato per confrontare i valori dei tipi primitivi e i riferimenti degli oggetti. L'operatore `=` è per l'assegnazione. `!=` è per la disuguaglianza. `===` non esiste in Java (è di JavaScript)."
    },
    {
        question: "Quale dei seguenti non è un tipo di dato primitivo in Java?",
        options: ["int", "char", "String", "boolean"],
        answer: "String",
        explanation: "`String` è una classe in Java, non un tipo di dato primitivo. I tipi di dato primitivi includono `byte`, `short`, `int`, `long`, `float`, `double`, `boolean`, `char`."
    },
    {
        question: "Quale parola chiave viene utilizzata per implementare l'ereditarietà di classi in Java?",
        options: ["implements", "extends", "inherits", "uses"],
        answer: "extends",
        explanation: "`extends` è usato per l'ereditarietà tra classi. `implements` è usato per implementare interfacce."
    },
    {
        question: "In Java, un metodo può essere sovraccaricato (overloaded) se...",
        options: ["Ha lo stesso nome ma un diverso tipo di ritorno.", "Ha lo stesso nome e lo stesso tipo di ritorno.", "Ha lo stesso nome ma una diversa lista di parametri (numero, tipo o ordine).", "Ha un nome diverso."],
        answer: "Ha lo stesso nome ma una diversa lista di parametri (numero, tipo o ordine).",
        explanation: "L'overloading dei metodi si basa sulla 'firma' del metodo, che include il nome del metodo e la lista dei parametri (numero, tipo e ordine). Il tipo di ritorno può essere uguale o diverso, ma non è sufficiente per l'overloading da solo."
    },
    {
        question: "Quale dei seguenti è il modificatore di accesso più restrittivo?",
        options: ["public", "protected", "private", "default (package-private)"],
        answer: "private",
        explanation: "I membri `private` sono accessibili solo all'interno della classe in cui sono dichiarati. `default` (nessun modificatore) è visibile all'interno dello stesso package. `protected` è visibile all'interno dello stesso package e dalle sottoclassi. `public` è visibile ovunque."
    },
    {
        question: "Qual è il risultato dell'espressione 10 / 3 in Java, se entrambi sono int?",
        options: ["3.333...", "3", "4", "Errore di compilazione"],
        answer: "3",
        explanation: "La divisione tra interi in Java esegue una divisione intera, troncando la parte decimale. Quindi 10 diviso 3 intero fa 3."
    },
    {
        question: "Quale delle seguenti affermazioni è vera riguardo al costruttore di una classe Java?",
        options: ["Deve avere un tipo di ritorno.", "Non può essere sovraccaricato.", "Deve avere lo stesso nome della classe.", "Non può contenere la parola chiave this."],
        answer: "Deve avere lo stesso nome della classe.",
        explanation: "I costruttori non hanno un tipo di ritorno (nemmeno `void`). Possono essere sovraccaricati (avere firme diverse) e spesso usano la parola chiave `this` per riferirsi ad altri costruttori della stessa classe o ai membri dell'istanza corrente."
    },
    {
        question: "Qual è il blocco che viene sempre eseguito, indipendentemente dal fatto che si verifichi un'eccezione o meno?",
        options: ["try", "catch", "finally", "throws"],
        answer: "finally",
        explanation: "Il blocco `finally` è garantito per essere eseguito dopo il blocco `try` e `catch`, sia che un'eccezione venga sollevata e gestita, sia che non venga sollevata affatto. È usato per codice di pulizia (es. chiusura risorse)."
    },
    {
        question: "Qual è l'interfaccia radice nella gerarchia delle collezioni Java?",
        options: ["List", "Set", "Collection", "Map"],
        answer: "Collection",
        explanation: "`List`, `Set` e `Queue` estendono tutte l'interfaccia `Collection`. `Map` è una gerarchia separata e non estende `Collection`."
    },
    {
        question: "Quale delle seguenti è la dichiarazione corretta di un array di interi di dimensione 5?",
        options: ["int[] myArray = new int[5];", "int myArray[] = new int(5);", "int myArray[5];", "int[] myArray = new int[];"],
        answer: "int[] myArray = new int[5];",
        explanation: "La sintassi corretta per dichiarare e inizializzare un array di tipo `int` con dimensione 5 è `int[] myArray = new int[5];`. La posizione delle parentesi quadre può variare (`int myArray[]`), ma la parte `new int[5]` è fondamentale."
    },
    {
        question: "Quale parola chiave viene utilizzata per invocare il costruttore della superclasse?",
        options: ["this()", "super()", "parent()", "base()"],
        answer: "super()",
        explanation: "`super()` è usato per chiamare un costruttore della superclasse. `this()` è usato per chiamare un altro costruttore della stessa classe. `parent()` e `base()` non sono parole chiave Java per questo scopo."
    },
    {
        question: "Che cosa fa il metodo equals() di default per gli oggetti in Java (se non sovrascritto)?",
        options: ["Confronta il contenuto degli oggetti.", "Confronta i riferimenti agli oggetti.", "Confronta i valori hash degli oggetti.", "Genera un'eccezione."],
        answer: "Confronta i riferimenti agli oggetti.",
        explanation: "Per gli oggetti (non tipi primitivi), il metodo `equals()` definito nella classe base `Object` (e non sovrascritto dalle sottoclassi) confronta se due variabili si riferiscono allo stesso oggetto in memoria (cioè `obj1 == obj2`). Molte classi, come `String`, `Integer`, ecc., sovrascrivono `equals()` per confrontare il contenuto."
    },
    {
        question: "Qual è l'output del seguente codice?\n```java\npublic class LoopTest {\n    public static void main(String[] args) {\n        int count = 0;\n        for (int i = 0; i < 5; i++) {\n            count++;\n        }\n        System.out.println(count);\n    }\n}\n```",
        options: ["0", "4", "5", "Errore di compilazione"],
        answer: "5",
        explanation: "Il loop `for` esegue il suo corpo per `i` da 0 a 4 (quindi 5 iterazioni totali: 0, 1, 2, 3, 4). In ogni iterazione, `count` viene incrementato. Quindi `count` finirà per essere 5."
    },
    {
        question: "Quale delle seguenti affermazioni è vera riguardo alle classi abstract?",
        options: ["Possono essere istanziate direttamente.", "Non possono avere costruttori.", "Possono contenere metodi astratti e non astratti.", "Tutti i metodi in una classe astratta devono essere astratti."],
        answer: "Possono contenere metodi astratti e non astratti.",
        explanation: "Le classi astratte non possono essere istanziate direttamente, ma possono avere costruttori (chiamati dalle sottoclassi). Non tutti i metodi in una classe astratta devono essere astratti; possono contenere sia metodi astratti (senza implementazione) sia metodi concreti (con implementazione)."
    },
    {
        question: "Quale parola chiave viene utilizzata per dichiarare una costante in Java?",
        options: ["const", "final", "static", "immutable"],
        answer: "final",
        explanation: "In Java, la parola chiave `final` viene utilizzata per dichiarare costanti. Se applicata a una variabile, il suo valore non può essere riassegnato dopo l'inizializzazione. Se combinata con `static` e `public` (`public static final`), crea una costante di classe."
    },
    {
        question: "Qual è il valore predefinito di una variabile di istanza di tipo boolean se non inizializzata esplicitamente?",
        options: ["true", "false", "null", "Dipende dalla JVM"],
        answer: "false",
        explanation: "Le variabili di istanza (e le variabili statiche) in Java hanno valori predefiniti se non inizializzate esplicitamente. Per `boolean`, il valore predefinito è `false`. Le variabili locali (all'interno di un metodo) non hanno un valore predefinito e devono essere inizializzate prima dell'uso."
    },
    {
        question: "Quale delle seguenti è una valida firma del metodo main in Java?",
        options: ["public static void main(String args[])", "public void main(String[] args)", "static void main(String... args)", "public int main(String[] args)"],
        answer: "public static void main(String args[])",
        explanation: "La firma standard e più comune del metodo `main` è `public static void main(String[] args)`. La forma `String args[]` è equivalente a `String[] args`. Le opzioni che non includono `static` o hanno un tipo di ritorno diverso da `void` non sono valide per il punto di ingresso del programma."
    },
    {
        question: "Come si importa una classe Scanner dal package java.util?",
        options: ["import java.util.*;", "import java.util.Scanner;", "include java.util.Scanner;", "Sia A che B sono corrette."],
        answer: "Sia A che B sono corrette.",
        explanation: "`import java.util.Scanner;` importa specificamente la classe `Scanner`. `import java.util.*;` importa tutte le classi del package `java.util`. Entrambi i modi sono validi per rendere `Scanner` disponibile nel tuo codice."
    },
    {
        question: "Qual è l'output del seguente codice?\n```java\npublic class CastTest {\n    public static void main(String[] args) {\n        double d = 10.5;\n        int i = (int) d;\n        System.out.println(i);\n    }\n}\n```",
        options: ["10.5", "10", "11", "Errore di compilazione"],
        answer: "10",
        explanation: "Quando si effettua un casting da un tipo in virgola mobile (`double`) a un tipo intero (`int`), la parte decimale viene troncata (eliminata), non arrotondata. Quindi 10.5 diventa 10."
    },
    {
        question: "Quale dei seguenti non è un loop in Java?",
        options: ["for loop", "while loop", "do-while loop", "if-else loop"],
        answer: "if-else loop",
        explanation: "`for loop`, `while loop` e `do-while loop` sono strutture di controllo iterative (loop) in Java. `if-else` è una struttura di controllo condizionale, usata per eseguire blocchi di codice in base a una condizione, non per ripetere un'azione."
    },
    {
        question: "Qual è lo scopo della parola chiave this in Java?",
        options: ["Si riferisce all'istanza corrente della classe.", "Si riferisce alla superclasse.", "Si riferisce a una classe statica.", "Indica che un metodo non deve essere sovrascritto."],
        answer: "Si riferisce all'istanza corrente della classe.",
        explanation: "La parola chiave `this` si riferisce all'istanza corrente dell'oggetto su cui è stato invocato un metodo o un costruttore. È usata per disambiguare variabili di istanza e parametri, o per chiamare altri costruttori della stessa classe."
    },
    {
        question: "Cosa succede se un metodo astratto non viene implementato in una sottoclasse concreta?",
        options: ["Errore di runtime.", "La sottoclasse deve essere dichiarata abstract.", "Il metodo viene ignorato.", "Errore di compilazione se la sottoclasse non è astratta."],
        answer: "Errore di compilazione se la sottoclasse non è astratta.",
        explanation: "Se una sottoclasse eredita un metodo astratto da una superclasse astratta o da un'interfaccia, deve fornire un'implementazione concreta per quel metodo. Se non lo fa, la sottoclasse stessa deve essere dichiarata `abstract`, altrimenti si verificherà un errore di compilazione."
    },
    {
        question: "Quale metodo si usa per ottenere la lunghezza di una stringa in Java?",
        options: ["length()", "size()", "count()", "getLength()"],
        answer: "length()",
        explanation: "Il metodo `length()` (senza argomenti) viene utilizzato per ottenere il numero di caratteri in una stringa in Java. Per gli array, si usa la proprietà `length` (senza parentesi)."
    },
    {
        question: "Quale dei seguenti è un metodo della classe Object?",
        options: ["start()", "run()", "toString()", "main()"],
        answer: "toString()",
        explanation: "`toString()`, `equals()`, `hashCode()`, `getClass()` sono alcuni dei metodi ereditati da tutte le classi Java dalla classe `Object`, la radice della gerarchia delle classi. `start()` e `run()` sono metodi di `Thread` o `Runnable`, e `main()` è il punto di ingresso per le applicazioni."
    },
    {
        question: "Qual è l'output del seguente codice?\n```java\npublic class OperatorTest {\n    public static void main(String[] args) {\n        int x = 5;\n        System.out.println(x++ * 2);\n    }\n}\n```",
        options: ["10", "12", "5", "6"],
        answer: "10",
        explanation: "L'operatore `x++` è un operatore di post-incremento. Ciò significa che il valore di `x` (che è 5) viene *usato* nell'espressione (`5 * 2 = 10`) e *dopo* l'espressione, `x` viene incrementato a 6. Quindi l'output è 10."
    },
    {
        question: "Quale struttura dati memorizza elementi in ordine di inserimento e permette duplicati?",
        options: ["Set", "List", "Map", "Queue"],
        answer: "List",
        explanation: "L'interfaccia `List` (implementata da classi come `ArrayList` e `LinkedList`) garantisce l'ordine di inserimento degli elementi e permette la presenza di elementi duplicati. `Set` non permette duplicati. `Map` memorizza coppie chiave-valore. `Queue` segue un ordine FIFO."
    },
    {
        question: "Cosa rappresenta l'incapsulamento in OOP?",
        options: ["La capacità di una classe di ereditare da più classi.", "La capacità di un oggetto di assumere più forme.", "Il raggruppamento di dati e metodi che operano su quei dati all'interno di un'unica unità.", "La capacità di definire un comportamento generale che le sottoclassi possono implementare."],
        answer: "Il raggruppamento di dati e metodi che operano su quei dati all'interno di un'unica unità.",
        explanation: "L'incapsulamento è uno dei quattro principi fondamentali dell'OOP (insieme a ereditarietà, polimorfismo e astrazione). Si riferisce al meccanismo di legare insieme il codice e i dati che manipola, e di nascondere i dettagli interni dell'implementazione (data hiding) dall'esterno, esponendo solo un'interfaccia controllata."
    },
    {
        question: "Qual è il valore predefinito di una variabile di istanza di tipo numerico (es. int, double) se non inizializzata esplicitamente?",
        options: ["0 per int, 0.0 per double.", "null.", "NaN.", "Errore di compilazione."],
        answer: "0 per int, 0.0 per double.",
        explanation: "Le variabili di istanza (non locali) e statiche di tipo numerico in Java vengono inizializzate a zero per default (`0` per gli interi, `0.0` per i tipi in virgola mobile). `null` è il valore predefinito per i riferimenti a oggetti."
    },
    {
        question: "Quale dei seguenti è l'operatore logico 'AND'?",
        options: ["&", "&&", "||", "!"],
        answer: "&&",
        explanation: "`&&` è l'operatore logico AND 'short-circuit' (valutazione condizionale). Se la prima parte è falsa, non valuta la seconda. `&` è l'operatore AND bitwise o logico non short-circuit. `||` è l'OR logico e `!` è il NOT logico."
    },
    {
        question: "Qual è l'output del seguente codice?\n```java\npublic class IfElseTest {\n    public static void main(String[] args) {\n        int a = 10;\n        if (a > 5) {\n            System.out.print(\"Hello\");\n        } else {\n            System.out.print(\"World\");\n        }\n    }\n}\n```",
        options: ["Hello", "World", "Errore di compilazione", "Hello World"],
        answer: "Hello",
        explanation: "La condizione `a > 5` (10 > 5) è vera. Pertanto, il blocco di codice all'interno dell'`if` viene eseguito, stampando 'Hello'. Il blocco `else` viene ignorato."
    },
    {
        question: "Quale tipo di variabile è visibile solo all'interno del metodo o blocco in cui è dichiarata?",
        options: ["Variabile di istanza", "Variabile statica", "Variabile locale", "Variabile di classe"],
        answer: "Variabile locale",
        explanation: "Le variabili locali sono dichiarate all'interno di un metodo, un costruttore o un blocco di codice. Sono accessibili solo all'interno di quel blocco e il loro ciclo di vita è limitato a quell'ambito. Le variabili di istanza appartengono all'oggetto, le statiche/di classe alla classe."
    },
    {
        question: "Cosa accade se si tenta di accedere a un elemento di un array fuori dai suoi limiti (out of bounds)?",
        options: ["Errore di compilazione.", "ArrayIndexOutOfBoundsException.", "NullPointerException.", "Il programma termina silenziosamente."],
        answer: "ArrayIndexOutOfBoundsException.",
        explanation: "Se si tenta di accedere a un indice di un array che è fuori dal suo intervallo valido (cioè un indice negativo o un indice maggiore o uguale alla dimensione dell'array), Java lancia una `ArrayIndexOutOfBoundsException` a runtime. Non è un errore di compilazione in quanto l'indice può essere determinato solo a runtime."
    },
    {
        question: "Quale dei seguenti è il modo corretto per creare un oggetto della classe MyClass?",
        options: ["MyClass obj = new MyClass();", "MyClass obj = MyClass.create();", "new MyClass() obj;", "object obj = new MyClass();"],
        answer: "MyClass obj = new MyClass();",
        explanation: "Questa è la sintassi standard e corretta per creare un'istanza (oggetto) di una classe in Java: `NomeClasse nomeOggetto = new NomeClasse();`. L'operatore `new` alloca memoria per il nuovo oggetto e il costruttore della classe viene invocato."
    },
    {
        question: "Quale modificatore di accesso permette l'accesso a membri della stessa classe, sottoclassi (anche in pacchetti diversi) e classi nello stesso package?",
        options: ["public", "private", "protected", "default"],
        answer: "protected",
        explanation: "I membri `protected` sono accessibili dalla classe in cui sono dichiarati, da tutte le classi nello stesso package e da tutte le sottoclassi (anche se si trovano in pacchetti diversi). `public` è il più permissivo, `private` il più restrittivo, `default` solo all'interno del package."
    },
    {
        question: "Qual è lo scopo del garbage collector in Java?",
        options: ["Gestire l'allocazione della memoria.", "Rimuovere oggetti non più referenziati dalla memoria.", "Eseguire la compilazione del codice.", "Ottimizzare le prestazioni del CPU."],
        answer: "Rimuovere oggetti non più referenziati dalla memoria.",
        explanation: "Il Garbage Collector (GC) in Java è un processo automatico che identifica e recupera la memoria occupata da oggetti che non sono più referenziati (cioè, non possono più essere raggiunti dal codice in esecuzione). Questo libera la memoria per nuovi oggetti, semplificando la gestione della memoria per gli sviluppatori."
    },
    {
        question: "Quale tipo di polimorfismo si ottiene con l'overloading dei metodi?",
        options: ["Polymorphism at runtime", "Polymorphism at compile-time", "Inheritance polymorphism", "Interface polymorphism"],
        answer: "Polymorphism at compile-time",
        explanation: "L'overloading dei metodi (metodi con lo stesso nome ma firme diverse nella stessa classe) è un esempio di polimorfismo a tempo di compilazione (o 'static polymorphism'). Il compilatore determina quale metodo overloaded chiamare in base al numero e al tipo degli argomenti passati. Il polimorfismo a runtime si ottiene con l'overriding dei metodi."
    },
    {
        question: "Qual è l'output del seguente codice?\n```java\npublic class StaticTest {\n    static int x = 10;\n    public static void main(String[] args) {\n        System.out.println(x);\n    }\n}\n```",
        options: ["null", "0", "10", "Errore di compilazione"],
        answer: "10",
        explanation: "`x` è una variabile statica (`static int x = 10;`), il che significa che appartiene alla classe stessa, non a un'istanza specifica. Può essere accessibile direttamente da altri metodi statici (come `main`) usando il nome della variabile o, in questo caso, implicitamente all'interno della stessa classe. Il suo valore è stato inizializzato a 10."
    },
    {
        question: "Quale delle seguenti affermazioni è vera riguardo alle interfacce in Java?",
        options: ["Possono contenere costruttori.", "Possono essere istanziate.", "Possono contenere solo metodi astratti (fino a Java 8).", "Tutte le variabili in un'interfaccia sono implicitamente private."],
        answer: "Possono contenere solo metodi astratti (fino a Java 8).",
        explanation: "Fino a Java 8, le interfacce potevano contenere solo dichiarazioni di metodi astratti (senza corpo) e costanti (`public static final`). Non possono contenere costruttori e non possono essere istanziate direttamente. Da Java 8, le interfacce possono anche avere metodi `default` e `static` con implementazione."
    },
    {
        question: "Quale metodo di String rimuove gli spazi bianchi all'inizio e alla fine di una stringa?",
        options: ["trim()", "strip() (disponibile da Java 11)", "removeSpaces()", "Entrambi A e B sono validi (A per versioni precedenti, B per Java 11+)."],
        answer: "Entrambi A e B sono validi (A per versioni precedenti, B per Java 11+).",
        explanation: "`trim()` è disponibile da tutte le versioni e rimuove spazi bianchi definiti dal carattere ASCII U+0020. `strip()` è stato introdotto in Java 11 e è più completo, rimuovendo tutti i tipi di spazi bianchi definiti dallo standard Unicode (inclusi caratteri come newlines). Entrambi sono validi a seconda della versione di Java e del tipo di 'spazi bianchi' da rimuovere."
    },
    {
        question: "Quale delle seguenti è una valida dichiarazione per la gestione di un'eccezione FileNotFoundException?",
        options: ["catch (Exception e)", "catch (FileNotFoundException e)", "throws FileNotFoundException (se il metodo non la gestisce)", "Tutte le precedenti (A e B per catch, C per throws)."],
        answer: "Tutte le precedenti (A e B per catch, C per throws).",
        explanation: "Si può catturare l'eccezione specifica (`FileNotFoundException`), un tipo di eccezione più generico (`Exception`, che è la superclasse di tutte le eccezioni), o dichiarare che un metodo può sollevare l'eccezione usando `throws FileNotFoundException` nella sua firma, delegando la gestione al chiamante."
    },
    {
        question: "Qual è l'output del seguente codice?\n```java\npublic class SwitchTest {\n    public static void main(String[] args) {\n        int day = 2;\n        switch (day) {\n            case 1: System.out.print(\"Monday\");\n            case 2: System.out.print(\"Tuesday\");\n            case 3: System.out.print(\"Wednesday\");\n            default: System.out.print(\"Invalid\");\n        }\n    }\n}\n```",
        options: ["Tuesday", "TuesdayWednesdayInvalid", "Invalid", "Errore di compilazione"],
        answer: "TuesdayWednesdayInvalid",
        explanation: "Senza l'istruzione `break` alla fine di ogni blocco `case`, Java esegue tutti i `case` successivi (fenomeno noto come 'fall-through') una volta che una corrispondenza è stata trovata. Poiché `day` è 2, viene stampato 'Tuesday', poi 'Wednesday', e infine 'Invalid' dal blocco `default`."
    },
    {
        question: "Quale delle seguenti è una caratteristica della classe ArrayList?",
        options: ["Ha una dimensione fissa.", "Permette solo elementi unici.", "L'accesso agli elementi per indice è veloce.", "Non supporta l'aggiunta di elementi dopo la creazione."],
        answer: "L'accesso agli elementi per indice è veloce.",
        explanation: "`ArrayList` è una List Collection basata su array ridimensionabili. Sebbene la sua dimensione sia dinamica (non fissa), l'accesso a un elemento tramite il suo indice (`get(index)`) è un'operazione a tempo costante (O(1)), rendendola molto efficiente per questo tipo di operazione. Permette duplicati e la sua dimensione può cambiare."
    },
    {
        question: "Quale dei seguenti operatori è un operatore unario?",
        options: ["+ (addizione)", "- (sottrazione)", "++ (incremento)", "* (moltiplicazione)"],
        answer: "++ (incremento)",
        explanation: "Un operatore unario opera su un singolo operando. `++` (incremento) e `--` (decremento) sono esempi di operatori unari. `+`, `-`, `*` sono operatori binari quando usati per addizione, sottrazione e moltiplicazione, poiché richiedono due operandi."
    },
    {
        question: "Cosa significa il termine 'JRE'?",
        options: ["Java Runtime Environment", "Java Remote Emulator", "Java Resource Editor", "Java Runtime Engine"],
        answer: "Java Runtime Environment",
        explanation: "JRE sta per Java Runtime Environment. È un pacchetto software che contiene gli strumenti necessari per eseguire applicazioni Java, inclusa la Java Virtual Machine (JVM) e le librerie di classi standard (API Java), ma non gli strumenti di sviluppo come il compilatore."
    },
    {
        question: "Qual è l'output del seguente codice?\n```java\npublic class ShortCircuit {\n    public static void main(String[] args) {\n        int a = 5;\n        if (a < 10 || a++ > 5) {\n            System.out.println(\"True\");\n        }\n        System.out.println(a);\n    }\n}\n```",
        options: ["True, 5", "True, 6", "True, 10", "Errore di compilazione"],
        answer: "True, 5",
        explanation: "L'operatore `||` (OR logico) in Java è 'short-circuit'. Se la prima parte dell'espressione (`a < 10`) è vera, la seconda parte (`a++ > 5`) non viene valutata affatto. Poiché `5 < 10` è vera, `a++` non viene eseguito, e quindi `a` rimane 5. Viene stampato 'True' e poi il valore di `a` (5)."
    },
    {
        question: "Quale delle seguenti affermazioni è vera riguardo alla classe HashMap?",
        options: ["Mantiene l'ordine di inserimento.", "Permette chiavi duplicate.", "Non permette chiavi null.", "Mappa chiavi a valori."],
        answer: "Mappa chiavi a valori.",
        explanation: "`HashMap` è una classe che implementa l'interfaccia `Map`, che per definizione mappa chiavi uniche a valori. Non garantisce l'ordine di inserimento (usa un hash per la memorizzazione e il recupero veloce), non permette chiavi duplicate (una nuova associazione per una chiave esistente sovrascrive il valore precedente), e *permette una singola chiave `null`*."
    },
    {
        question: "Quale metodo viene chiamato dal Garbage Collector prima che un oggetto venga rimosso dalla memoria?",
        options: ["delete()", "remove()", "finalize()", "destroy()"],
        answer: "finalize()",
        explanation: "Il metodo `finalize()` (un metodo protetto della classe `Object`) viene chiamato dal Garbage Collector (GC) prima che un oggetto venga definitivamente rimosso dalla memoria, per consentire operazioni di pulizia delle risorse non Java. Tuttavia, è importante notare che `finalize()` è considerato deprecato e sconsigliato a causa della sua imprevedibilità e delle performance negative; si preferiscono blocchi `try-with-resources` o altri meccanismi di gestione delle risorse."
    },
    {
        question: "Qual è il risultato dell'espressione (float) 5 / 2?",
        options: ["2", "2.0", "2.5", "Errore di compilazione"],
        answer: "2.5",
        explanation: "Il casting `(float) 5` converte l'intero 5 in un float (5.0f). A questo punto, la divisione diventa una divisione in virgola mobile (`5.0f / 2`), il cui risultato è `2.5`. Se non ci fosse stato il casting, la divisione sarebbe stata una divisione intera (`5 / 2`), che avrebbe prodotto `2`."
    }
];
// ---------------------------------------------------

// Variabili per gestire lo stato del quiz
let currentQuestionIndex = 0;
let score = 0;
let selectedOptionButton = null; // Per tenere traccia del pulsante selezionato per la domanda corrente
let userAnswers = []; // Array per memorizzare le risposte dell'utente per la revisione

// Riferimenti agli elementi HTML
const quizScreen = document.getElementById('quiz-screen');
const resultScreen = document.getElementById('result-screen');
const questionNumber = document.getElementById('question-number');
const questionText = document.getElementById('question-text');
const optionsContainer = document.getElementById('options-container');
const nextButton = document.getElementById('next-button');
const finalScoreSpan = document.getElementById('final-score');
const totalQuestionsSpan = document.getElementById('total-questions');
const resultPercentageSpan = document.getElementById('result-percentage');
const resultMessage = document.getElementById('result-message');
const restartButton = document.getElementById('restart-button');
const reviewContainer = document.getElementById('review-container');
const reviewList = document.getElementById('review-list');

// Funzione per avviare il quiz o mostrare la prossima domanda
function startQuiz() {
    currentQuestionIndex = 0;
    score = 0;
    userAnswers = []; // Resetta le risposte dell'utente
    quizScreen.style.display = 'block';
    resultScreen.style.display = 'none';
    reviewContainer.style.display = 'none';
    nextButton.textContent = 'Prossima Domanda';
    nextButton.disabled = true;
    showQuestion();
}

// Funzione per visualizzare una domanda
function showQuestion() {
    resetState(); // Pulisce le classi e i listener precedenti

    const question = questions[currentQuestionIndex];
    questionNumber.textContent = `Domanda ${currentQuestionIndex + 1} di ${questions.length}`;

    // Per supportare i blocchi di codice, usa innerHTML e un po' di manipolazione
    let formattedQuestionText = question.question.replace(/```java\n([\s\S]*?)\n```/g, (match, code) => {
        return `<pre><code class="code-snippet">${code.trim()}</code></pre>`;
    });
    questionText.innerHTML = formattedQuestionText;


    // Crea i pulsanti per le opzioni
    question.options.forEach(option => {
        const button = document.createElement('button');
        button.textContent = option;
        button.classList.add('option-button');
        button.addEventListener('click', () => selectAnswer(button, option, question.answer));
        optionsContainer.appendChild(button);
    });
}

// Funzione per selezionare una risposta
function selectAnswer(button, selectedOption, correctAnswer) {
    // Se un'opzione è già stata selezionata per questa domanda, non fare nulla
    if (selectedOptionButton) {
        return;
    }

    selectedOptionButton = button; // Memorizza il pulsante selezionato

    const isCorrect = (selectedOption === correctAnswer);

    if (isCorrect) {
        button.classList.add('correct');
        score++;
    } else {
        button.classList.add('incorrect');
        // Trova e evidenzia la risposta corretta se l'utente ha sbagliato
        Array.from(optionsContainer.children).forEach(optButton => {
            if (optButton.textContent === correctAnswer) {
                optButton.classList.add('correct');
            }
        });
    }

    // Registra la risposta dell'utente
    userAnswers.push({
        questionIndex: currentQuestionIndex,
        userSelected: selectedOption,
        isCorrect: isCorrect
    });

    // Disabilita tutti i pulsanti delle opzioni dopo la selezione
    Array.from(optionsContainer.children).forEach(optButton => {
        optButton.disabled = true;
    });

    nextButton.disabled = false; // Abilita il pulsante "Prossima Domanda"
}

// Funzione per passare alla prossima domanda o mostrare i risultati
function handleNextButton() {
    currentQuestionIndex++;
    selectedOptionButton = null; // Resetta il pulsante selezionato per la prossima domanda

    if (currentQuestionIndex < questions.length) {
        showQuestion();
    } else {
        showResult();
    }
}

// Funzione per resettare lo stato della UI prima di mostrare una nuova domanda
function resetState() {
    while (optionsContainer.firstChild) {
        optionsContainer.removeChild(optionsContainer.firstChild);
    }
    nextButton.disabled = true; // Disabilita il pulsante "Prossima Domanda"
}

// Funzione per mostrare la schermata dei risultati
function showResult() {
    quizScreen.style.display = 'none';
    resultScreen.style.display = 'block';
    finalScoreSpan.textContent = score;
    totalQuestionsSpan.textContent = questions.length;

    const percentage = (score / questions.length) * 100;
    resultPercentageSpan.textContent = `(${percentage.toFixed(2)}%)`; // Mostra la percentuale con 2 decimali

    let message = "";
    if (percentage === 100) {
        message = "Congratulazioni! Hai superato l'esame con un punteggio perfetto!";
    } else if (percentage >= 70) {
        message = "Ottimo lavoro! Hai superato l'esame con una buona performance.";
    } else if (percentage >= 50) {
        message = "Hai superato l'esame, ma c'è spazio per migliorare!";
    } else {
        message = "Non scoraggiarti! Rivedi gli argomenti e riprova per superare l'esame.";
    }
    resultMessage.textContent = message;

    displayReview(); // Mostra la sezione di revisione
}

// Funzione per visualizzare la revisione delle risposte
function displayReview() {
    reviewList.innerHTML = ''; // Pulisci la lista precedente
    reviewContainer.style.display = 'block'; // Mostra il contenitore di revisione

    userAnswers.forEach((answerData, index) => {
        const question = questions[answerData.questionIndex];
        const listItem = document.createElement('li');

        // Domanda
        const questionP = document.createElement('p');
        let formattedQuestionText = question.question.replace(/```java\n([\s\S]*?)\n```/g, (match, code) => {
            return `<pre><code class="code-snippet">${code.trim()}</code></pre>`;
        });
        questionP.innerHTML = `<strong>${index + 1}.</strong> ${formattedQuestionText}`;


        // Tua risposta
        const userAnswerP = document.createElement('p');
        userAnswerP.classList.add('user-answer');
        userAnswerP.textContent = `La tua risposta: ${answerData.userSelected}`;
        if (answerData.isCorrect) {
            userAnswerP.classList.add('correct');
        } else {
            userAnswerP.classList.add('incorrect');
            // Risposta corretta (solo se l'utente ha sbagliato)
            const correctAnswerP = document.createElement('p');
            correctAnswerP.classList.add('correct-answer');
            correctAnswerP.textContent = `Risposta corretta: ${question.answer}`;
            listItem.appendChild(correctAnswerP);
        }

        // Spiegazione
        const explanationP = document.createElement('p');
        explanationP.classList.add('explanation');
        explanationP.innerHTML = `<strong>Spiegazione:</strong> ${question.explanation}`;

        listItem.appendChild(questionP);
        listItem.appendChild(userAnswerP);
        listItem.appendChild(explanationP); // Aggiungi la spiegazione

        reviewList.appendChild(listItem);
    });
}


// Event Listeners
nextButton.addEventListener('click', handleNextButton);
restartButton.addEventListener('click', startQuiz);

// Avvia il quiz quando la pagina viene caricata
document.addEventListener('DOMContentLoaded', startQuiz);
