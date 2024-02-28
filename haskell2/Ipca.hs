import Text.Printf
import Control.Monad

main :: IO ()
main = do
    let readDouble :: String -> Double
        readDouble = read

    printf "Digite o mês (fim para parar): "
    entradaMes <- getLine
    let loop contadorInput arrayMes arrayAno arrayValorIpca = do
        if entradaMes == "fim"
            then return (contadorInput, arrayMes, arrayAno, arrayValorIpca)
            else do
                let valorMes = read entradaMes
                printf "Digite o ano: "
                valorAno <- readLn :: IO Int
                printf "Digite o valor do IPCA: "
                valorIpca <- readLn :: IO Double
                loop (contadorInput + 1) (arrayMes ++ [valorMes]) (arrayAno ++ [valorAno]) (arrayValorIpca ++ [valorIpca])

    (contadorInput, arrayMes, arrayAno, arrayValorIpca) <- loop 0 [] [] []

    let (maiorIpca, indexMesMaior, indexAnoMaior) = foldl (\(maior, im, ia) (i, v) ->
            if v > maior then (v, i, ia) else (maior, im, ia)
        ) (0, 0, 0) $ zip [0..] arrayValorIpca

        (menorIpca, indexMesMenor, indexAnoMenor) = foldl (\(menor, im, ia) (i, v) ->
            if v < menor then (v, i, ia) else (menor, im, ia)
        ) (1/0, 0, 0) $ zip [0..] arrayValorIpca

        soma = sum arrayValorIpca
        media = soma / fromIntegral contadorInput

    printf "O menor valor de IPCA foi de %.2f, correspondente ao mês %d do ano %d\n" menorIpca indexMesMenor indexAnoMenor
    printf "O maior valor de IPCA foi de %.2f, correspondente ao mês %d do ano %d\n" maiorIpca indexMesMaior indexAnoMaior
    printf "A média dos valores de IPCA foi de %.2f\n" media
