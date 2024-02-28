import java.util.Scanner;

public class Vestibular {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int int_quantify_participants;
        String current_name_participant;
        float current_note_participant;
        
        float best_note = 0.0f;
        String name_participant_from_best_note = "";
        float worst_note = 10.0f;
        String name_participant_from_worst_note = "";
        
        int quantify_participants_higher_achievement_half = 0;

        System.out.println("Insira a quantidade de participantes:");
        int_quantify_participants = scanner.nextInt();

        String[] list_all_names = new String[int_quantify_participants];
        float[] list_all_notes = new float[int_quantify_participants];

        for (int i = 0; i < int_quantify_participants; i++) {
            System.out.printf("Insira o nome do participante. Ainda resta(m): %d.%n", (int_quantify_participants - i));
            current_name_participant = scanner.next();

            System.out.printf("Insira a nota do %s.%n", current_name_participant);
            current_note_participant = scanner.nextFloat();

            if (current_note_participant > best_note) {
                best_note = current_note_participant;
                name_participant_from_best_note = current_name_participant;
            }

            if (current_note_participant < worst_note) {
                worst_note = current_note_participant;
                name_participant_from_worst_note = current_name_participant;
            }

            if (current_note_participant > 5) {
                quantify_participants_higher_achievement_half++;
            }

            list_all_names[i] = current_name_participant;
            list_all_notes[i] = current_note_participant;
        }

        for (int i = 0; i < int_quantify_participants; i++) {
            System.out.printf("Participante: %s ---> Nota = %.2f%n", list_all_names[i], list_all_notes[i]);
        }

        System.out.printf("Maior nota = %.2f --> %s%n", best_note, name_participant_from_best_note);
        System.out.printf("Menor nota = %.2f --> %s%n", worst_note, name_participant_from_worst_note);
        System.out.printf("Aproveitamento de participantes com nota superior à 5 (em porcentagem) = %.1f%%%n",
                (quantify_participants_higher_achievement_half * 100.0) / int_quantify_participants);
        
        scanner.close();
    }
}