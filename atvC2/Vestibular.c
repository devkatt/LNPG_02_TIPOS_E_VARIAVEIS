#include <stdio.h>

int main() {
    int int_quantify_participants;
    char current_name_participant[50];
    float current_note_participant;

    float best_note = 0.0f;
    char name_participant_from_best_note[50];
    float worst_note = 10.0f;
    char name_participant_from_worst_note[50];

    int quantify_participants_higher_achievement_half = 0;

    printf("Insira a quantidade de participantes: ");
    scanf("%d", &int_quantify_participants);

    char list_all_names[int_quantify_participants][50];
    float list_all_notes[int_quantify_participants];

    for (int i = 0; i < int_quantify_participants; i++) {
        printf("Insira o nome do participante. Ainda resta(m): %d.\n", (int_quantify_participants - i));
        scanf("%s", current_name_participant);

        printf("Insira a nota do %s: ", current_name_participant);
        scanf("%f", &current_note_participant);

        if (current_note_participant > best_note) {
            best_note = current_note_participant;
            strcpy(name_participant_from_best_note, current_name_participant);
        }

        if (current_note_participant < worst_note) {
            worst_note = current_note_participant;
            strcpy(name_participant_from_worst_note, current_name_participant);
        }

        if (current_note_participant > 5) {
            quantify_participants_higher_achievement_half++;
        }

        strcpy(list_all_names[i], current_name_participant);
        list_all_notes[i] = current_note_participant;
    }

    for (int i = 0; i < int_quantify_participants; i++) {
        printf("Participante: %s ---> Nota = %.2f\n", list_all_names[i], list_all_notes[i]);
    }

    printf("Maior nota = %.2f --> %s\n", best_note, name_participant_from_best_note);
    printf("Menor nota = %.2f --> %s\n", worst_note, name_participant_from_worst_note);
    printf("Aproveitamento de participantes com nota superior à 5 (em porcentagem) = %.1f%%\n",
            (quantify_participants_higher_achievement_half * 100.0) / int_quantify_participants);

    return 0;
}
