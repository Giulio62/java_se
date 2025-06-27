package day12;

public class Data {

    // Variabili di istanza (membri della classe) per memorizzare giorno, mese e anno
    private int day;
    private int month;
    private int year;

    // Costruttore per inizializzare un oggetto Data
    public Data(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Metodi getter per accedere ai valori delle variabili di istanza
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    // Metodi setter per modificare i valori delle variabili di istanza
    public void setDay(int aDay) {
        this.day = aDay;
    }

    public void setMonth(int aMonth) {
        this.month = aMonth;
    }

    public void setYear(int aYear) {
        this.year = aYear;
    }

    // Metodo per confrontare due oggetti Data
    public Boolean isEqual(Data date) {
        return this.day == date.day &&
               this.month == date.month &&
               this.year == date.year;
    }

    public static void main(String[] args) {
        // Esempio di utilizzo della classe Data
        Data today = new Data(29, 5, 2025);
        System.out.println("Oggi è il: " + today.getDay() + "/" + today.getMonth() + "/" + today.getYear());

        Data anotherDay = new Data(1, 1, 2025);
        System.out.println("Un altro giorno è: " + anotherDay.getDay() + "/" + anotherDay.getMonth() + "/" + anotherDay.getYear());

        System.out.println("I due giorni sono uguali? " + today.isEqual(anotherDay));

        today.setDay(30);
        System.out.println("Nuovo giorno per 'today': " + today.getDay());
    }
}