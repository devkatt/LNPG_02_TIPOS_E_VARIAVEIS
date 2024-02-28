import Text.Printf
import Control.Monad

main :: IO ()
main = do
    printf "Insira a quantidade de participantes: "
    intQuantifyParticipants <- readLn :: IO Int

    let quantifyParticipantsHalf :: Int -> Float -> Float
        quantifyParticipantsHalf acc note = if note > 5 then acc + 1 else acc

    (listAllNames, listAllNotes) <- foldM (\(names, notes) i -> do
        printf "Insira o nome do participante. Ainda resta(m): %d.\n" (intQuantifyParticipants - i)
        currentNameParticipant <- getLine

        printf "Insira a nota do %s: " currentNameParticipant
        currentNoteParticipant <- readLn :: IO Float

        let names' = names ++ [currentNameParticipant]
            notes' = notes ++ [currentNoteParticipant]

        return (names', notes')
      ) ([], []) [1..intQuantifyParticipants]

    let bestNote = maximum listAllNotes
        nameParticipantFromBestNote = fst $ head $ filter (\(_, note) -> note == bestNote) $ zip listAllNames listAllNotes
        worstNote = minimum listAllNotes
        nameParticipantFromWorstNote = fst $ head $ filter (\(_, note) -> note == worstNote) $ zip listAllNames listAllNotes
        quantifyParticipantsHigherAchievementHalf = foldl quantifyParticipantsHalf 0 listAllNotes

    forM_ (zip listAllNames listAllNotes) $ \(name, note) ->
        printf "Participante: %s ---> Nota = %.2f\n" name note

    printf "Maior nota = %.2f --> %s\n" bestNote nameParticipantFromBestNote
    printf "Menor nota = %.2f --> %s\n" worstNote nameParticipantFromWorstNote
    printf "Aproveitamento de participantes com nota superior à 5 (em porcentagem) = %.1f%%\n"
        ((quantifyParticipantsHigherAchievementHalf * 100.0) / fromIntegral intQuantifyParticipants)
