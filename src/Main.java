import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pobranie rozmiaru tablicy
        System.out.print("Podaj rozmiar tablicy: ");
        int n = scanner.nextInt();

        // Utworzenie tablicy
        int[] tablica = new int[n];

        // Wczytanie elementów do tablicy
        System.out.println("Wprowadź posortowane elementy tablicy:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            tablica[i] = scanner.nextInt();
        }

        // Pobranie elementu do wyszukania
        System.out.print("Podaj liczbę do wyszukania: ");
        int x = scanner.nextInt();

        // Wykonanie wyszukiwania binarnego
        int wynik = wyszukiwanieBinarne(tablica, x);

        // Wyświetlenie wyniku
        if (wynik != -1) {
            System.out.println("Element " + x + " znajduje się na indeksie " + wynik + ".");
        } else {
            System.out.println("Element " + x + " nie znajduje się w tablicy.");
        }

        scanner.close();
    }

    // Funkcja wykonująca wyszukiwanie binarne
    public static int wyszukiwanieBinarne(int[] tablica, int x) {
        int lewy = 0;
        int prawy = tablica.length - 1;

        while (lewy <= prawy) {
            int srodek = lewy + (prawy - lewy) / 2;

            // Sprawdzenie, czy element jest w środku
            if (tablica[srodek] == x) {
                return srodek;
            }

            // Jeśli x jest większe, ignorujemy lewą połowę
            if (tablica[srodek] < x) {
                lewy = srodek + 1;
            }
            // Jeśli x jest mniejsze, ignorujemy prawą połowę
            else {
                prawy = srodek - 1;
            }
        }

        // Jeśli elementu nie znaleziono
        return -1;
    }
}