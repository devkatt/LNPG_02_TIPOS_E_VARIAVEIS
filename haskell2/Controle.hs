import Control.Monad (replicateM)

main :: IO ()
main = do
    putStrLn "Quantos passageiros tem na fila? "
    numberPassenger <- readLn :: IO Int
    _ <- getLine -- Consumir a quebra de linha pendente após a leitura do número

    -- Passenger data
    let rg = "nao possui" -- String ou "Nao possui"
        pass = "nao possui" -- String ou "Nao possui"
        rgDate = "" -- "DD/MM/AAAA"
        passDate = "" -- "DD/MM/AAAA"
        seat = "" -- "A12"

    passengers <- replicateM numberPassenger $ do
        putStrLn "\nDigite RG ou 'Nao possui': "
        rgInput <- getLine

        putStrLn "Digite seu Passagem ou 'Nao possui': "
        passInput <- getLine

        putStrLn "Digite a data de nascimento do seu RG: "
        rgDateInput <- getLine

        putStrLn "Digite a data de nascimento do seu Passaporte: "
        passDateInput <- getLine

        putStrLn "Digite seu assento no Avião: "
        seatInput <- getLine

        return (rgInput, passInput, rgDateInput, passDateInput, seatInput)

    mapM_ processPassenger (zip [1..] passengers)

processPassenger :: (Int, (String, String, String, String, String)) -> IO ()
processPassenger (i, (rg, pass, rgDate, passDate, seat)) = do
    if rg == "nao possui"
        then putStrLn $ "A saída é nessa direção passageiro n°" ++ show i
        else if pass == "nao possui"
            then putStrLn "A recepção é nessa direção"
            else if rgDate /= passDate
                then putStrLn "190"
                else putStrLn $ "Seu assento é " ++ seat ++ ", tenha um bom dia"
