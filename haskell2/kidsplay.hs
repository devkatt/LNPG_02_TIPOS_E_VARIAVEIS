import Text.Printf

main :: IO ()
main = do
    putStrLn "Número de jogos vendidos por Catarina: "
    quantifyGamesCatarinaSold <- readLn :: IO Int

    let priceGame = 19.90
        catarinasBasePayment = (priceGame / 2) * fromIntegral quantifyGamesCatarinaSold
        quantifyBonusCatarinas = quantifyGamesCatarinaSold `div` 15
        catarinasBonusPayment = (priceGame * fromIntegral quantifyBonusCatarinas) * 0.08

    printf "Valor arrecadado = %.2f\nBonus = %.2f\nPagamento Catarina = %.2f\n"
        (priceGame * fromIntegral quantifyGamesCatarinaSold)
        catarinasBonusPayment
        (catarinasBasePayment + catarinasBonusPayment)
